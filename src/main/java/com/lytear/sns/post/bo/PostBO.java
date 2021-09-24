package com.lytear.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lytear.sns.common.FileManagerService;
import com.lytear.sns.post.Post;
import com.lytear.sns.post.dao.PostDAO;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	//public int getTimeline(int userId, String userName, String content, String imagePath) {
	public int addPost(int userId, String userNameTest, String content, MultipartFile file) {
		
		// 방법 1		
		String imagePath = FileManagerService.saveFile(userId, file);
		
		if(imagePath == null) {
			return -1;
		}
		// 방법 2
		/*
		String imagePath = null;
		
		if(file != null) {
			imagePath  = FileManagerService.saveFile(userId, file);
			if(imagePath == null) {
				return 0;
			}
		}
		*/
		return postDAO.insertPost(userId, userNameTest, content, imagePath);
	}
	
	
	public List<Post> getPostList() {
		return postDAO.selectPostList();
	}
	
	
	
	
}
