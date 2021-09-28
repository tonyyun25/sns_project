package com.lytear.sns.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lytear.sns.post.bo.PostBO;
import com.lytear.sns.post.model.PostDetail;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostBO postBO;
	
	@RequestMapping("/timeline")
	public String timeline(
			Model model
			//, HttpServletRequest request
			) {

		/*
		HttpSession session = request.getSession();
		
		int userId = (Integer)session.getAttribute("userId");
		*/
		//List<Post> postList = postBO.getPostList();
		List<PostDetail> postList = postBO.getPostList();
		
		
		
		model.addAttribute("postList", postList);

		
		//List<Post> snsList = postBO.getSnsList(userId);
		
		
		
		return "post/timeline";
	}
	
	
	
	
	
	
}
