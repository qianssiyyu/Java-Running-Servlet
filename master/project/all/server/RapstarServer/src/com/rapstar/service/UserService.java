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
	 * �����û��ֲ���Ϣ��phone����ȡ������Ϣ
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
	 * ��ȡ�����û�
	 * 
	 * @return
	 */
	public static List<User> getAllUser() {
		return User.dao.find("select * from user");
	}

	/**
	 * ���user
	 * 
	 * @param user
	 * @return
	 */
	public static boolean addUser(User user) {
		return user.save();
	}

}
