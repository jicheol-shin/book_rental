<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<main id="main">
  <section id="breadcrumbs" class="breadcrumbs">
     <div class="container">
     </div>
   </section>
   <section id="portfolio-details" class="portfolio-details">
     <div class="container">
	   <h4><span class="glyphicon glyphicon-login btn-success"> 로그인 </span></h4>
	   <hr />
		<div>
		   <form action="login.do"  id="loginForm" class="form-group" method="post">
		        
		        <div class="form-group">
                        <label><span style="background: skyblue;"><i class="fas fa-id-card-alt"></i>아이디</span>
                        <input class="form-control " id="memId" name="memId" type="text" placeholder="아이디"/></label>
                        	
                </div>
		        <div class="form-group">
                        <label><span style="background: skyblue;"><i class="fas fa-lock"></i>PASSWORD</span>
                        <input class="form-control pwCheck" id="memPw" name="memPw"  type="password" placeholder="패스워드" required /></label>
                </div>
                <hr />
                <br />
                <div id="success">
               	 	<button class="btn btn-primary btn_join" id="sendMessageButton" type="submit">로그인</button>
               	 	<a href="index.do" class="btn btn-primary btn_join">홈으로</a>
             	</div>
             	<hr />
         	</form>
       </div>
     </div>
  </section> 
</main>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
