package com.book.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BoardWriteService;
import com.book.utility.Action;
import com.book.utility.ActionForward;
import com.book.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		
		ActionForward forward = null;
		BoardVO boardBean = null;
		String realFolder = "";
		String saveFolder = "C:/upload";
		int filesize = 1024 * 1024 * 5;
		ServletContext context = req.getServletContext();
//		realFolder = context.getRealPath(saveFolder);
		realFolder = context.getRealPath("/boardUpload");
		
		MultipartRequest multi = new MultipartRequest(req, saveFolder, filesize, 
				"utf-8", new DefaultFileRenamePolicy());
		
		boardBean = new BoardVO();
		boardBean.setBoard_name(multi.getParameter("board_name"));
		boardBean.setBoard_pass(multi.getParameter("board_pass"));
		boardBean.setBoard_subject(multi.getParameter("board_subject"));
		boardBean.setBoard_content(multi.getParameter("board_content"));
		boardBean.setBoard_file(multi.getOriginalFileName(
					(String) multi.getFileNames().nextElement()));
		
		BoardWriteService boardWriteService = new BoardWriteService();
		boolean isWriteSuccess = boardWriteService.registArticle(boardBean);
		
		if(!isWriteSuccess) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('게시글 등록이 실패했습니다!!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
		}		
		return forward;
	}

}
