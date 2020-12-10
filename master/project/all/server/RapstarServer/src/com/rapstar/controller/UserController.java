package com.rapstar.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.User;
import com.rapstar.service.UserService;

public class UserController extends Controller {


	/**
	 * ��¼
	 */
	public void login() {
		// ��ȡǰ�˴�����json��
		// ��ȡ���ݣ�ͨ�����ķ�ʽ
		System.out.println("��ʼ������");
		String s = HttpKit.readData(getRequest());
		System.out.println("�ӿͻ����õ��������ǣ�"+s);
		
		User user = JsonKit.parse(s, User.class);
		System.out.println("��������user���ݣ�"+user.getPhone()+" pwd:"+user.getPwd());
		boolean flag = UserService.isExitUser(user);
		
		if (flag) {
			// ������ϸ��Ϣ
			getSession().setAttribute("user", UserService.getUserMsg(user));

		}
		String returnStr = String.valueOf(flag);
		System.out.println(returnStr);
		renderText(returnStr);

	}

	/**
	 * ע�� ����ֵ��true/false
	 */
	public void register() {
		String s = HttpKit.readData(getRequest());
		User user = JsonKit.parse(s, User.class);
		List<User> users = UserService.getAllUser();
		for (User user2 : users) {
			if (user.getPhone().equals(user2.getPhone())) {
				// �Ѿ����ڴ��û�
				renderText("false");
			}
		}
		boolean flag = UserService.addUser(user);
		String returnStr = String.valueOf(flag);
		// ��ӳɹ�/ʧ��
		renderText(returnStr);
	}

	/**
	 * �õ���¼�û�����Ϣ
	 */
	public void getLoginUserMsg() {
		User user = (User) getSession().getAttribute("user");
		// TODO:�ܲ������л��ն���
		if (user != null) {
			renderJson(user);
		} else {
			renderText(null);
		}
	}

	/**
	 * ��ȡ��ͨ�û���Ϣ
	 */
	public void getUserMsg() {
		// ����Ҫ��ѯ����Ϣ
		String s = HttpKit.readData(getRequest());
		User user = JsonKit.parse(s, User.class);
		if (UserService.isExitUser(user)) {
			// ���ڴ��û�����ѯ��Ϣ������
			User user2 = UserService.getUserMsg(user);
			renderJson(user2);
		} else {
			renderText(null);
		}
	}
}
