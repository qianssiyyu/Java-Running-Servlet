package com.rapstar.service;

import java.util.List;

import com.rapstar.model.User;

public class UserService {
	
	public static boolean isExitUser(User user) {
		String phone = user.getPhone();
		String pwd = user.getPwd();
		List<User> users = User.dao.find("select * from rap_user where phone = "+phone+" and pwd = "+pwd);
		if(users != null && users.size()>0) {
			return true;
		}
		return false;
	}
	
	
	public static boolean addUser(User user) {		
		return user.save();
	}

}
