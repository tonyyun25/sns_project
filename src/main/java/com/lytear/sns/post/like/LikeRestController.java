package com.lytear.sns.post.like;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lytear.sns.post.like.bo.LikeBO;

@RestController
@RequestMapping("/post")
public class LikeRestController {
	
	@Autowired
	private LikeBO likeBO;
	
	@GetMapping("/like")
	public Map<String, String> like(
			@RequestParam("postId") int postId
			,HttpServletRequest request
			) {
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		/*어떤 걸 파라미터로 받을 지 어떤걸 세션으로 받을지 컨트롤러가 판단
		 * 
		 * */
		
		Map<String, String> result = new HashMap<>();
		
		int count = likeBO.addLike(userId, postId);
		
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		
		return result;
	}
	
	
	
}
