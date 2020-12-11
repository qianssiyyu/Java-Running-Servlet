package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Democollect;

/**
 * 伴奏收藏
 * @author Aimer
 *
 */
public class DemoColService {
	
	/**
	 * 添加到我的收藏
	 * @return
	 */
	public static boolean add2Col(Democollect democollect) {
		// 判断这个伴奏是否存在
		if (isExitst(democollect)) {
			// 存在，返回false
			return false;
		}
		// 不存在，进行存储
		return democollect.save();
	}

	/**
	 * 删除democol
	 * @param democol
	 * @return
	 */
	public static boolean delFromCol(Democollect democollect) {
		// 判断这个伴奏是否存在
		if (isExitst(democollect)) {
			// 存在
			return democollect.delete();
		}
		// 不存在
		return false;
	}

	/**
	 * 此democol是否存在
	 * @param democollect
	 * @return
	 */
	public static boolean isExitst(Democollect democollect) {
		// 判断是否存在此收藏信息
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
	 * 得到所有的democol
	 * @return
	 */
	public static List<Democollect> getAllCol() {
		List<Democollect> democollects = Democollect.dao.find("select * from democollect");
		return democollects;
	}
}
