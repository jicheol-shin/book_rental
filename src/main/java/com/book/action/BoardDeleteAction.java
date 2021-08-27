package com.book.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BoardDeleteService;
import com.book.utility.Action;
import com.book.utility.ActionForward;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		boolean isDeleteSuccess = false;
		int board_num = Integer.parseInt(req.getParameter("board_num"));
		String curPage = req.getParameter("page"); 
		BoardDeleteService boardDeleteService = new BoardDeleteService();
		boolean isWriter =  boardDeleteService.isBoardWriter(board_num, req.getParameter("board_pass"));
		
		if(!isWriter) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('게시글을 삭제할 권한이 없습니다!!')");
			out.println("history.back()");
			out.println("</script>");
			
		} else {
			isDeleteSuccess = boardDeleteService.deleteBoard(board_num);
			
			if(!isDeleteSuccess) {
				res.setContentType("text/html; charset=utf-8");
				PrintWriter out = res.getWriter();
				out.println("<script>");
				out.println("alert('게시글 삭제에 실패했습니다!!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("/boardList.bo?board_num="+board_num+"&page="+curPage);
				
			}
		}
		return forward;
		
	}


}
