package com.lytear.sns.user.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
	
	public int insertUser (
		@Param("loginId") String loginID
		,@Param("password") String password 
		,@Param("email") String email
		,@Param("name") String name
		,@Param("phoneNumber") String phoneNumber
	);
	
	public int selectDuplicate(@Param("loginId") String loginId );
	
}
