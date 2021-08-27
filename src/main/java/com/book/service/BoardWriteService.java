package com.book.service;

import java.sql.Connection;

import com.book.dao.BoardDAO;
import com.book.vo.BoardVO;

import static com.book.db.JDBCUtility.*;

public class BoardWriteService {

	public boolean registArticle(BoardVO boardBean) {
		
		boolean isWriteSuccess = false;
		
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		int insertCount = boardDAO.insertBoard(boardBean);
		
		if(insertCount>0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		
		return isWriteSuccess;
	}
}
