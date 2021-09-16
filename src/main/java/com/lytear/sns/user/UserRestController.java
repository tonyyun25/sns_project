package com.lytear.sns.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lytear.sns.user.bo.UserBO;
import com.lytear.sns.user.model.User;

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
	
	@GetMapping("/is_duplicate_id")
	public Map<String, Boolean> isDuplicateId(
			@RequestParam("loginId") String loginId 
			
			) {
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(userBO.isDuplicateId(loginId)) {
			result.put("is_duplicate", true);
		} else {
			result.put("is_duplicate", false);
		}
		
		
		return result;
	}
	
	@PostMapping("/sign_in")
	public Map<String, String> sign_Up (
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,HttpServletRequest request
			) {
		User user = userBO.getLogInUser(loginId, password);
		
		Map<String, String> result = new HashMap<>();
		
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId",user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName",user.getName());
			
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	/*
	 * Socket 통신 : 프로그램에서 가장 기반이 되는 네트워크 통신. 문자열(0, 1)만 서로 주고 받는 것만 확인함
	 * => request 형태의 알아보기 힘든 데이타를 가져와서 String 형태의 우리가 원하는 데이터를 꺼내쓰는 것
	 * => Html 규격 가져와 원하는 형태 만들고. 그 위의 servlet 써서 객체화 쓰는 게 우리가 지금 쓰는 방식
	 * 1 bind
	 * 2 listen
	 * 3 connect
	 * 4 accept 연결에 문제가 없다
	 * 5 read write
	 * 여러개의 클라이언트와 서버와 통신할 때는 bind, listen, accept 까지 되는 순간
	 * 둘 사의 통신을 위한 thread가 생긴다. Server는 계속 listen
	 * 
	 * TCP / UDP
	 * TCP : 데이터의 신뢰성을 보장한다 (데이터가 온전하게 갔는지 안 갔는지 확인)
	 * UDP : 데이터의 신뢰를 보장하지 않는다
	 * 
	 * Cookie: 클라이언트에 정보 저장
	 * Session : 기본적인 로그인 유지 방법. 서버에 정보 저장 => timeout 걸어 부하 낮춤
	 * 
	 * 나중에 익숙해지고 나면 Spring security 적용 검토
	 * *
	 */
	
	 
}
