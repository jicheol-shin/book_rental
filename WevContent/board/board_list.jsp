<%@page import="com.book.utility.Pager"%>
<%@page import="com.book.vo.BoardVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
ArrayList<BoardVO> boardList = (ArrayList<BoardVO>) request.getAttribute("boardList");
    Pager pageInfo = (Pager) request.getAttribute("pageInfo");
//    int curPage = pageInfo.getPage();
//    int totalPage = pageInfo.getTotalPage();
 //   int startPage = pageInfo.getStartPage();
   // int endPage = pageInfo.getEndPage();
%>
<!-- 
<c:set var="board_data" value="<%=boardList%>"/>
<c:set var="curPage" value="<%=curPage%>"/>
<c:set var="totalPage" value="<%=totalPage%>"/>
<c:set var="startPage" value="<%=startPage%>"/>
<c:set var="endPage" value="<%=endPage%>"/>
 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
		crossorigin="anonymous">    	
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
</head>
<body>
	<div class="container" align="center">
		<div class="jumbotron">
			<h3>게시판 글목록 보기</h3>	
			<c:if test="${board_data.isEmpty()}">
				<h5>
					<p class="bg-danger text-white">등록된 게시글이 존재하지 않습니다!!</p>
				</h5>
			</c:if>
		</div>
		<div class="nav-bar">
			<a href="boardWriteForm.bo" class="btn btn-success">글쓰기</a><br>
		</div>
		<table class="table table-hover">
			<tr class="table-dark text-light">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>삭제</th>				
			</tr>
			
			<c:forEach var="board" items="${board_data}">
				<tr>
					<td>${board.getBoard_num()}</td>
					<td>
						<c:if test="${board.getBoard_re_lev() != 0}">
							┖
							<c:forEach var="i" begin="1" end="${board.getBoard_re_lev() * 2}">
								─														
							</c:forEach>
							[RE] 
						</c:if>
						<a href="boardDetail.bo?board_num=${board.getBoard_num()}&page=${curPage}">${board.getBoard_subject()}</a>
						<span class="badge badge-success ml-sm-3">${board.getBoard_readcount()}</span>
					</td>
					<td>${board.getBoard_name()}</td>
					<td>${board.getBoard_date()}</td>
					<td>${board.getBoard_readcount()}</td>
					<td><a href="boardDeleteForm.bo?board_num=${board.board_num}&page=${curPage}"><i class="fas fa-trash-alt"></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>	
	<br>
	<div class="container">
		<ul class="pagination justify-content-center">
			<c:if test="${startPage ne 1}">
				<li class="page-item"><a href="boardList.bo?page=1" class="page-link"><i class="fas fa-fast-backward"></i></a></li>
				<li class="page-item"><a href="boardList.bo?page=${page_num-10}" class="page-link"><i class="fas fa-backward"></i></a></li>
			</c:if>
				<c:forEach var="page_num" begin="${startPage}" end="${endPage}">
				<li class="page-item"><a class="page-link" href="boardList.bo?page=${page_num}" >${page_num}</a></li>
			</c:forEach>
			<c:if test="${endPage < totalPage}">
				<li class="page-item"><a href="boardList.bo?page=${endPage+1}" class="page-link"><i class="fas fa-forward"></i></a></li>
				<li class="page-item"><a href="boardList.bo?page=${totalPage}" class="page-link"><i class="fas fa-fast-forward"></i></a></li>
			</c:if>
		</ul>
	</div>
</body>
</html>
