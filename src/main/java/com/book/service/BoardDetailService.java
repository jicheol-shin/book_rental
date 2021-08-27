package com.book.service;


import static com.book.db.JDBCUtility.*;
import java.sql.Connection;

import com.book.dao.BoardDAO;
import com.book.vo.BoardVO;


public class BoardDetailService {
	
	public BoardVO getBoard(int board_num){
		
		BoardVO board = new BoardVO();
		
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		
		int updateCount = boardDAO.updateReadCount(board_num);
		if(updateCount > 0) commit(conn); else rollback(conn);
		
		board = boardDAO.selectBoard(board_num);
		close(conn);
		return board;
	}
	
	
	
}
