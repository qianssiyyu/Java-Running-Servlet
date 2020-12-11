package com.rapstar.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Acccollect;
import com.rapstar.model.Accompaniment;
import com.rapstar.model.Demo;
import com.rapstar.model.Democollect;
import com.rapstar.model.User;
import com.rapstar.service.AccColService;
import com.rapstar.service.DemoColService;
import com.rapstar.service.DemoService;
import com.rapstar.service.UserService;

/**
 * democol
 * 
 * @author Aimer
 *
 */
public class DemoColController extends Controller {

	/**
	 * ��ӵ��ղ�
	 */
	public void add2Col() {
		User user = (User) getSession().getAttribute("user");
		int uid = user.getId();
		String s = HttpKit.readData(getRequest());
		Demo demo0 = JsonKit.parse(s, Demo.class);
		Demo demo = DemoService.getDemoMsg(demo0);
	
		Democollect democollect = new Democollect();
		democollect.setUserid(uid);
		democollect.setDemoid(demo.getId());
		renderText(DemoColService.add2Col(democollect) + "");
	}

	/**
	 * ȡ���ղ�
	 */
	public void delFromCol() {
		User user = (User) getSession().getAttribute("user");
		int uid = user.getId();
		String s = HttpKit.readData(getRequest());
		Demo demo0 = JsonKit.parse(s, Demo.class);
		Demo demo = DemoService.getDemoMsg(demo0);
	
		Democollect democollect = new Democollect();
		democollect.setUserid(uid);
		democollect.setDemoid(demo.getId());
		renderText(DemoColService.delFromCol(democollect) + "");
	}

	
	/**
	 * ��ȡ�ҵ��ղ� ���ص���demos
	 */
	public void getMyCol() {
		User user = (User) getSession().getAttribute("user");
		String s = HttpKit.readData(getRequest());
		
		List<Democollect> demoCols = DemoColService.getAllCol();
		List<Demo> demos = new ArrayList<Demo>();
		for (Democollect democol : demoCols) {
			if (democol.getUserid().equals(user.getId())) {
				// ��Acccol��accid�õ�acc
				demos.add(Demo.dao.findById(democol.getDemoid()));
			}
		}
		if (demos.size() == 0) {
			renderText(null);
		}

		// ���ص���accs��json
		String json = JsonKit.toJson(demos);
		renderText(json);
	}
	
	/**
	 * ��ȡָ���û����ղ� ���ص���demos
	 */
	public void getUserCols() {
		String s = HttpKit.readData(getRequest());
		User user0 = JsonKit.parse(s, User.class);
		User user = UserService.getUserMsg(user0);
		List<Democollect> demoCols = DemoColService.getAllCol();

		List<Demo> demos = new ArrayList<Demo>();
		for (Democollect democol : demoCols) {
			if (democol.getUserid().equals(user.getId())) {
				// ��Acccol��accid�õ�acc
				demos.add(Demo.dao.findById(democol.getDemoid()));
			}
		}
		if (demos.size() == 0) {
			renderText(null);
		}

		// ���ص���accs��json
		String json = JsonKit.toJson(demos);
		renderText(json);
	}

}
