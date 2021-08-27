package com.book.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BoardModifyService;
import com.book.utility.Action;
import com.book.utility.ActionForward;
import com.book.vo.BoardVO;


public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null;
		BoardVO board = new BoardVO();
		boolean isModifySuccess = false;
		int board_num = Integer.parseInt(req.getParameter("board_num"));
		BoardModifyService boardModifyService = new BoardModifyService();
		boolean isWriter =  boardModifyService.isBoardWriter(board_num, req.getParameter("board_pass"));
		
		if(!isWriter) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('게시글을 수정할 권한이 없습니다!!')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
			board.setBoard_num(board_num);
			board.setBoard_subject(req.getParameter("board_subject"));
			board.setBoard_content(req.getParameter("board_content"));
			isModifySuccess = boardModifyService.modifyBoard(board);
			
			if(!isModifySuccess) {
				res.setContentType("text/html; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println("alert('게시글 수정을 실패했습니다!!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("/boardDetail.bo?board_num="+board.getBoard_num());
				
			}
		}
		return forward;
		
	}

}


