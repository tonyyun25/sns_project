<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS - 회원가입</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		
		<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
		<link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body>
	<div id="wrap">
		<!--<c:import url="/WEB-INF/jsp/include/header.jsp" /> -->
		
		<section class="content d-flex align-items-center justify-content-center">
			<div class="">
				
				<c:if test="${not empty userName}">
				<div class="text-right mr-3">${userName } 님 [로그아웃]</div><!--mafia/123-->
				</c:if>
				
				<div class="d-flex align-items-center justify-content-center">
					<div class="border-box1  border border-secondary d-flex align-items-center justify-content-center">
						<div class="input-box ">
					
					
							<div class="banner d-flex align-items-center justify-content-center">
								<span class=" font-weight-bold">Universegram</span>
							</div>
							
							<form id="signupForm">
							
								<div class="input-group mb-3">
									<input type="text" class="form-control" placeholder="ID" name="loginId" id="idInput">
									<!-- btn-outline-secondary -->
									<div class="input-group-append">
										<button class="btn btn-info " type="button" id="idDuplicateBtn">중복확인</button>
									</div>
								</div>
								<!-- d-none -->
								<div id="duplicateDiv" class="d-none"><small class="text-danger">중복된 ID입니다.</small></div>	
								<div id="noneDuplicateDiv" class="d-none"><small class="text-success">사용 가능한 ID입니다.</small></div>		
									
								
								<input type="password"  class="form-control mb-3" placeholder="비밀번호"  name="password" id="passwordInput">
								
								<input type="password"  class="form-control mb-3" placeholder="비밀번호 확인"  name="passwordConfirm" id="passwordConfirmInput">
								
								<!-- d-none -->
								
								<input type="text"  class="form-control mb-3" placeholder="이메일 주소"  name="email" id="emailInput">
								<input type="text"  class="form-control mb-3" placeholder="이름"  name="name" id="nameInput">
								<input type="text"  class="form-control mb-4" placeholder="휴대폰 번호"  name="phoneNumber" id="phoneNumberInput">
								
								<button type="submit" class="btn btn-success form-control mb-3" >회원가입</button>
							
							</form>
					
						</div>
					</div>
				</div>
							
				<div class="d-flex align-items-center justify-content-center mt-3">
					<div class="border-box3  border border-secondary d-flex align-items-center justify-content-center">
						<span class=" ">계정이 있으신가요?<a href="/user/signin_view" > 로그인</a></span>
					
					</div>
				</div>
			</div>
		</section>
	
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			// 중복 여부 확인 변수
			var isDuplicate = true;
			// 중복 체크 여부 확인
			var isIdCheck = false;
			// 아이디에 입력이 있을 경우 중복체크 상태를 초기화 한다
			$("#idInput").on("input",function(){ // 참조 : Front day 13 test 00
			/*
			input을 만들어서 5자 이상의 글씨가 입력되는 경우 alert을 통해서 "다섯자를 초과하여 입력할 수 없습니다. "메시지를 보여주세요.
			"input" : 새로운 '글자'가 들어온 것만 체크
			*/	
				isIdCheck = false;
				isDuplicate = true;
			});
			
			
			$("#signupForm").on("submit", function(e){
				// JS에서 에러가 하나라도 있으면 form이 그대로 실행되므로 유의
				e.preventDefault();
				
				var id = $("#idInput").val().trim();
				var password = $("#passwordInput").val().trim();
				var passwordConfirm = $("#passwordConfirmInput").val().trim();
				var email = $("#emailInput").val().trim();
				var name = $("#nameInput").val().trim();
				var phoneNumber = $("#phoneNumberInput").val().trim();
				
				
				if(id == null || id == "") {
					alert("id를 입력해 주세요")
					return;
				}
				
				if(isIdCheck == false) {
					alert("중복 체크를 진행해 주세요");
					return;
				}
				
				
				if(password == null || password == "") {
					alert("비밀번호를 입력해 주세요")
					return;
				}
				
				if(passwordConfirm == null || passwordConfirm == "") {
					alert("비밀번호 확인을 입력해 주세요")
					return;
				}
				
				if(password != passwordConfirm) {
					alert("비밀번호가 일치하지 않습니다")
					return;
				}
				
				if(email == null || email == "") {
					alert("이메일을 입력해 주세요")
					return;
				}
				
				if(name == null || name == "") {
					alert("이름을 입력해 주세요")
					return;
				}
				
				if(phoneNumber == null || phoneNumber == "") {
					alert("전화번호를 입력해 주세요")
					return;
				}
				
				if(isDuplicate == true) {
					alert("중복된 이름은 입력할 수 없습니다");
					return;
				}
				
				
				
				$.ajax({
					
					type: "post",
					url:"/user/sign_up",
					data: {"loginId":id,"password":password,"email":email,"name":name,"phoneNumber":phoneNumber},
					success: function(data) {
						
						if(data.result == "success"){
							//alert("회원 가입 성공");
							location.href="/user/signin_view";
						} else {
							alert("회원 가입 실패");
						}
						
					},
					error: function(e) {
						alert("회원 가입 실패");
					}
					
				});
				
			});
			
			$("#idDuplicateBtn").on("click", function(){
				//alert("확인");
				var id = $("#idInput").val().trim();//var loginId

				if(id == null || id == "") {
					alert("id를 입력해 주세요")
					return;
				}
				
				$.ajax({
					type: "get",
					url: "/user/is_duplicate_id",
					data:{"loginId":id},
					success:function(data){
						//alert(data);
						isIdCheck = true;
						//alert(data);
						/*방법 1*/
						if(data.is_duplicate) {
							isDuplicate = true;
							$("#duplicateDiv").removeClass("d-none");
							$("#noneDuplicateDiv").addClass("d-none");
						} else {
							isDuplicate = false;
							$("#duplicateDiv").addClass("d-none");
							$("#noneDuplicateDiv").removeClass("d-none");
							
						}
						
						//if(data.isDuplication == true) {
						/* 방법 2	
							if(data.isDuplication) {
							alert("중복된 ID입니다.");
							isDuplicate = true;
						} else {
							alert("사용 가능한 아이디입니다.");
							isDuplicate = false;
							
						}
						*/
					},	
					error: function(e) {
						alert("error");	
					}	
				});
				
			});
			
			
			
		});
	
	</script>
</body>
</html>