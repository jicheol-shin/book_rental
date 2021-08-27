package com.book.service;

import java.sql.Connection;

import com.book.dao.BoardDAO;
import com.book.vo.BoardVO;

import static com.book.db.JDBCUtility.*;

public class BoardModifyService {

	public boolean isBoardWriter(int board_num, String board_pass) {
		
		boolean isWriter = false;
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		isWriter = boardDAO.isBoardWriter(board_num, board_pass);
		close(conn);
		return isWriter;
	}
	
	public boolean modifyBoard(BoardVO board) {
		boolean isModifySuccess = false;
		Connection conn =getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		int updateCount = boardDAO.updateBoard(board);
		
		if(updateCount>0) {
			commit(conn);
			isModifySuccess = true;
		} else {
			rollback(conn);
		}
		
		return isModifySuccess;
	}
	
	
}

















