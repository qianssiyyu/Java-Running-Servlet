package com.rapstar.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Manager;
import com.rapstar.model.User;
import com.rapstar.service.ManagerService;
import com.rapstar.service.UserService;

public class ManagerController extends Controller {

	/**
	 * ¹ÜÀí†TµÇÂ¼
	 */
	public void login() {
		Manager manager = new Manager();
		String number = getPara("num").toString();
		String pwdString = getPara("pwd").toString();
		manager.setNum(number);
		manager.setPwd(pwdString);
		boolean flag = ManagerService.isExistManager(manager);
		String returnStr = String.valueOf(flag);
		if (flag) {
			renderJsp("/adminManagement.jsp");
		} else {
			renderJsp(returnStr);
		}

	}
}
