package com.rapstar.service;

import java.util.ArrayList;
import java.util.List;

import com.rapstar.model.Accompaniment;
import com.rapstar.model.Song;
import com.rapstar.model.Style;

public class StyleService {

	/**
	 * ��ȡָ�����͵ĸ���
	 */
	public static List<Song> getSongsByStyle(Style style) {
		List<Song> songs0 = new ArrayList<Song>();
		List<Song> songs = SongService.getAllSongs();
		for (Song song : songs) {
			if (song.getStyle().equals(style.getId())) {
				songs0.add(song);
			}
		}
		return songs0;
	}

	/**
	 * ��ȡָ�����͵İ���
	 */
	public static List<Accompaniment> getAccsByStyle(Style style) {
		List<Accompaniment> accs0 = new ArrayList<Accompaniment>();
		List<Accompaniment> accs = AccService.getAllAccs();
		for (Accompaniment acc : accs) {
			if (acc.getStyle().equals(style.getId())) {
				accs0.add(acc);
			}
		}
		return accs0;
	}

	
	/**
	 * ��ȡ��������
	 */
	public static List<Style> getAllStyles() {
		List<Style> styles = Style.dao.find("select * from style");
		return styles;
	}

	/**
	 * ɾ��������
	 */
	public static boolean deleteSongsByStyle(Style style) {

		List<Song> songs = SongService.getAllSongs();
//		for (Song song : songs) {
//			if (song.getStyle().equals(style.getId())) {
//				if (!song.delete()) {
//					return false;
//				}
//			}
//		}
		if (style.delete()) {
			return true;
		}
		return false;
	}

	/**
	 * �޸�����
	 */
	public static boolean resetStyle(String newName,String oldName) {
		//��ȡ��id��֮��update
		List<Style> styles = Style.dao.find("select * from style");
		for (Style style : styles) {
			if (style.getName().equals(oldName)) {
				style.setName(newName);
				return style.update();
			}
		}
		return false;
	}
}
