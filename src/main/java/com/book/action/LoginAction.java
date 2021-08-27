package com.book.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.service.MemberService;
import com.book.utility.Action;
import com.book.utility.ActionForward;
import com.book.vo.MemberVO;

public class LoginAction implements Action	{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward= null;
		
		String id = req.getParameter("memId");
		String password = req.getParameter("memPw");
		
		MemberVO member = new MemberVO();
		
		MemberService memberService = new MemberService();
		member = memberService.loginMember(id,password);
		
		
		if( member == null) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('아이디나 패스워드를 확인해 주세요!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("login_info", member);
			
			forward = new ActionForward();
			forward.setRedirect(true);
			if( member.getGradeCode() == "M") {
				forward.setPath("admin.do");
			} else {
				forward.setPath("index.do");
			}
		}		

		return forward;
		
	}
	
	
	
	
	
}
