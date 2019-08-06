package model.tra;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dbclose.util.CloseUtil;

public class TradeBoardDAO {
	
	 private DataSource dataFactory;
	 private PreparedStatement pstmt;
	 private ResultSet rs=null;
	 private Connection conn=null;

	private static TradeBoardDAO instance = new TradeBoardDAO();
	
	public static TradeBoardDAO getInstance() {
		if(instance==null)	instance=new TradeBoardDAO();
		return instance;
	}
	
	public TradeBoardDAO() {	}
	
	public Connection getConnection() throws Exception {
	
		
		Context initCtx = new InitialContext();
		DataSource  ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/USADB");
		
		return ds.getConnection();
	}
	public int getBoardListCount(HashMap<String, Object> listOpt)
    {
        int result = 0;
        String opt = (String)listOpt.get("opt"); // 寃��깋議곌굔
        String condition = (String)listOpt.get("condition"); // 寃��깋�궡�슜
        
        
        try {
            conn = getConnection();
            StringBuffer sql = new StringBuffer();
            
            if(opt == null)   //�씪諛섍��깋
            {
                sql.append("select count(*) from MEMBER_BOARD");
                pstmt = conn.prepareStatement(sql.toString());
                
                //�뒪�듃留곷쾭�띁 鍮꾩썙二쇰뒗 紐낅졊�뼱.
                sql.delete(0, sql.toString().length());
            }
            else if(opt.equals("0")) // �젣紐⑷��깋
            {
                sql.append("select count(*) from MEMBER_BOARD where BOARD_SUBJECT like ?");
                pstmt = conn.prepareStatement(sql.toString());
                pstmt.setString(1, '%'+condition+'%');
                
                sql.delete(0, sql.toString().length());
            }
            else if(opt.equals("1")) // �궡�슜寃��깋
            {
                sql.append("select count(*) from MEMBER_BOARD where BOARD_CONTENT like ?");
                pstmt = conn.prepareStatement(sql.toString());
                pstmt.setString(1, '%'+condition+'%');
                
                sql.delete(0, sql.toString().length());
            }
            else if(opt.equals("2")) // �젣紐�+�궡�슜寃��깋
            {
                sql.append("select count(*) from MEMBER_BOARD ");
                sql.append("where BOARD_SUBJECT like ? or BOARD_CONTENT like ?");
                pstmt = conn.prepareStatement(sql.toString());
                pstmt.setString(1, '%'+condition+'%');
                pstmt.setString(2, '%'+condition+'%');
                
                sql.delete(0, sql.toString().length());
            }
            else if(opt.equals("3")) // 湲��벖�씠 寃��깋
            {
                sql.append("select count(*) from MEMBER_BOARD where BOARD_ID like ?");
                pstmt = conn.prepareStatement(sql.toString());
                pstmt.setString(1, '%'+condition+'%');
                
                sql.delete(0, sql.toString().length());
            }
            
            rs = pstmt.executeQuery();
            if(rs.next())    result = rs.getInt(1);
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }finally {
        	
        	CloseUtil.close(rs);
			CloseUtil.close(pstmt);
			CloseUtil.close(conn); 
        }
        return result;
    } // end getBoardListCount


	
	 public boolean boardInsert(TradeBoardVO vo)
	    {
	        boolean result = false;
	        
	        try {
	            conn = getConnection();
	            
	            // 占쎌쁽占쎈짗 �뚣끇而좑옙�뱽 false嚥∽옙 占쎈립占쎈뼄.
	            conn.setAutoCommit(false);
	            
	            StringBuffer sql = new StringBuffer();
	            sql.append("INSERT INTO MEMBER_BOARD");
	            sql.append("(BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE");
	            sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_COUNT, BOARD_DATE)");
	            sql.append(" VALUES(?,?,?,?,?,?,?,?,?,sysdate)");
	 
	            int num = vo.getBoard_num();
	 
	            pstmt = conn.prepareStatement(sql.toString());
	            pstmt.setInt(1, num);
	            pstmt.setString(2, vo.getBoard_id());
	            pstmt.setString(3, vo.getBoard_subject());
	            pstmt.setString(4, vo.getBoard_content());
	            pstmt.setString(5, vo.getBoard_file());
	            pstmt.setInt(6, num);
	            pstmt.setInt(7, 0);
	            pstmt.setInt(8, 0);
	            pstmt.setInt(9, 0);
	            
	            int flag = pstmt.executeUpdate();
	            if(flag > 0){
	                result = true;
	                //媛믪씠 李몄씪�뻹留� ���옣�썑 而ㅻ컠
	                conn.commit(); 
	            }
	            
	        } catch (Exception e) {
	            try {
	                conn.rollback();
	            } catch (SQLException sqle) {
	                sqle.printStackTrace();
	            } 
	            throw new RuntimeException(e.getMessage());
	        }finally {
	        	
	        	CloseUtil.close(rs);
				CloseUtil.close(pstmt);
				CloseUtil.close(conn); 
	        }
	        return result;    
	    } // end boardInsert();
	    
	    
	    // 疫뀐옙筌뤴뫖以� 揶쏉옙占쎌죬占쎌궎疫뀐옙
	    public ArrayList<TradeBoardVO> getBoardList(HashMap<String, Object> listOpt) throws UnsupportedEncodingException
	    {
	        ArrayList<TradeBoardVO> list = new ArrayList<TradeBoardVO>();
	        
	        String opt = (String)listOpt.get("opt"); // 議곌굔
	        String condition = (String)listOpt.get("condition"); // �궡�슜
	        int start = (Integer)listOpt.get("start"); // �떆�옉湲�踰덊샇
	        int end=5;         //�븳踰덉뿉 蹂댁뿬以�  湲�踰덊샇
	        int endNum=start+end-1;
	        System.out.println(condition+"�뚢뫀逾믭옙�� 占쎌뿯占쎈빍占쎈뼄.");
	         try {
	            conn = getConnection();
	            StringBuffer sql = new StringBuffer();
	            
	            // 疫뀐옙筌뤴뫖以� 占쎌읈筌ｋ�占쏙옙 癰귣똻肉т빳占� 占쎈르
	            if(opt == null)
	            {
	                // BOARD_RE_REF(域밸챶竊숃린�뜇�깈)占쎌벥 占쎄땀�뵳�눘媛먲옙�떄 占쎌젟占쎌졊 占쎌뜎 占쎈짗占쎌뵬占쎈립 域밸챶竊숃린�뜇�깈占쎌뵬 占쎈르占쎈뮉
	                // BOARD_RE_SEQ(占쎈뼗癰귨옙疫뀐옙 占쎈떄占쎄퐣)占쎌벥 占쎌궎�뵳袁⑷컧占쎈떄占쎌몵嚥∽옙 占쎌젟占쎌졊 占쎈립 占쎌뜎占쎈퓠
	                // 10揶쏆뮇�벥 疫뀐옙占쎌뱽 占쎈립 占쎌넅筌롫똻肉� 癰귣똻肉т틠�눖�뮉(start甕곕뜆�럮 �겫占쏙옙苑� start+9繹먮슣占�) �뜎�눖�봺
	                // desc : 占쎄땀�뵳�눘媛먲옙�떄, asc : 占쎌궎�뵳袁⑷컧占쎈떄 ( 占쎄문占쎌셽 揶쏉옙占쎈뮟 )
	                sql.append("select * from ");
	                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
	                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_COUNT, BOARD_RE_REF");
	                sql.append(", BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_DATE ");
	                sql.append("FROM");
	                sql.append(" (select * from MEMBER_BOARD order by BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
	                sql.append("where rnum>=? and rnum<=?");
	                
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setInt(1, start);
	                pstmt.setInt(2, endNum);
	                
	                // StringBuffer�몴占� �뜮袁⑹뒲占쎈뼄.
	                sql.delete(0, sql.toString().length());
	            }
	            else if(opt.equals("0")) // 占쎌젫筌뤴뫗�몵嚥∽옙 野껓옙占쎄퉳
	            {
	                sql.append("select * from ");
	                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
	                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT");
	                sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ");
	                sql.append("FROM ");
	                sql.append("(select * from MEMBER_BOARD where BOARD_SUBJECT like ? ");
	                sql.append("order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
	                sql.append("where rnum>=? and rnum<=?");
	                
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setString(1, "%"+condition+"%");
	                pstmt.setInt(2, start);
	                pstmt.setInt(3, endNum);
	                
	                sql.delete(0, sql.toString().length());
	            }
	            else if(opt.equals("1")) // 占쎄땀占쎌뒠占쎌몵嚥∽옙 野껓옙占쎄퉳
	            {
	                sql.append("select * from ");
	                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
	                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT");
	                sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ");
	                sql.append("FROM ");
	                sql.append("(select * from MEMBER_BOARD where BOARD_CONTENT like ? ");
	                sql.append("order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
	                sql.append("where rnum>=? and rnum<=?");
	                
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setString(1, "%"+condition+"%");
	                pstmt.setInt(2, start);
	                pstmt.setInt(3, endNum);
	                
	                sql.delete(0, sql.toString().length());
	            }
	            else if(opt.equals("2")) // 占쎌젫筌륅옙+占쎄땀占쎌뒠占쎌몵嚥∽옙 野껓옙占쎄퉳
	            {
	                sql.append("select * from ");
	                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
	                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT");
	                sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ");
	                sql.append("FROM ");
	                sql.append("(select * from MEMBER_BOARD where BOARD_SUBJECT like ? OR BOARD_CONTENT like ? ");
	                sql.append("order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
	                sql.append("where rnum>=? and rnum<=?");
	                
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setString(1, "%"+condition+"%");
	                pstmt.setString(2, "%"+condition+"%");
	                pstmt.setInt(3, start);
	                pstmt.setInt(4, endNum);
	                
	                sql.delete(0, sql.toString().length());
	            }
	            else if(opt.equals("3")) // 疫뀐옙占쎈쿀占쎌뵠嚥∽옙 野껓옙占쎄퉳
	            {
	                sql.append("select * from ");
	                sql.append("(select rownum rnum, BOARD_NUM, BOARD_ID, BOARD_SUBJECT");
	                sql.append(", BOARD_CONTENT, BOARD_FILE, BOARD_DATE, BOARD_COUNT");
	                sql.append(", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ ");
	                sql.append("FROM ");
	                sql.append("(select * from MEMBER_BOARD where BOARD_ID like ? ");
	                sql.append("order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc)) ");
	                sql.append("where rnum>=? and rnum<=?");
	                
	                pstmt = conn.prepareStatement(sql.toString());
	                pstmt.setString(1, "%"+condition+"%");
	                pstmt.setInt(2, start);
	                pstmt.setInt(3, endNum);
	                
	                sql.delete(0, sql.toString().length());
	            }
	            
	            rs = pstmt.executeQuery();
	            while(rs.next())
	            {
	                TradeBoardVO vo= new TradeBoardVO();
	                vo.setBoard_num(rs.getInt("BOARD_NUM"));
	                vo.setBoard_id(rs.getString("BOARD_ID"));
	                vo.setBoard_subject(rs.getString("BOARD_SUBJECT"));
	                vo.setBoard_content(rs.getString("BOARD_CONTENT"));
	                vo.setBoard_file(rs.getString("BOARD_FILE"));
	                vo.setBoard_count(rs.getInt("BOARD_COUNT"));
	                vo.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
	                vo.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
	                vo.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
	                vo.setBoard_date(rs.getDate("BOARD_DATE"));
	                list.add(vo);
	            }
	            System.out.println("daO占쎈굶�뵳�됰빍");
	            
	        } catch (Exception e) {
	            throw new RuntimeException(e.getMessage());
	        }finally {
	        	
	        	CloseUtil.close(rs);
				CloseUtil.close(pstmt);
				CloseUtil.close(conn); 
	        }
	        
	        return list;
	    } // end getBoardList

	    
	    //updatecount
	    public boolean updateCount(int boardNum) throws SQLException
		{
			boolean result = false;
			try {
				conn = getConnection();
				
				conn.setAutoCommit(false);
				
				StringBuffer sql = new StringBuffer();
				sql.append("update MEMBER_BOARD set BOARD_COUNT = BOARD_COUNT+1 ");
				sql.append("where BOARD_NUM = ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, boardNum);
				
				int flag=pstmt.executeUpdate();
				if(flag > 0){
					result = true;
					conn.commit(); // 占싹뤄옙占� 커占쏙옙
				}	
			} catch (Exception e) {
				try {
					conn.rollback(); // 
					System.out.println("濡ㅻ갚�릱�뼱�뿬");
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
				throw new RuntimeException(e.getMessage());
			}
			CloseUtil.close(rs);
			CloseUtil.close(pstmt);
			CloseUtil.close(conn); 
			
			return result;
		} // end updateCount
	    
	    public TradeBoardVO getDetail(int boardNum) throws SQLException
		{	
	    	System.out.println(boardNum);
	    	TradeBoardVO board = new TradeBoardVO();
			try {
				conn = getConnection();
				StringBuffer sql = new StringBuffer();
				sql.append("select * from MEMBER_BOARD where BOARD_NUM = ?");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, boardNum);
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
				System.out.println("rs.�븞�뿉�엳�뼱�슂"+boardNum);
					board.setBoard_num(boardNum);
					board.setBoard_id(rs.getString("BOARD_ID"));
					board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
					board.setBoard_content(rs.getString("BOARD_CONTENT"));
					board.setBoard_file(rs.getString("BOARD_FILE"));
					board.setBoard_count(rs.getInt("BOARD_COUNT"));
					board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
					board.setBoard_date(rs.getDate("BOARD_DATE"));
					board.setBoard_parent(rs.getInt("BOARD_PARENT"));
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
			CloseUtil.close(rs);
			CloseUtil.close(pstmt);
			CloseUtil.close(conn); 
			
			
			return board;
		} // end getDetail()
	    
	    public boolean updateBoard(TradeBoardVO vo) 
		{
			boolean result = false;
			
			try{
				conn = getConnection();
				conn.setAutoCommit(false); // 占쌘듸옙 커占쏙옙占쏙옙 false占쏙옙 占싼댐옙.
				
				StringBuffer sql = new StringBuffer();
				sql.append("UPDATE MEMBER_BOARD SET");
				sql.append(" BOARD_SUBJECT=?");
				sql.append(" ,BOARD_CONTENT=?");
				sql.append(" ,BOARD_FILE=?");
				sql.append(" ,BOARD_DATE=SYSDATE ");
				sql.append("WHERE BOARD_NUM=?");

				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, vo.getBoard_subject());
				pstmt.setString(2, vo.getBoard_content());
				pstmt.setString(3, vo.getBoard_file());
				pstmt.setInt(4, vo.getBoard_num());
				
				int flag = pstmt.executeUpdate();
				if(flag > 0){
					result = true;
					conn.commit(); // 占싹뤄옙占� 커占쏙옙
				}
				
			} catch (Exception e) {
				try {
					conn.rollback(); // 占쏙옙占쏙옙占쏙옙 占싼뱄옙
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
				throw new RuntimeException(e.getMessage());
			}
		
			CloseUtil.close(rs);
			CloseUtil.close(pstmt);
			CloseUtil.close(conn); 
			return result;
		} // end updateBoard
	    
	    
	    
	    public int getSeq() throws SQLException
		{
			int result = 1;
			
			try {
				conn = getConnection();
				
				// 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占승댐옙. (DUAL : 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쌈쏙옙 占쏙옙占싱븝옙)
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT BOARD_NUM.NEXTVAL FROM DUAL");
				
				pstmt = conn.prepareStatement(sql.toString());
				// 占쏙옙占쏙옙 占쏙옙占쏙옙
				rs = pstmt.executeQuery();
				
				if(rs.next())	result = rs.getInt(1);

			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
			
			CloseUtil.close(rs);
			CloseUtil.close(pstmt);
			CloseUtil.close(conn); 
			return result;	
		} // end getSeq
	    
	


	
	
}
	













