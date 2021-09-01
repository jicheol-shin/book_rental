<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<%
    MemberVO mem = (MemberVO) session.getAttribute("login_info");
%>
<main id="main">
  <section id="breadcrumbs" class="breadcrumbs">
     <div class="container">
     </div>
   </section>
   <section id="portfolio-details" class="portfolio-details">
     <div class="container">
	   <h4><span class="glyphicon glyphicon-login btn-success"> 회원정보 정보 </span></h4>
	   <hr />
		<div>
		     <div class="form-group">
                 <span><i class="fas fa-id-card-alt"></i> 아이디  :  <%=mem.getMemId() %></span>
                 <br /> <br />     
                 <span><i class="fas fa-file-signature"></i> 이  름  :  <%=mem.getMemName() %></span>
                 <br /><br />      
                 <span><i class="fas fa-phone-square"></i> Phone Number  :  <%=mem.getMemTel() %></span>
                 <br /><br />      
                 <span><i class="fas fa-envelope-square"></i> Email  :  <%=mem.getMemEmail() %></span>
                 <br /><br />      
                 <span><i class="fas fa-envelope-square"></i> Address  :  <%=mem.getMemAddr1() %> &nbsp;  <%=mem.getMemAddr2() %></span>
                 <br /><br />      
                 <span><i class="fas fa-transgender-alt"></i> Gender  :  <%=mem.getGender().trim().equals("M")  ? "남자" : "여자" %></span>
                 <br /><br />      
                 
                <br />
                <div id="success">
               	 	<a href="memberModifyForm.do"  class="btn btn-primary" type="button">회원정보수정</a>
               	 	<a href="index.do"  class="btn btn-primary" type="button">홈으로</a>
             	</div>
             	<hr />
         	</div>
         	</div>
     </div>
  </section> 
</main>
<%@ include file="../include/footer.jsp"%>
</body>
</html>
