
<%@page import="com.book.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String curPage = (String) request.getAttribute("page");
	BoardVO board = (BoardVO) request.getAttribute("board");
%>
<c:set var="board_data" value="<%=board%>"/>
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
 	<style>
  		.login-btn {
  			color: black;
  			background-color: #FFC312;
  			width:100px;
  		}
  		.login-btn:hover {
  			color: black;
  			background-color: white;  		
  		} 
  		.input-group-prepend span{
  			color: black;
  			width:40px;
  			background-color: #FFC312;
  			border: 0 !important;
  		}
  	
  	</style>
</head>
<body>

	<div class="container" align="center">
	   <div class="jumbotron">
		<h3>게시판 글보기</h3>
	   </div>	
		    <div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fas fa-user"></i></span>
				</div>
				<input class="form-control"  type="text"  name="board_name"  id="board_name"  readonly value="${board_data.board_name}"/>
			</div>

			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="far fa-clipboard"></i></span>
				</div>
				<input class="form-control" type="text" name="board_subject" id="board_subject" value="${board_data.board_subject}"/>
			</div>

			<div class="form-group input-group">
	            <div class="input-group-prepend">
	               <span class="input-group-text"><i class="far fa-comment-dots"></i></span>
	            </div>
		            <textarea class="form-control" name="board_content" id="board_content" cols="40" rows="15" >${board_data.board_content}</textarea>
		    </div>   		

			<c:if test="${board_data.getBoard_file() ne null}">
					
				<div class="form-group input-group">
		            <div class="input-group-prepend">
		               <span class="input-group-text"><i class="far fa-file-alt"></i></span>
		            </div>
		            <div class="custom-file">
		              <input type="text" class="form-control" name="board_file" id="board_file" readonly value="${board_data.board_file}"/>
		            </div>
	          </div>  
			</c:if>		
			<div class="form-group input-group">
				<a href="boardReplyForm.bo?board_num=<%=board.getBoard_num()%>&page=<%=curPage%>" class="btn btn-success mr-sm-3">답변</a>
				<a href="boardModifyForm.bo?board_num=<%=board.getBoard_num()%>&page=<%=curPage%>" class="btn btn-success mr-sm-3">수정</a>
				<a href="boardDeleteForm.bo?board_num=<%=board.getBoard_num()%>&page=<%=curPage%>" class="btn btn-success mr-sm-3">삭제</a>
				<a href="boardList.bo?page=<%=curPage%>" class="btn btn-success">목록</a>
			</div>
		
	</div>
</body>
</html>
