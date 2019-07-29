package my.bbs2;

import java.util.*;

import javax.servlet.http.*;

import com.oreilly.servlet.*;
import java.sql.*;

/**
 *  �����ڵ��� ���� �����ϰ� �� Ŭ����
 *  API�� �Ǵ� Ŭ����
 *
 */
public class BbsManager {
	
	static private BbsManager instance = new BbsManager();
	
	private BbsManager(){
		
	} // �⺻ ������ ------

	public static BbsManager getInstance(){
		return instance;
	}
	
	/** 
		#1. �۾��� ... writeOk()
	*/
	public int writeOk(MultipartRequest mr)
		throws SQLException{
		
		BbsDAO dao = new BbsDAO();
		int n = dao.writeOk(mr);
		return n;
		
	}
	
	/**
		#2 .�� ���... listAll()
	*/
	
	public ArrayList<BbsDTO> listAll(int cpage, int pageSize)
		throws SQLException{
		BbsDAO dao = new BbsDAO();
		return dao.listAll(cpage,pageSize);
	}
	/*===========================================*
 	#2_1 �� �Խù� �� ���ϱ� ����
 	
 *==========================================*/
	public int getTotalGulCount()
		throws SQLException{
		BbsDAO dao = new BbsDAO();
		return dao.getTotalGulCount();
	}
	
/**===============================================
 	#3. �۳��� ����
 	ViewContent()
 =============================================== */
	public BbsDTO viewContent(String idx)
		throws SQLException{
		BbsDAO dao = new BbsDAO();
		return dao.viewContent(idx);
	}
	
/**=====================================================
 * #3_1. �۳���(viewContent)����
 * 			��ȸ�� (readnum) ���� �޼ҵ�
 ======================================================*/
	public boolean getReadnum(String idx)
		throws SQLException{
		BbsDAO  dao = new BbsDAO();
		return dao.getReadnum(idx);
	}
	
/*==========================================
 	#4. �� ���� ���� --deleteOk
 ========================================== */	
	public int deleteOk(String idx, String pwd)
		throws SQLException{
		return new BbsDAO().deleteOk(idx, pwd);
	}
/**======================================================
	#5. �� ���� ���� ���� --edit
========================================================*/
	public BbsDTO edit(String idx)
		throws SQLException{
		return new BbsDAO().edit(idx);
	}
	
/** ================================================
  	#5_1. �� ���� ���� ���� ���� --editOk
================================================= */
	public int editOk(HttpServletRequest req)
		throws SQLException{
		return new BbsDAO().editOk(req);
	}
	
/** ================================================
  	#6. ��� ���� ���� --rewirteOk()
================================================= */
	public int rewriteOk(MultipartRequest mr)
		throws SQLException{
		return new BbsDAO().rewriteOk(mr);
	}
	
/**=====================================================
 	#7. ������ ���� ���� ----replySave()
 =======================================================*/
	public int replySave(String idx, String writer, String content, String pwd)
		throws SQLException{
		return new BbsDAO().replySave(idx,writer,content, pwd);
	}
/**=====================================================
 	#7_1. ������ ��� �������� ----replyList()
 =======================================================*/	
	public ArrayList<ReplyDTO> replyList(String idx)
		throws SQLException{
		return new BbsDAO().replyList(idx);
	}
/**=====================================================
 	#7_2. ������ ���� ---- replyDelPwd()
=======================================================*/
	public int replyDelPwd(String no, String pwd)
		throws SQLException{
		return new BbsDAO().replyDelPwd(no,pwd);
	}
/* ======================================================*/
} /////////////////////////////////////

