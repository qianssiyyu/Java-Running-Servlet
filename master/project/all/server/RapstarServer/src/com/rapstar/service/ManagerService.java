package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Manager;

public class ManagerService {

	public static boolean isExistManager(Manager manager) {
		String number = manager.getNum();
		String pwd = manager.getPwd();
		List<Manager> managers = Manager.dao
				.find("select * from manager where num = '" + number + "' and pwd = '" + pwd + "'");
		if (managers != null && managers.size() > 0) {
			return true;
		}
		return false;
	}
}
