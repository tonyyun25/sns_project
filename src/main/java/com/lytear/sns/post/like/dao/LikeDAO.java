package com.lytear.sns.post.like.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDAO {
	public int insertLike(
			@Param("userId") int userId
			,@Param("postId") int postId
			);
	
	public int selectCountLikeByUserId( // count 쿼리 이용해 해당하는 행이 있냐 없냐를 확인 => 개수니깐 int
			@Param("userId") int userId
			,@Param("postId") int postId
			);
	
	public int selectCountLikeByPostId(@Param("postId") int postId);
	
	public int deleteLike(
			@Param("userId") int userId
			,@Param("postId") int postId);
	
	public int deleteLikeByPostId(@Param("postId") int postId);
	
}
