package com.lytear.sns.post.comment;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lytear.sns.post.comment.bo.CommentBO;


@RestController
@RequestMapping("/post")
public class CommentRestController {

	/*
	 * BO, DAO가 따로 있기 때문에 comment 패키지는 따로 만드는 게 맞다. sns 바로 아래 comment 패키지 두어도 되지만
	 * post 아래 있기 때문에 여기서는 post/ comment 패키지 만듦
	 * 
	 * 
	 * */
	@Autowired
	private CommentBO commentBO;
	
	@PostMapping("/comment/create")
	public Map<String, String> add_Comment(
			@RequestParam("postId") int postId
			,@RequestParam("content") String content
			,HttpServletRequest request
			) {
		/*post, 코멘트 다 가져와서
		 * 해당하는 post에 맞춰서 코멘트 출력
		 * 
		 * 코멘트 다 가져왔을 때 부하 있으므로 피하기
		 * 
		 * */
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String userNameTest = (String)session.getAttribute("userName");
		
		int count = commentBO.addComment(userId, userNameTest, postId, content);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		return result;
	}
	
}
