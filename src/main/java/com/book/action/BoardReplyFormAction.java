package com.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BoardDetailService;
import com.book.utility.Action;
import com.book.utility.ActionForward;
import com.book.vo.BoardVO;

public class BoardReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = new ActionForward();
		int board_num = Integer.parseInt(req.getParameter("board_num"));
		String curPage = req.getParameter("page");
		
		BoardDetailService boardDetailService = new BoardDetailService();
		BoardVO board = boardDetailService.getBoard(board_num);
		
		req.setAttribute("page", curPage);
		req.setAttribute("board", board);
		forward.setPath("/board/board_reply.jsp");
		return forward;
	}

}
