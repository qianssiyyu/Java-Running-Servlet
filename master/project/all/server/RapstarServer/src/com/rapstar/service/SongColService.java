package com.rapstar.service;

import java.util.List;

import com.rapstar.model.Songcollect;

public class SongColService {
	
	/**
	 * ��ӵ��ҵ��ղ�
	 * @return
	 */
	public static boolean add2Col(Songcollect songcollect) {
		// �ж���������Ƿ����
		if (isExitst(songcollect)) {
			// ���ڣ�����false
			return false;
		}
		// �����ڣ����д洢
		return songcollect.save();
	}

	/**
	 * ɾ��songcol
	 * @param democol
	 * @return
	 */
	public static boolean delFromCol(Songcollect songcollect) {
		// �ж���������Ƿ����
		if (isExitst(songcollect)) {
			// ����
			return songcollect.delete();
		}
		// ������
		return false;
	}

	/**
	 * ��songcol�Ƿ����
	 * @param songcollect
	 * @return
	 */
	public static boolean isExitst(Songcollect songcollect) {
		// �ж��Ƿ���ڴ��ղ���Ϣ
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
	 * �õ����е�songcol
	 * @return
	 */
	public static List<Songcollect> getAllCol() {
		List<Songcollect> songcollects = Songcollect.dao.find("select * from songcollect");
		return songcollects;
	}
}
