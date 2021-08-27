<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<h3>답변형 게시판</h3>
			<p>게시판 관리 페이지입니다. 글을 작성해 주세요!!</p>	
		</div>
		<form action="boardWrite.bo" class="form-group" method="post"  enctype="multipart/form-data" name="boardform">

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
	            
			<div class="form-group input-group">
	            <div class="input-group-prepend">
	               <span class="input-group-text"><i class="far fa-file-alt"></i></span>
	            </div>
	            <div class="custom-file">
	              <input type="file" class="custom-file-input" name="board_file" id="board_file"/>
	              <label class="custom-file-label" for="board_file" style="text-align:left">파일을 선택하세요...</label>
	            </div>
	          </div>  
	         
	         <div class="form-group mt-md-5">
	            <input type="reset" value="Reset" class="btn btn-success float-right login-btn ml-sm-2"/>
	            <input type="submit" value="Write" class="btn btn-success float-right login-btn"/>
	         </div>
		
		</form>		
		
	</div>
	<script>
		$(".custom-file-input").on("change",function(){
			//var filename = $(this).val();  전체 파일명
			var filename = $(this).val().split("\\").pop();     //파일명만 표시
			$(this).siblings(".custom-file-label").addClass("selected").html(filename);
		})
	</script>	
</body>
</html>
