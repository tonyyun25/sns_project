package com.lytear.sns.user.bo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.sns.common.EncryptUtils;
import com.lytear.sns.user.dao.UserDAO;

@Service
public class UserBO {
	@Autowired
	private UserDAO userDAO;
	
	public int addUser(String loginId, String password, String email, String name, String phoneNumber){
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encryptPassword, email, name, phoneNumber);
	}
	
	public boolean getDuplicate(String loginId) {
		
		int count = userDAO.selectDuplicate(loginId);
		
		if(count >= 1) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
