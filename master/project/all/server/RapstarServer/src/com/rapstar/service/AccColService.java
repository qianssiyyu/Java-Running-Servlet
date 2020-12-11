package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Acccollect;

public class AccColService {

	/**
	 * 添加到我的收藏
	 * 
	 * @return
	 */
	public static boolean add2Col(Acccollect acccollect) {
		// 判断这个伴奏是否存在
		if (isExtst(acccollect)) {
			// 存在，返回false
			return false;
		}
		// 不存在，进行存储
		return acccollect.save();
	}

	/**
	 * 
	 * @param acccollect
	 * @return
	 */
	public static boolean delFromCol(Acccollect acccollect) {
		// 判断这个伴奏是否存在
		if (isExtst(acccollect)) {
			// 存在
			return acccollect.delete();
		}
		// 不存在
		return false;
	}

	/**
	 * 此伴奏是否存在
	 * 
	 * @param acccollect
	 * @return
	 */
	public static boolean isExtst(Acccollect acccollect) {
		// 判断是否存在此收藏信息
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
	 * 得到所有的伴奏
	 * 
	 * @return
	 */
	public static List<Acccollect> getAllCol() {
		List<Acccollect> acccollects = Acccollect.dao.find("select * from acccollect");
		return acccollects;
	}

}
