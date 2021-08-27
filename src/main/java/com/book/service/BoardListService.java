package com.book.service;

import static com.book.db.JDBCUtility.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.book.dao.BoardDAO;
import com.book.vo.BoardVO;


public class BoardListService {

	public int getListCount() { 
		
		int listCount = 0;
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		listCount = boardDAO.selectListCount();
		//System.out.println(listCount);
		close(conn);
		return listCount; 
	}
	public ArrayList<BoardVO> getBoardList(int page, int limit) { 
		
		ArrayList<BoardVO> boardList = null;
		Connection conn = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();		
		boardDAO.setConnection(conn);
		boardList = boardDAO.selectBoardList(page, limit);
		close(conn);
		return boardList; 
	}
}