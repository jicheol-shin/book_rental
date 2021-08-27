package com.book.service;

import static com.book.db.JDBCUtility.close;
import static com.book.db.JDBCUtility.commit;
import static com.book.db.JDBCUtility.getConnection;
import static com.book.db.JDBCUtility.rollback;

import java.sql.Connection;

import com.book.dao.BoardDAO;
import com.book.vo.BoardVO;


public class BoardDeleteService {

	public boolean isBoardWriter(int board_num, String board_pass) {

		boolean isWriter = false;
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		isWriter = boardDAO.isBoardWriter(board_num, board_pass);
		close(conn);
		return isWriter;
	}

	public boolean deleteBoard(int board_num) {
		boolean isDeleteSuccess = false;
		Connection conn =getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		int deleteCount = boardDAO.deleteBoard(board_num);
		
		if(deleteCount>0) {
			commit(conn);
			isDeleteSuccess = true;
		} else {
			rollback(conn);
		}
		
		return isDeleteSuccess;
	}

}
