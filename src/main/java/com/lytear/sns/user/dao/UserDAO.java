package com.lytear.sns.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.sns.user.model.User;

@Repository
public interface UserDAO {
	
	public int insertUser (
		@Param("loginId") String loginId
		,@Param("password") String password 
		,@Param("email") String email
		,@Param("name") String name
		,@Param("phoneNumber") String phoneNumber
	);
	
	public int selectCountByID(@Param("loginId") String loginId );
	
	public User selectNewLogInUser(
			@Param("loginId") String loginId
			,@Param("password") String password
			);
	
}
