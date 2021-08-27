package com.book.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.IdDupCheckService;
import com.book.utility.Action;
import com.book.utility.ActionForward;

public class IdCheckAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("memId");
		PrintWriter out = res.getWriter();
		
		if(id.equals("")) {
			out.print(2);
		}
		IdDupCheckService idCheckService = new IdDupCheckService();
		int id_num = idCheckService.IdDuplicationCheck(id);
		out.print(id_num);
		
		return null;
		
	}

}
