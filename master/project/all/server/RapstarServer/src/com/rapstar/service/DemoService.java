package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Demo;


public class DemoService {
	/**
	 * �ж�demo�Ƿ����
	 * 
	 * @param demo
	 * @return
	 */
	public static boolean isExist(Demo demo) {
		List<Demo> demos = getAllDemos();
		for (Demo demo2 : demos) {
			if (demo.getName().equals(demo2.getName())&&demo.getAuthorid().equals(demo2.getAuthorid())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ��ȡdemo��ϸ����
	 * 
	 * @param demo
	 * @return
	 */
	public static Demo getDemoMsg(Demo demo) {
		List<Demo> demos = getAllDemos();
		for (Demo demo2 : demos) {
			if (demo.getName().equals(demo2.getName())&&demo.getAuthorid().equals(demo2.getAuthorid())) {
				return demo2;
			}
		}
		return null;
	}
	

	/**
	 * ��ȡ����demo
	 * @return
	 */
	public static List<Demo> getAllDemos() {
		return Demo.dao.find("select * from demo");
	}
	
	/**
	 * ���demo
	 * @return
	 */
	public static boolean addDemo(Demo demo) {
		if (isExist(demo)) {
			return false;
		}
		return demo.save();
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public static boolean delDemo(Demo demo) {
		//�ж��Ƿ����
		if (isExist(demo)) {
			return demo.delete();
		}
		return false;
	}
}
