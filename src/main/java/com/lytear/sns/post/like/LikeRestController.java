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
		
		//int count = likeBO.addLike(userId, postId); //unlike 두 번째 적용 위해 삭제
		
		boolean isLike = likeBO.like(userId, postId);
		
		if(isLike) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		// 위 다섯 줄은 unlike 두 번째 적용 위함
		
		/*
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		*/
		return result;
	}
	
	@GetMapping("/unLike")
	public Map<String, String> unlike(
			@RequestParam("postId") int postId
			, HttpServletRequest request
			){
		HttpSession session= request.getSession(); 
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> result = new HashMap<>();
		
		int count = likeBO.unLike(postId, userId);
		
		if(count == 0) {
			result.put("result","fail");//delete는 행이 두 개 이상 삭제될 수도 있어 count == 1 아니라 count == 0을 명확한 케이스 if로 봄
		} else {
			result.put("result","success");
		}
		return result;
		
	}
	
	
	
	
}
