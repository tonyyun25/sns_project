package com.lytear.sns.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.sns.post.Post;

@Repository
public interface PostDAO {

	public int insertTimeline(
			@Param("userId") int userId
			,@Param("userNameTest") String userNameTest
			,@Param("content") String content
			,@Param("imagePath") String imagePath
			//,@Param("imagePath") String imagePath
			
			);
	
	
//	public List<Post> selectSnsList(@Param("userId") int userId);
	
	public List<Post> selectSnsList();
	
}
