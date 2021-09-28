package com.lytear.sns.post.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {
	public int insertLike(
			@Param("userId") int userId
			,@Param("postId") int postId
			);
	
	public int userLikeResult(
			@Param("userId") int userId
			,@Param("postId") int postId
			);
	
}
