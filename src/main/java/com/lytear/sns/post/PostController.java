package com.lytear.sns.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lytear.sns.post.bo.PostBO;

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
		List<Post> snsList = postBO.getPostList();
		
		model.addAttribute("postList", postList);
		
		return "post/timeline";
	}
	
	/*
	@GetMapping("list_view")
	public String listView() {
		
		return "post/listView";
	}
	*/
	
	
	
}
