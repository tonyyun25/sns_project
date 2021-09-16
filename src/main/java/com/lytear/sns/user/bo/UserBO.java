package com.lytear.sns.user.bo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.sns.common.EncryptUtils;
import com.lytear.sns.user.dao.UserDAO;
import com.lytear.sns.user.model.User;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int addUser(String loginId, String password, String email, String name, String phoneNumber){
		String encryptPassword = EncryptUtils.md5(password);
		
		/* 해당 password 문제 생겼을 때 (암호안의 결과가 비어있는 문자열) 리턴 0 
		 * 해 준다 => insert 한 결과는 실행된 행의 개수이니 0 인 경우 controller에서(서버) 받을 때
		 * 뭔가 문제가 있다는 시그널로 전달받게 됨
		 * 문제가 생긴 경우 log가 남게 해서 나중에 분석 함 (에러 발생하면 자동으로 개발자에게 메일이 감)
		 */
		if(encryptPassword.equals("")) {
			logger.error("[UserBO signUP] 암호화 실패 !!!!!!!!!!!!");
			return 0;
		}
		 
		
		
		
		return userDAO.insertUser(loginId, encryptPassword, email, name, phoneNumber);
	}
	
	public boolean isDuplicateId(String loginId) {
		
		int count = userDAO.selectCountByID(loginId);
		
		if(count >= 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public User getLogInUser(String loginId, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		return userDAO.selectNewLogInUser(loginId, encryptPassword);
	}
	
	
	
}
