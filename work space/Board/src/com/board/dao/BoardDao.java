package com.board.dao;


import java.sql.SQLException;
import java.util.ArrayList;	 
import com.board.beans.board;


public class BoardDao extends CommonDao {
	    public static BoardDao getInstance() {
	        BoardDao _instance = new BoardDao();
	        _instance.SetDB();
	        return _instance;
	    }
	    
	    
	    @SuppressWarnings("unchecked")
		public ArrayList<board>getArticleList(int page) throws SQLException{ //����Ʈ 
	    	return (ArrayList<board>)GetDB().queryForList("getArticleList", null, page, 10);
	    }
		
	    @SuppressWarnings("unchecked")
		public board getArticle(int idx) throws SQLException{ // ������ 
	    	return (board)GetDB().queryForObject("getArticle", idx);
	    }
		
		@SuppressWarnings("unchecked")
		public void deleteArticle(int idx) throws SQLException{ // ����Ʈ 
			GetDB().delete("deleteArticle", idx);
			return ;
		}
		public void updateArticle(board article) throws SQLException{ // ���� 
			GetDB().update("updateArticle" , article);
			return ;
		}
		
		public void insertArticle(board article) throws SQLException{ // �ۼ� 
			GetDB().insert("insertArticle", article);
			return ;
		}
		
		public void setArticleCount(board article) throws SQLException{ //count ����
			GetDB().update("setArticleCount", article);
			return ;
		}
}
