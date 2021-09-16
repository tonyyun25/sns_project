package com.lytear.sns.post.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO {

	public int insertTimeline(
			@Param("userId") int userId
			,@Param("userNameTest") String userNameTest
			,@Param("content") String content
			,@Param("imagePath") String imagePath
			//,@Param("imagePath") String imagePath
			
			);
	
}
