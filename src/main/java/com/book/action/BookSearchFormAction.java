package com.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.utility.Action;
import com.book.utility.ActionForward;

public class BookSearchFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward actionForward=new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("./bookRental/bookSearch.jsp");
		return actionForward;
	}

}
