package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Songcollect;

public class SongColService {
	
	/**
	 * 添加到我的收藏
	 * @return
	 */
	public static boolean add2Col(Songcollect songcollect) {
		// 判断这个伴奏是否存在
		if (isExitst(songcollect)) {
			// 存在，返回false
			return false;
		}
		// 不存在，进行存储
		return songcollect.save();
	}

	/**
	 * 删除songcol
	 * @param democol
	 * @return
	 */
	public static boolean delFromCol(Songcollect songcollect) {
		// 判断这个伴奏是否存在
		if (isExitst(songcollect)) {
			// 存在
			return songcollect.delete();
		}
		// 不存在
		return false;
	}

	/**
	 * 此songcol是否存在
	 * @param songcollect
	 * @return
	 */
	public static boolean isExitst(Songcollect songcollect) {
		// 判断是否存在此收藏信息
		List<Songcollect> songcollects = getAllCol();
		for (Songcollect songcollect2 : songcollects) {
			if (songcollect.getUserid().equals(songcollect2.getUserid())
					&& songcollect.getSongid().equals(songcollect2.getSongid())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 得到所有的songcol
	 * @return
	 */
	public static List<Songcollect> getAllCol() {
		List<Songcollect> songcollects = Songcollect.dao.find("select * from songcollect");
		return songcollects;
	}
}
