package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Demo;


public class DemoService {
	/**
	 * 判断demo是否存在
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
	 * 获取demo详细内容
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
	 * 获取所有demo
	 * @return
	 */
	public static List<Demo> getAllDemos() {
		return Demo.dao.find("select * from demo");
	}
	
	/**
	 * 添加demo
	 * @return
	 */
	public static boolean addDemo(Demo demo) {
		if (isExist(demo)) {
			return false;
		}
		return demo.save();
	}
	
	/**
	 * 删除
	 * @return
	 */
	public static boolean delDemo(Demo demo) {
		//判断是否存在
		if (isExist(demo)) {
			return demo.delete();
		}
		return false;
	}
}
