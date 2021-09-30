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
		<section class="content d-flex justify-content-center"><!-- 높이가 없는 상태에서 align-items-center 주면 위가 잘린다 -->
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
				
				<%-- 피드 : 행 하나당 피드 전체가반복 되어야 하므로 전체로 반복시킨다 -->
				
				<%--<c:forEach var="post" items="${postList }">--%>
				<!-- html 주석은 <!---가 아니라 <퍼센트-- 써야 함 -->
				<c:forEach var="postDetail" items="${postList }">
				
				<div class="border-box1  border border-secondary mb-3">
					
					
					<div class="d-flex justify-content-center">
						<div class="input-box2  d-flex justify-content-between">	
					
							<div>${postDetail.post.userName }</div>
							<div class="more-icon">
								<a class="text-dark moreBtn" href="#" data-toggle="modal" data-target="#deleteModal"><%-- ★★ class에 moreBtn을 줌 --%>
									<i class="bi bi-three-dots-vertical"></i>
									
									
									
									
									
									<%-- --%>
									<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
									  <div class="modal-dialog modal-dialog-centered" role="document">
									    <div class="modal-content">
									      
									      <div class="modal-body text-center">
									        <a class="deleteBtn" href="#"  data-post-id="${postDetail.post.id }">삭제하기</a>
									        
									      </div>
									    
									    </div>
									  </div>
									</div>
									<%-- --%>
									
									
									
									
									
									
									
								</a>
							
							</div>
						</div>	
					</div>	
					<!-- ★★ 여기에 forEach 문을 통해 timeline 을 보여줘야 한다 ★★ -->
					<!-- <img width="400" height="300" class="bg-secondary">  -->
						
						<img src="${postDetail.post.imagePath }" class="w-100 imageClick">
					
										
				 	<hr>
					
					<!-- 좋아요 -->
					${postDetail.post.content }
					
					<div class=" mb-2">
						
						<div class="d-flex justify-content-center">
							<div class="input-box2 ">
								<%-- <a href="#" class="likeBtn" data-post-id="${postDetail.post.id }">--%><%--# 누르면 상단으로 올라가므로 아래에서 e.preventDefault() 처리 --%>
									
									<c:choose>
										<c:when test="${postDetail.like }"><%--이 자체가 true, false이다. postDetail.isLike가 아니라 postDetail.like이다 --%>
											<%-- <a href="#" class="unlikeBtn" data-post-id="${postDetail.post.id }">--%><%--like 취소를 위해 추가. 페이지소스보기 likeBtn, unlikeBtn
											사용자한테 보여주는 버튼 자체가 바뀐다--%>
											<a href="#" class="likeBtn" data-post-id="${postDetail.post.id }"><%--두번째 방법. 바꾸기 귀찮아 둘 다 likeBtn --%>
											
												<i class="bi bi-heart-fill heart-icon text-danger "></i>
											</a><%--like 취소를 위해 추가--%>
										<%-- <i class="bi bi-suit-heart likeBtn"></i>--%>
										<%--id는 한페이지에 한개여서 여러 개면 해당 이벤트도 동작 안 해. 클래스는 여러개도 관계 없어 OK --%>
										</c:when>
										<c:otherwise>
											<a href="#" class="likeBtn" data-post-id="${postDetail.post.id }" >	<%--like 취소를 위해 추가--%>
												<i class="bi bi-heart heart-icon text-dark" ></i>
											
												
											</a><%--like 취소를 위해 추가--%>
										</c:otherwise>
									</c:choose>	
									
								</a>
								<span class="middle-size">좋아요 ${postDetail.likeCount }개</span>
							</div>	
						</div>
						
						
						<%-- 댓글 --%>
						<c:forEach var="comment" items="${postDetail.commentList }"><!-- 이중, 3중 반복문 신경 쓸 필요 없이 그냥 하나의 for 문이야. post 하나에 들어있는 댓글 리스트를 반복시킨다 -->
							<div class="d-flex justify-content-center">	
								<%-- 
								soy_bean 노는 건지 일하는 건지 헷갈릴 때가...<br>
								carrot_kim 여기가 어디에요?<br>
								sandy_lee 재밌겠다 ~~ --%>
								<div class="input-box2 ">
								
									<b>${comment.userName }</b> ${comment.content }<br>
								</div>
								
							</div>
						</c:forEach>	
					</div>	
					<%--  댓글 달기 --%>
					
					
					<div class="d-flex justify-content-center mb-2">
						<div class="input-box2  d-flex justify-content-between">
							<div class="col-9  d-flex align-items-center ">	
								<div>♣</div>
								<input type="text" class=" form-control" placeholder="댓글 달기..." id="commentInput-${postDetail.post.id }">	
							</div>
							
							<div class="col-3 d-flex">
								<%-- 정답 : 
								<input type="text" class="form-control border-0" id="commentInput-${post.id }">
								<button class="commentBtn" data-post-id="${post.id }">게시</button>--%>
								<%-- data 뒤에 대문자 절대 안 됨 --%>
								
								<button class="btn commentBtn" data-post-id="${postDetail.post.id }" >게시</button>
							</div>
						</div>
					</div>
					<%--  댓글 달기 --%>
				</div >
				
				</c:forEach>
				<!-- /피드 -->
			</div>
		</section>
	</div>
	
	
	
	
	<!-- Modal 
	어느 글에 대한 modal 인지 구별
	방법 1. 각각 더 보기 버튼과 일치하는 modal을 각각 만든다 : 비추
	2. 더보기 버튼 눌렀을 때 post-id 수를 삽입시킨다
	
	-->
	
	
	
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
			
			$(".commentBtn").on("click", function(){
				var postId = $(this).data("post-id");
				//alert(postId);
				// postId, content
				// 대응되는 input의 value => 문자열 연산
				// ex) postId = 5;
				// "#commentInput-5"
				//var content = $("#commentInput-" + postId).val();
				var content = $("#commentInput-" + postId).val();//id="commentInput-${post.id }"
				
				$.ajax({
					type:"post",
					url:"/post/comment/create",
					data:{"postId":postId,"content":content},
					success:function(data){
						if(data.result == "success"){
							//alert("댓글 추가 성공");
							location.reload();
						} else {
							alert("댓글 추가 실패");
						}
					},
					error:function(e){
						alert("error");//postId : 11, content : 나무가 잘렸네ㅠㅠ
					}
				});
			});
			
			$(".likeBtn").on("click",function(e){
				e.preventDefault();
				<%--
				jstl과 ${postDetail.post.id } 과 같은 el tag는 서버에서
				다 처리되고 (페이지 소스보기에서 post.id 숫자 바뀌는 것으로 확인)
				그 다음 클라이언트 pc에서 아래 ajax 처리됨
				-->
				<%--postId, userId 처리--%>
				var postId = $(this).data("post-id");
				
				$.ajax({
					type: "get",
					url: "/post/like",
					data:{"postId":postId},		
					success:function(data){
						if(data.result == "success"){
							//alert("좋아요 성공");
							location.reload();
						}else {
							alert("좋아요 실패");
						}
					},
					error:function(e){
						alert("error")
					}
						
				});
				
			});
			<%--좋아요 여부 구분 방법 두 가지
			1. 클라이언트에서 구분 : 하트가 빨간지 여부 bi-heart-fill과 bi-heart. 각각에 대해 호출하는 컨트롤러를
			달리한다 => 각 여부에 따라 이벤트를 달리한다
			단, 문제는 공용으로 id 쓰는 사람은 서로 다른 클라이언트에서 같은 페이지 볼 수 있어. 내 친구가 좋아요 취소 누르면 내가 리프레시 하지 않는 이상
			좋아요 취소 볼 수 없어 좋아요 취소 다시 누르면 행이 두 개 쌓일 수 있어
			
			2. 결과에 대한 판단을 서버에 던지는 방법. 클라이언트는 좋아요 요청만 함 
			단, 나는 좋아요 상태인데 다른 곳에서 눌러 좋아요 취소 상태가 되면 (서버)
			또 누르면 다시 좋아요 상태가 됨 => 사용자 헷갈림
			
			그래서 최선은 클라이언트, 서버 둘 다 확인해서 처리
			
			--%>
			
			<%--
			jstl과 ${postDetail.post.id } 과 같은 el tag는 서버에서
			다 처리되고 (페이지 소스보기에서 post.id 숫자 바뀌는 것으로 확인)
			그 다음 클라이언트 pc에서 아래 ajax 처리됨
			-->
			<%--postId, userId 처리--%>
			<%--
			$(".unlikeBtn").on("click",function(e){
				e.preventDefault();
				
				var postId = $(this).data("post-id");
				
				$.ajax({
					type: "get",
					url: "/post/unlike",
					data:{"postId":postId},		
					success:function(data){
						if(data.result == "success"){
							//alert("좋아요 성공");
							location.reload();
						}else {
							alert("좋아요 취소 실패");
						}
					},
					error:function(e){
						alert("error")
					}
						
				});
				
			});
			--%>
			
			$(".moreBtn").on("click",function(e){
				e.preventDefault();
				var postId = $(this).data("post-id");
				// <a href="#" id="deleteBtn" data-post-id=""></a> // tag를 넣어 속성을 추가하는 것과 같다
				$("#deleteBtn").data("post-id",postId);
				
			});
				
				
			$(".deleteBtn").on("click",function(){	
				e.preventDefault();
				alert($(this).data("post-id"));
				let content = $("#").val().trim();
				
				$.ajax({
					type:"get",	
					url:"/post/delete",
					data:{"id":, "content":},
					success:function(data){
						if(result.data == "success") {
							alert("삭제 성공");
						} else {
							alert("삭제 실패");
						}
					}
					,error:function(e) {
						
					}
					
				
				});
			
			});
			
			
			
			
			
		});	
	</script>

</body>
</html>