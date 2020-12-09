package com.rapstar.service;

import java.util.List;

import com.rapstar.model.User;

public class UserService {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public static boolean isExitUser(User user) {
		String phone = user.getPhone();
		String pwd = user.getPwd();
		List<User> users = getAllUser();
		for (User user2 : users) {
			if (user2.getPhone().equals(phone) && user2.getPwd().equals(pwd)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 根据用户局部信息（phone）获取所有信息
	 * 
	 * @return
	 */
	public static User getUserMsg(User user) {
		List<User> users = getAllUser();
		for (User user2 : users) {
			if (user2.getPhone().equals(user.getPhone())) {
				return user2;
			}
		}
		return null;
	}

	/**
	 * 获取所有用户
	 * 
	 * @return
	 */
	public static List<User> getAllUser() {
		System.out.println("开始获取用户");
		List<User> users = User.dao.find("select * from user");
		System.out.println(users.size());
		return users;
	}

	/**
	 * 添加user
	 * 
	 * @param user
	 * @return
	 */
	public static boolean addUser(User user) {
		return user.save();
	}

}
