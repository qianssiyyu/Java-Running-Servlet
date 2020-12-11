package com.rapstar.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Acccollect;
import com.rapstar.model.Accompaniment;
import com.rapstar.model.User;
import com.rapstar.service.AccColService;
import com.rapstar.service.AccService;
import com.rapstar.service.UserService;

/**
 * �����ղؿ���acccol/
 * 
 * @author Aimer
 *
 */
public class AccColController extends Controller {

	/**
	 * ��ӵ��ղ�
	 */
	public void add2Col() {
		User user = (User) getSession().getAttribute("user");
		int uid = user.getId();
		String s = HttpKit.readData(getRequest());
		Accompaniment acc0 = JsonKit.parse(s, Accompaniment.class);
		Accompaniment acc = AccService.getAccMsg(acc0);
		Acccollect acccollect = new Acccollect();
		acccollect.setUserid(uid);
		acccollect.setAccid(acc.getId());
		renderText(AccColService.add2Col(acccollect) + "");
	}

	/**
	 * ȡ���ղ�
	 */
	public void delFromCol() {
		User user = (User) getSession().getAttribute("user");
		int uid = user.getId();

		String s = HttpKit.readData(getRequest());
		Accompaniment acc0 = JsonKit.parse(s, Accompaniment.class);
		Accompaniment acc = AccService.getAccMsg(acc0);
		Acccollect acccollect = new Acccollect();
		acccollect.setUserid(uid);
		acccollect.setAccid(acc.getId());
		renderText(AccColService.delFromCol(acccollect) + "");
	}

	/**
	 * ��ȡ�ҵ��ղ�
	 */
	public void getMyCol() {
		User user = (User) getSession().getAttribute("user");
		List<Acccollect> acccols = AccColService.getAllCol();
		List<Accompaniment> accs0 = new ArrayList<Accompaniment>();
		for (Acccollect acccollect2 : acccols) {
			if (acccollect2.getUserid().equals(user.getId())) {
				// ��Acccol��accid�õ�acc
				accs0.add(Accompaniment.dao.findById(acccollect2.getAccid()));
			}
		}
		if (accs0.size() == 0) {
			renderText(null);
		}
		// ���ص���accs��json
		String json = JsonKit.toJson(accs0);
		renderText(json);
	}

	
	
	/**
	 * ��ȡָ���û����ղ� ���ص���accs
	 */
	public void getUserCol() {
		String s = HttpKit.readData(getRequest());
		User user0 = JsonKit.parse(s, User.class);
		User user = UserService.getUserMsg(user0);
		List<Acccollect> acccols = AccColService.getAllCol();
		List<Accompaniment> accs0 = new ArrayList<Accompaniment>();
		for (Acccollect acccollect2 : acccols) {
			if (acccollect2.getUserid().equals(user.getId())) {
				// ��Acccol��accid�õ�acc
				accs0.add(Accompaniment.dao.findById(acccollect2.getAccid()));
			}
		}
		if (accs0.size() == 0) {
			renderText(null);
		}
		// ���ص���accs��json
		String json = JsonKit.toJson(accs0);
		renderText(json);
	}

}
