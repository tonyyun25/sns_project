<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
	<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
	
	<link rel="stylesheet" href="/static/css/style.css" type="text/css">
	<title>SNS - 글쓰기</title>	
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
							<a href="#" id="imageUploadBtn"><i class="bi bi-card-image image-upload-icon"></i></a>
							<input type="file" accept="image/*"  id="fileInput" class="d-none"> <!-- 웹프론트 / 아이콘무료사이트 
							구글링 bootsrap icon, bootstrap icon cdn
							-->
							<button type="button" class="btn btn-success" id="uploadBtn">업로드</button>
						</div>
					</div>
				</div>
				
				<!-- 피드 : 행 하나당 피드 전체가반복 되어야 하므로 전체로 반복시킨다 -->
				
				<c:forEach var="post" items="${postList }">
				
				<div class="border-box1  border border-secondary">
					
					
					<div class="d-flex justify-content-center">
						<div class="input-box2 bg-success d-flex justify-content-between">	
					
							<div>${post.userName }</div>
							<div>삭제</div>
						</div>	
					</div>	
					<!-- ★★ 여기에 forEach 문을 통해 timeline 을 보여줘야 한다 ★★ -->
					<!-- <img width="400" height="300" class="bg-secondary">  -->
					
					
						
						<img src="${post.imagePath }" class="w-100">
					
				
					
					
					
					
					
										
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
				
				</c:forEach>
				<!-- /피드 -->
				
				
				
			</div>
		</section>
		
	</div>
	<script>	
		$(document).ready(function(){
			$("#imageUploadBtn").on("click", function(){
				$("#fileInput").click();
			
			});
			
			
			
			$("#uploadBtn").on("click",function(){
				//alert("확인"); // 사용하면 에러
				
				let content = $("#contentInput").val().trim();
				
				if(content == null || content == "") {
					alert("내용을 입력하세요")
					return;
				}
				// 무조건 파일이 있는 형태로 기획하고 validation
				if($("#fileInput")[0].files.length == 0) {
				//if($("#fileInput")[0].files[0].length == 0]) { // .files[0].은 명확하므로 위와 같이 씀	
					alert("파일을 추가하세요");
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
					url:"/post/create",
					data: formData,
					success : function(data) {
						if(data.result == "success") {
							//alert("입력 성공");
							location.reload();
						} else {
							alert("글쓰기에 실패했습니다.");
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