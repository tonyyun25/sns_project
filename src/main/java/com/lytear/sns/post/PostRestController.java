package com.lytear.sns.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lytear.sns.post.bo.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {

	/*1. Uncaught SyntaxError : unexpected string : timeline:95
	 * : 파라미터 (userName, not null) 없었음
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
	@Autowired
	private PostBO postBO;
	
	@PostMapping("/add_timeline")
	public Map<String, String> add_timeline(
			@RequestParam("content") String content
			//,@RequestParam("imagePath") String imagePath
			, HttpServletRequest request
			) {
		
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");//mafia, 123
		String userName = (String)session.getAttribute("userName");
		
		
		/* UserRestController 설정 내용
		session.setAttribute("userId",user.getId());
		session.setAttribute("loginId", user.getLoginId());
		session.setAttribute("userName",user.getName());
		*/
		
		//int count = postBO.getTimeline(userId, userName, content, imagePath);
		int count = postBO.getTimeline(userId, userName, content);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		
		return result;
	}
	
	
	
	
}