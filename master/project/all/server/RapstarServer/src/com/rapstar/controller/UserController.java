package com.rapstar.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.User;
import com.rapstar.service.UserService;

public class UserController extends Controller {


	/**
	 * 登录
	 */
	public void login() {
		// 获取前端传来的json串
		// 获取数据，通过流的方式
		System.out.println("开始拿数据");
		String s = HttpKit.readData(getRequest());
		System.out.println("从客户端拿到的数据是："+s);
		
		User user = JsonKit.parse(s, User.class);
		System.out.println("解析出的user数据："+user.getPhone()+" pwd:"+user.getPwd());
		boolean flag = UserService.isExitUser(user);
		
		if (flag) {
			// 存入详细信息
			getSession().setAttribute("user", UserService.getUserMsg(user));

		}
		String returnStr = String.valueOf(flag);
		System.out.println(returnStr);
		renderText(returnStr);

	}

	/**
	 * 注册 返回值是true/false
	 */
	public void register() {
		String s = HttpKit.readData(getRequest());
		User user = JsonKit.parse(s, User.class);
		List<User> users = UserService.getAllUser();
		for (User user2 : users) {
			if (user.getPhone().equals(user2.getPhone())) {
				// 已经存在此用户
				renderText("false");
			}
		}
		boolean flag = UserService.addUser(user);
		String returnStr = String.valueOf(flag);
		// 添加成功/失败
		renderText(returnStr);
	}

	/**
	 * 得到登录用户的信息
	 */
	public void getLoginUserMsg() {
		User user = (User) getSession().getAttribute("user");
		// TODO:能不能序列化空对象？
		if (user != null) {
			renderJson(user);
		} else {
			renderText(null);
		}
	}

	/**
	 * 获取普通用户信息
	 */
	public void getUserMsg() {
		// 传入要查询的信息
		String s = HttpKit.readData(getRequest());
		User user = JsonKit.parse(s, User.class);
		if (UserService.isExitUser(user)) {
			// 存在此用户，查询信息并返回
			User user2 = UserService.getUserMsg(user);
			renderJson(user2);
		} else {
			renderText(null);
		}
	}
}
