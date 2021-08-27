package com.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BoardDetailService;
import com.book.utility.Action;
import com.book.utility.ActionForward;
import com.book.vo.BoardVO;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		int board_num = Integer.parseInt(req.getParameter("board_num"));
		String page = req.getParameter("page");
		BoardDetailService boardDelailService = new BoardDetailService();
		BoardVO board = boardDelailService.getBoard(board_num);
		
		//System.out.println("board.getBoard_file()" + board.getBoard_file());
		
		
		ActionForward forward = new ActionForward();
		req.setAttribute("page", page);
		req.setAttribute("board", board);
		forward.setPath("/board/board_detail.jsp");
		return forward;
	}

}
