package com.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.utility.Action;
import com.book.utility.ActionForward;
import com.book.vo.MemberVO;

public class LogoutAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward= null;
		
		HttpSession session = req.getSession();
		MemberVO member = (MemberVO) session.getAttribute("login_info");
		
		if(member== null) {
			req.setAttribute("error_message", "로그인외지 않았습니다!! 로그인후 로그아웃을 할 수 있습니다!!");
			
		} else {
			session.invalidate();  //세션종료
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.do");
		}
		return forward;
	}
}
