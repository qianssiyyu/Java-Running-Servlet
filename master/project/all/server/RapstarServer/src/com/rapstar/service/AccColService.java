package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Acccollect;

public class AccColService {

	/**
	 * ��ӵ��ҵ��ղ�
	 * 
	 * @return
	 */
	public static boolean add2Col(Acccollect acccollect) {
		// �ж���������Ƿ����
		if (isExtst(acccollect)) {
			// ���ڣ�����false
			return false;
		}
		// �����ڣ����д洢
		return acccollect.save();
	}

	/**
	 * 
	 * @param acccollect
	 * @return
	 */
	public static boolean delFromCol(Acccollect acccollect) {
		// �ж���������Ƿ����
		if (isExtst(acccollect)) {
			// ����
			return acccollect.delete();
		}
		// ������
		return false;
	}

	/**
	 * �˰����Ƿ����
	 * 
	 * @param acccollect
	 * @return
	 */
	public static boolean isExtst(Acccollect acccollect) {
		// �ж��Ƿ���ڴ��ղ���Ϣ
		List<Acccollect> acccollects = getAllCol();
		for (Acccollect acccollect2 : acccollects) {
			if (acccollect.getUserid().equals(acccollect2.getUserid())
					&& acccollect.getAccid().equals(acccollect2.getAccid())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * �õ����еİ���
	 * 
	 * @return
	 */
	public static List<Acccollect> getAllCol() {
		List<Acccollect> acccollects = Acccollect.dao.find("select * from acccollect");
		return acccollects;
	}

}
