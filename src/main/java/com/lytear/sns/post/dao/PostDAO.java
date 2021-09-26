package com.lytear.sns.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.lytear.sns.post.Post;

@Repository
public interface PostDAO {

	public int insertPost(
			@Param("userId") int userId
			,@Param("userNameTest") String userNameTest
			,@Param("content") String content
			,@Param("imagePath") String imagePath
			//,@Param("imagePath") String imagePath
			
			);
	
	

	public List<Post> selectPostList();
	
	public int insertComment(
			@Param("userId") int userId
			,@Param("userNameTest") String userNameTest
			,@Param("postId") int postId
			,@Param("content") String content
			);
	
}
