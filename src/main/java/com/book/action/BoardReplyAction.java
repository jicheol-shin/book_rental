package com.book.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BoardReplyService;
import com.book.utility.Action;
import com.book.utility.ActionForward;
import com.book.vo.BoardVO;

public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null;
		String curPage = req.getParameter("page");
		BoardVO board = new BoardVO();

		board.setBoard_num(Integer.parseInt(req.getParameter("board_num")));
		board.setBoard_name(req.getParameter("board_name"));
		board.setBoard_pass(req.getParameter("board_pass"));
		board.setBoard_subject(req.getParameter("board_subject"));
		board.setBoard_content(req.getParameter("board_content"));
		board.setBoard_re_ref(Integer.parseInt(req.getParameter("board_re_ref")));
		board.setBoard_re_lev(Integer.parseInt(req.getParameter("board_re_lev")));
		board.setBoard_re_seq(Integer.parseInt(req.getParameter("board_re_seq")));
		
		BoardReplyService boardReplyService = new BoardReplyService();
		boolean isReplySuccess  = boardReplyService.replyBoard(board);
		
		if(isReplySuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo?page="+curPage);
		} else {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('게시글 등록이 실패했습니다!!')");
			out.println("history.back()");
			out.println("</script>");
		}		
		return forward;
	}
	

}
