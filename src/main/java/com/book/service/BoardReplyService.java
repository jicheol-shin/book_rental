package com.book.service;

import static com.book.db.JDBCUtility.*;

import java.sql.Connection;

import com.book.dao.BoardDAO;
import com.book.vo.BoardVO;
public class BoardReplyService {
	
	public boolean replyBoard(BoardVO board) {
		boolean isReplySuccess = false;
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		int insetCount = boardDAO.insertReplyBoard(board);
		
		if(insetCount>0) {
			commit(conn);
			isReplySuccess = true;
		} else {
			rollback(conn);
		}
		
		close(conn);
		return isReplySuccess;
		
	}
	
	
	
	
}
