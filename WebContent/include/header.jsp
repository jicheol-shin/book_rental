<%@page import="com.book.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    MemberVO member = (MemberVO) session.getAttribute("login_info");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <title>Book Rental</title>
  <meta content="" name="description">
  <meta content="" name="keywords">
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Montserrat:300,400,500,600,700" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="assets/vendor/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
	    integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	    crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>

  <div id="topbar" class="d-none d-lg-flex align-items-end fixed-top " style="background-color: skyblue">
    <div class="container d-flex justify-content-end">
      <div class="social-links">
        <a href="#" class="twitter"><i class="fab fa-twitter"></i></a>
        <a href="#" class="facebook"><i class="fab fa-facebook"></i></a>
        <a href="#" class="linkedin"><i class="fab fa-linkedin"></i></a>
        <a href="#" class="instagram"><i class="fab fa-instagram"></i></a>
      </div>
    </div>
  </div>
  <header id="header" class="fixed-top " style="background-color: #C198B1">
    <div class="container d-flex align-items-center">
     <h1 class="logo mr-auto"><a href="index.do"><i class="fas fa-book-open"></i> 꿈꾸는 책방</a></h1>
       <nav class="main-nav d-none d-lg-block">
        <ul>
          <li ><a href="index.do">Home</a></li>
          	<c:choose>
          		<c:when test="<%=member == null %>" >
		          <li><a href="loginForm.do">로그인</a></li>
	    	      <li><a href="joinForm.do">회원가입</a></li>
	              <li><a href="bookSearch.do">도서검색</a></li>
			      <li><a href="boardList.do">게 시 판</a></li>
			    </c:when>  
          		<c:otherwise>
	              <li ><a href="#" class='text-primary'><%=member.getMemName()%> 님</a></li>
		          <li><a href="bookSearch.do">도서검색</a></li>
		          <li><a href="bookSearch.do">대출내역</a></li>
		          <li><a href="memberDetail.do">내정보 보기</a></li>
			      <li><a href="boardList.do">게 시 판</a></li>
		          <li><a href="logout.do" class='text-warning'>로그아웃</a></li>
          		</c:otherwise>
          	</c:choose>	
        </ul>
      </nav>

    </div>
  </header>
