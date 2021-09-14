package com.lytear.sns.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lytear.sns.user.bo.UserBO;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserBO userBO;
	
	
	@PostMapping("/sign_up")
	public Map<String, String> signUp(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,@RequestParam("email") String email
			,@RequestParam("name") String name
			,@RequestParam("phoneNumber") String phoneNumber
			) {
		
		int count = userBO.addUser(loginId, password, email, name, phoneNumber);
		
		Map<String, String> result = new HashMap<>();
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","failure");
		}		
		return result;
	}
	
	@GetMapping("/duplicateCheck")
	public Map<String, Boolean> isDuplicate(
			@RequestParam("loginId") String loginId 
			
			) {
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(userBO.getDuplicate(loginId)) {
			result.put("isDuplication", true);
		} else {
			result.put("isDuplication", false);
		}
		
		
		return result;
	}
	
}
