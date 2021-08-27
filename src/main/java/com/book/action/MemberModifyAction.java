package com.book.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.service.MemberService;
import com.book.utility.Action;
import com.book.utility.ActionForward;
import com.book.vo.MemberVO;

public class MemberModifyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward= null;
		
		MemberVO member = new MemberVO();
		
		member.setMemId(req.getParameter("memId"));
		member.setMemName(req.getParameter("memName"));
		member.setMemPw(req.getParameter("memPw"));
		member.setMemTel(req.getParameter("memTel"));
		member.setMemEmail(req.getParameter("memEmail"));
		member.setMemAddr1(req.getParameter("roadAddress1"));
		member.setMemAddr2(req.getParameter("roadAddress2"));
		member.setGender(req.getParameter("gender"));
		
		MemberService memberService = new MemberService();
		boolean isWriteSuccess = memberService.modifyMember(member);
		
		if(!isWriteSuccess) {
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('회원정보 수정에 실패했습니다!!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			
			HttpSession session = req.getSession();
			session.setAttribute("login_info", member);
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.do");
		}		

		return forward;

	}

}	