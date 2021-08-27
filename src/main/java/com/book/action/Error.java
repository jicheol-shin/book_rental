package com.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.utility.Action;
import com.book.utility.ActionForward;


public class Error implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward actionForward=new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("./error/user_error.jsp");
		return actionForward;
	}
}
