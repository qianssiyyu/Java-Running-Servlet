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
	 * ��Ӱ���
	 */
	public void addAcc() {
		// ��ȡǰ�˴�����json��
		// ��ȡ���ݣ�ͨ�����ķ�ʽ
		String s = HttpKit.readData(getRequest());
		Accompaniment acc = JsonKit.parse(s, Accompaniment.class);
		boolean flag = AccService.isExistAcc(acc);
		if (flag) {
			// �Ѿ����ڴ˰���
			renderText("false");
		} else {
			boolean b = AccService.addAcc(acc);
			String returnStr = String.valueOf(b);
			renderText(returnStr);
		}
	}

	/**
	 * ��ȡ���а���
	 */
	public List<Accompaniment> getAllAccs() {
		return Accompaniment.dao.find("select * from accompaniment");
	}

	/**
	 * ��ȡ�Ҵ����İ���
	 */
	public void getMyAccs() {
		List<Accompaniment> accs = getAllAccs();
		List<Accompaniment> accs0 = new ArrayList<Accompaniment>();
		System.out.println("accs�ĳ�����" + accs.size());
		User user = (User) getSession().getAttribute("user");
		if (user != null) {
			for (Accompaniment accompaniment : accs) {
				System.out.println("��������ǿѭ��");

				if (accompaniment.getAuthorid().equals(user.getId())) {

					System.out.println("�õ�����Ӧ����");
					accs0.add(accompaniment);
				}
			}

			System.out.println("list�ĳ�����" + accs.size());
			String json = JsonKit.toJson(accs0);
			System.out.println("�õ�����" + json);
			renderText(json);
		}
		renderText(null);
	}

	/**
	 * ��ѯָ���û��İ���
	 */
	public void getAccsByUSer() {
		// ��ȡǰ�˴�����json��
		// ��ȡ���ݣ�ͨ�����ķ�ʽ
		String s = HttpKit.readData(getRequest());
		User user = JsonKit.parse(s, User.class);
		User user2 = null;
		// ����ѯ���û�����
		if (UserService.isExitUser(user)) {
			user2 = UserService.getUserMsg(user);
			List<Accompaniment> accs0 = new ArrayList<Accompaniment>();
			List<Accompaniment> accs = AccService.getAllAccs();
			for (Accompaniment accompaniment : accs) {
				if (accompaniment.getAuthorid().equals(user2.getId())) {
					accs0.add(accompaniment);
				}
			}
			// ת��Ϊjson��ʽ
			String json = JsonKit.toJson(accs);
			renderText(json);
		}
		renderText(null);
	}

	/**
	 * TODO ��������
	 */

}
