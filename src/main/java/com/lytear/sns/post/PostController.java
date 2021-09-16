package com.lytear.sns.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

	
	@RequestMapping("/timeline")
	public String timeline() {
		return "post/createTimeline";
	}
	
	
}
