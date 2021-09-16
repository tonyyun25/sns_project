<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS - 글쓰기</title>

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		
		<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
		<link rel="stylesheet" href="/static/css/style.css" type="text/css">

</head>
<body>
	<div id="wrap">
		<section class="content d-flex align-items-center justify-content-center">
			<div class="">
				<c:if test="${not empty userName}">
				<div class="text-right mr-3">${userName } 님 [로그아웃]</div><!--mafia/123-->
				</c:if>
				
				
				<div class="d-flex justify-content-center border-box3  border border-secondary  mb-3">
					<div class="input-box2 ">	
						<div class="mb-2">게시글을 작성해 주세요</div>
						
						<div class="d-flex justify-content-center mb-2">
							<input type="text" class="text-box bg-success" id="contentInput">						
						</div>
						
						<div class="d-flex justify-content-between  align-items-center">
							<!--  <button type="button" class="btn btn-secondary" >첨부</button>-->
							<input type="file" accept="image/*"  id="fileInput">
							<button type="button" class="btn btn-success" id="saveBtn">업로드</button>
						</div>
					</div>
				</div>
				
				<div class="border-box1  border border-secondary">
					
					
					<div class="d-flex justify-content-center">
						<div class="input-box2 bg-success d-flex justify-content-between">	
					
							<div>soy_bean</div>
							<div>삭제</div>
						</div>	
					</div>	
				
					<img width="400" height="300" class="bg-secondary">
				
				 	<hr>
					
					<div class="d-flex justify-content-center">
						<div class="input-box2 bg-success d-flex justify-content-between">
							
							<div class="d-flex justify-content-start">	
								<div>♣</div>
								<div class="ml-2">댓글 달기...</div>	
							</div>
							
							<div class="d-flex justify-content-end">
								<div>게시</div>
							</div>
							
						</div>
					</div>
				</div>
				
			</div>
		</section>
		
	</div>
	<script>	
		$(document).ready(function(){
			$("#saveBtn").on("click",function(){
				//alert("확인"); // 사용하면 에러
				
				var content = $("#contentInput").val().trim();
				if(content == null || content == "") {
					alert("글을 입력하세요")
					return;
				}
				
				var formData = new FormData();
				formData.append("content",content);
				formData.append("file", $("#fileInput")[0].files[0]);
				
				$.ajax({
					enctype: "multipart/form-data",
					processData: false,
					contentType: false,
					type:"post",
					url:"/post/add_timeline",
					data: formData,
					success : function(data) {
						if(data.result == "success") {
							alert("입력 성공");
						} else {
							alert("입력 실패");
						}						
						
					},
					error : function(e) {
						alert("error");
					}
					
				});
			});
			
		});	
	
	
	
	</script>

</body>
</html>