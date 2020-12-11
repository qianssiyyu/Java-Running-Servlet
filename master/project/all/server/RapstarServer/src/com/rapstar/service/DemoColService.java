package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Democollect;

/**
 * �����ղ�
 * @author Aimer
 *
 */
public class DemoColService {
	
	/**
	 * ��ӵ��ҵ��ղ�
	 * @return
	 */
	public static boolean add2Col(Democollect democollect) {
		// �ж���������Ƿ����
		if (isExitst(democollect)) {
			// ���ڣ�����false
			return false;
		}
		// �����ڣ����д洢
		return democollect.save();
	}

	/**
	 * ɾ��democol
	 * @param democol
	 * @return
	 */
	public static boolean delFromCol(Democollect democollect) {
		// �ж���������Ƿ����
		if (isExitst(democollect)) {
			// ����
			return democollect.delete();
		}
		// ������
		return false;
	}

	/**
	 * ��democol�Ƿ����
	 * @param democollect
	 * @return
	 */
	public static boolean isExitst(Democollect democollect) {
		// �ж��Ƿ���ڴ��ղ���Ϣ
		List<Democollect> democollects = getAllCol();
		for (Democollect democollect2 : democollects) {
			if (democollect.getUserid().equals(democollect2.getUserid())
					&& democollect.getDemoid().equals(democollect2.getDemoid())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �õ����е�democol
	 * @return
	 */
	public static List<Democollect> getAllCol() {
		List<Democollect> democollects = Democollect.dao.find("select * from democollect");
		return democollects;
	}
}
