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
import org.springframework.web.multipart.MultipartFile;

import com.lytear.sns.post.bo.PostBO;

@RestController
@RequestMapping("/post")
public class PostRestController {
	// 강의영상 (09.17일) 5분, 48분, 1시간 2분, 2시간 4분, 2시간 22분
	
	/*1. Uncaught SyntaxError : unexpected string : timeline:95
	 * : 파라미터 (userName, not null) 없었음
	 * */
	
	@Autowired
	private PostBO postBO;
	
	@PostMapping("/create")
	public Map<String, String> add_timeline(
			@RequestParam("content") String content
			,@RequestParam(value = "file") MultipartFile file//API URL 설계시 정한 파라미터 명, 데이터 타입
			, HttpServletRequest request
			) {
		
		HttpSession session = request.getSession();//세션에 있는 값을 가져오기 위한, 누가 쓴지에 대한 정보를 저장하기 위해 해당 로그인된 값
		int userId = (Integer)session.getAttribute("userId");//mafia, 123, jhope, 111, sugar 123
		String userNameTest = (String)session.getAttribute("userName");
		
		
		/* UserRestController 설정 내용
		session.setAttribute("userId",user.getId());
		session.setAttribute("userLoginId", user.getLoginId());
		session.setAttribute("userName",user.getName());
		*/
		
		//int count = postBO.getTimeline(userId, userName, content, imagePath);
		int count = postBO.addPost(userId, userNameTest, content, file);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result","success");
		} else {
//			result.put("result","fail");
			result.put("result","userId");
		}
		
		return result;
	}
	
	@PostMapping("/post/comment/create")
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
		
		int count = postBO.addComment(userId, userNameTest, postId, content);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		}
		return result;
	}
	
}
