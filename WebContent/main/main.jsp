<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>

  <main id="main">
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">
      </div>
    </section>

    <section id="portfolio-details" class="portfolio-details">
      <div class="container" data-aos="fade-up">
        <h2 class="btn btn-info">신간도서</h2>
          <div class="owl-carousel portfolio-details-carousel" align="center" style="background:url('./assets/img/learning.webp')">
            <img src="assets/img/booka.PNG" class="img-fluid" style="max-width: 500px;"> 
            <img src="assets/img/bookb.PNG" class="img-fluid" style="max-width: 500px;">
            <img src="assets/img/bookc.PNG" class="img-fluid" style="max-width: 500px;">
          </div>
      </div>
      <br />
      <div>
      	<div class="container"> 
        	<a  href="bookSearchForm.do" type="button" class="btn btn-info">도서검색</a>
        	<a  href="bookRentalForm.do" type="button" class="btn btn-info">대출내역</a>
      	</div>
      </div>
      
      
    </section>

  </main>
  <%@ include file="../include/footer.jsp"%>
  <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>


  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/counterup/counterup.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/js/main.js"></script>

</body>
</html>