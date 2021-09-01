<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int board_num = Integer.parseInt(request.getParameter("board_num"));
	String curPage = (String) request.getParameter("page"); 
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
			<h3>게시판 글 삭제</h3>
		</div>
		<form action="boardDelete.bo" method="post" >
			<input type="hidden" name="page"  value="<%=curPage%>"/>	
			<input type="hidden" name="board_num"  value="<%=board_num%>"/>	
			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text"><i class="fas fa-key"></i></span>
				</div>
				<input class="form-control" type="password" name="board_pass" id="board_pass" required placeholder="password..."/>
			</div>
			<div class="form-group input-group">
				<input type="submit" class="btn btn-danger mr-sm-3" value="삭제" />
				<input type="button" class="btn btn-success" value="이전" onClick="javascript:history.go(-1)"/>
			</div>
		</form>
	</div>
</body>
</html>


















