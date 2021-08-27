package com.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.service.BoardListService;
import com.book.utility.Action;
import com.book.utility.ActionForward;
import com.book.utility.Pager;
import com.book.vo.BoardVO;


public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {

		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		
		int page  = 1;
		int limit = 10;
		if(req.getParameter("page") != null) page = Integer.parseInt(req.getParameter("page"));
		
		BoardListService boardListService = new BoardListService();
		int listCount = boardListService.getListCount();
		boardList = boardListService.getBoardList(page, limit);
		
		// 총페이지수
		int totalPage = (int)((double)listCount / limit + 0.95);
		// 현재페이지의 시작페이지수(1, 11, 21...)
		int stratPage = (((int) ((double)page / 10 + 0.9))-1) * 10 + 1;
		// 현재페이지에 보여줄 마지막페이지수
		int endPage = stratPage + 10 - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		//System.out.println("endPage" + endPage + " / " + "totalPage"+totalPage);
//		
//		Pager pageInfo = new Pager();
//		pageInfo.setEndPage(endPage);
//		pageInfo.setListCount(listCount);
//		pageInfo.setTotalPage(totalPage);
//		pageInfo.setPage(page);
//		pageInfo.setStartPage(stratPage);
//		
//		req.setAttribute("pageInfo", pageInfo);
		req.setAttribute("boardList", boardList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/board/board_list.jsp");
		return forward;
	}

}
