package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Accompaniment;

public class AccService {
	
	/**
	 * �Ƿ���ڴ˰���
	 * @param accs
	 * @return boolean
	 */
	public static boolean isExistAcc(Accompaniment acc) {
		//������������
		String accName = acc.getName();
		List<Accompaniment> accs = getAllAccs();
		for (Accompaniment accompaniment : accs) {
			if (accompaniment.getName().equals(accName)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ��ȡ������ϸ��Ϣ
	 */
	public static Accompaniment getAccMsg(Accompaniment acc) {
		String accName = acc.getName();
		List<Accompaniment> accs = getAllAccs();
		for (Accompaniment accompaniment : accs) {
			if (accompaniment.getName().equals(accName)) {
				return accompaniment;
			}
		}
		return null;
	}
	
	/**
	 * �õ����а�����Ϣ
	 * @return accs
	 */
	public static List<Accompaniment> getAllAccs(){
		List<Accompaniment> accs = Accompaniment.dao.find("select * from accompaniment");
		return accs;
	}
	
	/**
	 * ����°���
	 * @param acc
	 * @return
	 */
	public static boolean addAcc(Accompaniment acc) {
		return acc.save();
	}
}
