<%@page import="com.book.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String curPage = (String) request.getAttribute("page");
		BoardVO board = (BoardVO) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	      integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
		  crossorigin="anonymous">  
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
</head>
<body>

	<div class="container" align="center">
		<div class="jumbotron">
			<h3>게시판 댓글 쓰기</h3>
			<p>게시판 글쓰기 페이지입니다. 댓글을 작성해 주세요!!</p>
		</div>
		<form action="boardReply.bo" class="form-group" method="post">
			<input type="hidden" name="page" value="<%=curPage%>"/>
			<input type="hidden" name="board_num" value="<%=board.getBoard_num()%>"/>
			<input type="hidden" name="board_re_ref" value="<%=board.getBoard_re_ref()%>"/>
			<input type="hidden" name="board_re_lev" value="<%=board.getBoard_re_lev()%>"/>
			<input type="hidden" name="board_re_seq" value="<%=board.getBoard_re_seq()%>"/>
		  	
		  	<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fas fa-user"></i></span>
				</div>
				<input class="form-control"  type="text"  name="board_name"  id="board_name"  required placeholder="board writer..." />
			</div>
		
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fas fa-key"></i></span>
				</div>
				<input class="form-control" type="password" name="board_pass" id="board_pass" required placeholder="password..."/>
			</div>

			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="far fa-clipboard"></i></span>
				</div>
				<input class="form-control" type="text" name="board_subject" id="board_subject" required placeholder="subject..."/>
			</div>

			<div class="form-group input-group">
	            <div class="input-group-prepend">
	               <span class="input-group-text"><i class="far fa-comment-dots"></i></span>
	            </div>
		            <textarea class="form-control" name="board_content" id="board_content" cols="40" rows="15" required placeholder="content..."></textarea>
		     </div>         
	         
	         <div class="form-group mt-md-5">
	            <input type="reset" value="Reset" class="btn btn-success float-right login-btn ml-sm-2"/>
	            <input type="submit" value="Write" class="btn btn-success float-right login-btn"/>
	         </div>
		
		</form>		
		
	</div>
</body>
</html>