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
				<div class="d-flex align-items-center justify-content-center">
					<div class="border-box1  border border-secondary d-flex align-items-center justify-content-center">
						<div class="input-box ">
					
					
							<div class="banner d-flex align-items-center justify-content-center">
								<span class=" font-weight-bold">Universegram</span>
							</div>
							
							<div class="input-group mb-3">
								<input type="text" class="form-control" placeholder="ID" name="loginId" id="idInput">
								<!-- btn-outline-secondary -->
								<div class="input-group-append">
									<button class="btn btn-info " type="button" id="idDuplicateCheckBtn">중복확인</button>
								</div>
								
							</div>
							
							<input type="password"  class="form-control mb-3" placeholder="비밀번호"  name="password" id="passwordInput">
							
							<input type="text"  class="form-control mb-3" placeholder="이메일 주소"  name="email" id="emailInput">
							<input type="text"  class="form-control mb-3" placeholder="이름"  name="name" id="nameInput">
							<input type="text"  class="form-control mb-4" placeholder="휴대폰 번호"  name="phoneNumber" id="phoneNumberInput">
							
							<button type="button" class="btn btn-success form-control mb-3" id="signUpBtn">회원가입</button>
							
					
						</div>
					</div>
				</div>
							
				<div class="d-flex align-items-center justify-content-center mt-3">
					<div class="border-box3  border border-secondary d-flex align-items-center justify-content-center">
						<span class=" ">계정이 있으신가요?<a href="#" > 로그인</a></span>
					
					</div>
				</div>
			</div>
		</section>
	
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>
</body>
</html>