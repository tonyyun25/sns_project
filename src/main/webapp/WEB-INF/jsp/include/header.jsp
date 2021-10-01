<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<header class="bg-light mt-4">
	<h1>Universegram</h1> 
	<c:if test="${not empty userName }">
		
		<a href="/user/sign_out">[로그아웃]</a>
	
	
	</c:if>	
	
	
	
</header>