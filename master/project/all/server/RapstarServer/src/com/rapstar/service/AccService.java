package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Accompaniment;

public class AccService {
	
	/**
	 * 是否存在此伴奏
	 * @param acc
	 * @return boolean
	 */
	public static boolean isExistAcc(Accompaniment acc) {
		//不允许由于重名
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
	 * 得到所有伴奏信息
	 * @return accs
	 */
	public static List<Accompaniment> getAllAccs(){
		List<Accompaniment> accs = Accompaniment.dao.find("select * from accompaniment");
		return accs;
	}
	
	/**
	 * 添加新伴奏
	 * @param acc
	 * @return
	 */
	public static boolean addAcc(Accompaniment acc) {
		return acc.save();
	}
}
