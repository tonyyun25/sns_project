package com.lytear.sns.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/signin_view")
	public String signinView() {
		return "user/signIn";
	} 
	
	@GetMapping("signup_view")
	public String signupView() {
		return "user/signUp";
	}
	
	@GetMapping("/sign_out")
	public String signOut(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		
		
		return "redirect:/user/signin_view";
		
	}
}
