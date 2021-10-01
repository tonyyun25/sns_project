package com.lytear.sns.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class PermissionInterceptor implements HandlerInterceptor {

	// 요청이 들어올 때
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		
		String uri = request.getRequestURI();
		
		if(session.getAttribute("userId") == null) {
			if(uri.startsWith("/post")) {
				response.sendRedirect("/user/signin_view");
				return false;
			}
		} else {
			if(uri.startsWith("/user")) {
				response.sendRedirect("/post/timeline");
				return false;
			}
		}
		return true;
	}
	
	// response 처리할 때
	@Override
	public void postHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, ModelAndView modelAndView) {
		
	}
	
	// 모든 것이 완료되었을 때
	@Override
	public 
	void afterCompletion(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			, Exception ex) {
		
	}
	
}
