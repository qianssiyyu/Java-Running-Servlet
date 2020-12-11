package com.rapstar.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Accompaniment;
import com.rapstar.model.User;
import com.rapstar.service.AccService;
import com.rapstar.service.UserService;

public class AccompanimentController extends Controller {

	/**
	 * 添加伴奏
	 */
	public void addAcc() {
		// 获取前端传来的json串
		// 获取数据，通过流的方式
		String s = HttpKit.readData(getRequest());
		Accompaniment acc = JsonKit.parse(s, Accompaniment.class);
		boolean flag = AccService.isExistAcc(acc);
		if (flag) {
			// 已经存在此伴奏
			renderText("false");
		} else {
			boolean b = AccService.addAcc(acc);
			String returnStr = String.valueOf(b);
			renderText(returnStr);
		}
	}

	/**
	 * 获取所有伴奏
	 */
	public List<Accompaniment> getAllAccs() {
		return Accompaniment.dao.find("select * from accompaniment");
	}

	/**
	 * 获取我创作的伴奏
	 */
	public void getMyAccs() {
		List<Accompaniment> accs = getAllAccs();
		List<Accompaniment> accs0 = new ArrayList<Accompaniment>();
		System.out.println("accs的长度是" + accs.size());
		User user = (User) getSession().getAttribute("user");
		if (user != null) {
			for (Accompaniment accompaniment : accs) {
				System.out.println("进入了增强循环");

				if (accompaniment.getAuthorid().equals(user.getId())) {

					System.out.println("得到了响应数据");
					accs0.add(accompaniment);
				}
			}

			System.out.println("list的长度是" + accs.size());
			String json = JsonKit.toJson(accs0);
			System.out.println("得到的是" + json);
			renderText(json);
		}
		renderText(null);
	}

	/**
	 * 查询指定用户的伴奏
	 */
	public void getAccsByUSer() {
		// 获取前端传来的json串
		// 获取数据，通过流的方式
		String s = HttpKit.readData(getRequest());
		User user = JsonKit.parse(s, User.class);
		User user2 = null;
		// 所查询的用户存在
		if (UserService.isExitUser(user)) {
			user2 = UserService.getUserMsg(user);
			List<Accompaniment> accs0 = new ArrayList<Accompaniment>();
			List<Accompaniment> accs = AccService.getAllAccs();
			for (Accompaniment accompaniment : accs) {
				if (accompaniment.getAuthorid().equals(user2.getId())) {
					accs0.add(accompaniment);
				}
			}
			// 转换为json格式
			String json = JsonKit.toJson(accs);
			renderText(json);
		}
		renderText(null);
	}

	/**
	 * TODO 搜索伴奏
	 */

}
