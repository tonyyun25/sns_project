package com.lytear.sns.post.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lytear.sns.common.FileManagerService;
import com.lytear.sns.post.dao.PostDAO;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	//public int getTimeline(int userId, String userName, String content, String imagePath) {
	public int getTimeline(int userId, String userNameTest, String content, MultipartFile file) {
		
		String imagePath = null;
		
		if(file != null) {
			imagePath  = FileManagerService.saveFile(userId, file);
			if(imagePath == null) {
				return 0;
			}
		}
		
		return postDAO.insertTimeline(userId, userNameTest, content, imagePath);
	}
	
	
	
}
