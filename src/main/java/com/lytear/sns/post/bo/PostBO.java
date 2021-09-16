package com.lytear.sns.post.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.sns.post.dao.PostDAO;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	//public int getTimeline(int userId, String userName, String content, String imagePath) {
	public int getTimeline(int userId, String userName, String content) {
			
		
		return postDAO.insertTimeline(userId, userName, content);
	}
	
	
	
}
