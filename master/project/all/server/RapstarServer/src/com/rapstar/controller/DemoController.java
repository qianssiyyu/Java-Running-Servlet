package com.rapstar.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Demo;
import com.rapstar.model.User;
import com.rapstar.service.DemoService;

/**
 * 伴奏
 * 
 * @author Aimer
 *
 */
public class DemoController extends Controller {

	/**
	 * 上传demo
	 */
	public void upload() {
		// TODO:demo的下载操作（读写）
		String s = HttpKit.readData(getRequest());
		// 拿到需要存储的
		Demo demo = JsonKit.parse(s, Demo.class);
		User user = (User) getSession().getAttribute("user");
		// 外键
		demo.setAuthorid(user.getId());
		// 判断添加的demo
		if (DemoService.isExist(demo)) {
			// 歌曲存在
			renderText("false");
		} else {
			// demo不存在
			if (DemoService.addDemo(demo)) {
				renderText("true");
			} else {
				renderText("false");
			}
		}
	}

	/**
	 * 删除demo
	 */
	public void delDemo() {
		// TODO:demo的下载操作（读写）
		String s = HttpKit.readData(getRequest());
		// 拿到要删除的demo
		Demo demo = JsonKit.parse(s, Demo.class);
		// 判断是否存在
		if (DemoService.isExist(demo)) {
			// 存在，删除
			renderText(DemoService.delDemo(demo) + "");
		}
		renderText("false");
	}

	/**
	 * 获取所有demo
	 */
	public void getAllDemos() {
		List<Demo> demos = DemoService.getAllDemos();
		if (demos.size() > 0) {
			String json = JsonKit.toJson(demos);
			renderText(json);
		}
		renderText(null);
	}
}
