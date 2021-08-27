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
	   <h4><span class="glyphicon glyphicon-login btn-success"> 회원정보 입력 </span></h4>
	   <hr />
		<div>
		   <form action="join.do"  id="joinForm" class="form-group" method="post" onsubmit="return checkValue()">
		        
		        <div class="form-group">
                        <label><span style="background: skyblue;"><i class="fas fa-id-card-alt"></i>아이디</span>
                        <input class="form-control " id="memId" name="memId" type="text" placeholder="아이디"/></label>
                        <button type="button" class="btn btn-info"  id="idCheck">아이디 중복확인</button>
                        	
                </div>
		        <div class="form-group">
                        <label><span style="background: skyblue;"><i class="fas fa-lock"></i>PASSWORD</span></label>
                        <input class="form-control pwCheck" id="memPw" name="memPw"  type="password" placeholder="암호는 6자리 이상의 영문자와 숫자를 조합 해 주십시오." required />
                </div>
                
                <div class="form-group">
                        <label><span style="background: skyblue;"><i class="fas fa-lock"></i> PASSWORD 확인</span></label>
                        <input class="form-control pw" id="memPw1" name="memPw1" type="password" placeholder="패스워드 확인" required />
                       	<span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
						<span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호가 일치하지 않습니다.</span>
                
                <div class="form-group">
                        <label><span style="background: skyblue;"><i class="fas fa-file-signature"></i> 이  름</span></label>
                        <input class="form-control" id="memName" name="memName"  type="text" placeholder="이름" required />
                </div>                    
		        
                </div>
                <div class="form-group">
                        <label><span style="background: skyblue;"><i class="fas fa-phone-square"></i> Phone Number</span></label>
                        <input class="form-control" id="memTel" name="memTel" type="tel" placeholder="Phone Number" required  />
                        <p class="help-block text-danger"></p>
                </div>
		        <div class="form-group">        
                		<label><span style="background: skyblue;"><i class="fas fa-envelope-square"></i> Email</span></label>
                        <input class="form-control" id="memEmail" name="memEmail" type="email" placeholder="Email Address" required />
                        <p class="help-block text-danger"></p>
                </div>
                
		        <div class="form-group">        
                		<label><span style="background: skyblue;"><i class="fas fa-envelope-square"></i> Address</span><br />                		
                        <input type="text" class="form-control" id="postcode" name="postcode" placeholder="우편번호"></label>
						<input type="button" class="btn btn-primary" onclick="execDaumPostcode()" value="우편번호 찾기"><br />
						<input class="form-control" type="text" name="roadAddress1" id="roadAddress1" placeholder="도로명주소">
						<input class="form-control" type="text" name="roadAddress2" id="roadAddress2" placeholder="세부주소">
						<span id="guide" style="color:#999"></span>
                </div>
                
                <div class="form-group">
                      <label for="InputGender"><span style="background: skyblue;"><i class="fas fa-transgender-alt"></i> Gender</span></label><br />
                        <input type='radio' name='gender' value='M' /> 남성 &nbsp;&nbsp;&nbsp; 
                        <input type='radio' name='gender' value='F' />  여성
                </div>
                <hr />
                <br />
                <div id="success">
               	 	<button class="btn btn-primary btn_join" id="sendMessageButton" type="submit">회원가입</button>
             		<input type="reset" value="Reset" class="btn btn-success float-right login-btn ml-sm-2"/>
             	</div>
             	<hr />
         	</form>
       </div>
     </div>
  </section> 
</main>
<%@ include file="../include/footer.jsp"%>
<script>
 var checkedID = false;
	
 function checkValue(){
	if(checkedID) {
		alert("아이디 중복테크를 해 주세요")
	}
	return checkedID;
  }
	
 $('#idCheck').click(function(){
		var id = $('#memId').val();
    	//alert(id);
	    $.ajax({
	      url: "idCheck.do",
	      type: "post",   
	      data: {
	    	  memId : id
	        },

	      success: function (data) {
	    	//  alert(data);
	        if (data == 0) {
	        	checkedID = true;
	        	alert("사용 가능한 아이디입니다.");
	          return;
	        } else if(data == 1) {
	          alert("사용할 수 없는 아이디입니다.");
	      	  $('#memId').select();
	          $('.memId').focus();
	          return;
	        } else if(data == 2) {
	        	alert("아이디를 입력해 주세요.");
	        }
	      }
	    });
  });

  $('.pwCheck').focusout(function () {
	    var pwd = $("#memPw").val();
	    if(!/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,}$/.test(pwd)) { 
	        alert("비밀번호는 6자리 이상의 영문자와 숫자를 조합 해 주십시오.");
	    }
	    
	});
	
	$('.pw').focusout(function () {
	    var pwd1 = $("#memPw").val();
	    var pwd2 = $("#memPw1").val();
	    
	    if ( pwd1 != '' && pwd2 == '' ) {
	           null;
	    } else if (pwd1 != "" || pwd2 != "") {
	        if (pwd1 == pwd2) {
	            $("#alert-success").css('display', 'inline-block');
	            $("#alert-danger").css('display', 'none');
	        } else {
	            alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
	        	$("#memPw1").val("");
				$("#memPw1").focus();
	            $("#alert-success").css('display', 'none');
	            $("#alert-danger").css('display', 'inline-block');
	        }
	    }
	});
	
	
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }

                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('roadAddress1').value = fullRoadAddr;
               // document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }

</script>
</body>
</html>
