package com.rapstar.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Demo;
import com.rapstar.model.User;
import com.rapstar.service.DemoService;

/**
 * ����
 * 
 * @author Aimer
 *
 */
public class DemoController extends Controller {

	/**
	 * �ϴ�demo
	 */
	public void upload() {
		// TODO:demo�����ز�������д��
		String s = HttpKit.readData(getRequest());
		// �õ���Ҫ�洢��
		Demo demo = JsonKit.parse(s, Demo.class);
		User user = (User) getSession().getAttribute("user");
		// ���
		demo.setAuthorid(user.getId());
		// �ж���ӵ�demo
		if (DemoService.isExist(demo)) {
			// ��������
			renderText("false");
		} else {
			// demo������
			if (DemoService.addDemo(demo)) {
				renderText("true");
			} else {
				renderText("false");
			}
		}
	}

	/**
	 * ɾ��demo
	 */
	public void delDemo() {
		// TODO:demo�����ز�������д��
		String s = HttpKit.readData(getRequest());
		// �õ�Ҫɾ����demo
		Demo demo = JsonKit.parse(s, Demo.class);
		// �ж��Ƿ����
		if (DemoService.isExist(demo)) {
			// ���ڣ�ɾ��
			renderText(DemoService.delDemo(demo) + "");
		}
		renderText("false");
	}

	/**
	 * ��ȡ����demo
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
