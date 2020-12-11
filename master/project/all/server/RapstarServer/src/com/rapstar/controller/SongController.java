package com.rapstar.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Song;
import com.rapstar.model.User;
import com.rapstar.service.SongService;

public class SongController extends Controller {
	/**
	 * �ϴ�����
	 */
	public void upload() {
		// TODO:���������ز�������д��
		String s = HttpKit.readData(getRequest());
		// �õ���Ҫ�洢��
		Song song = JsonKit.parse(s, Song.class);
		User user = (User) getSession().getAttribute("user");
		// ���
		song.setAuthorid(user.getId());
		// �ж���ӵĸ���
		boolean flag = SongService.isExistSong(song);
		if (flag) {
			// ��������
			renderText("false");
		} else {
			// ����������
			if (SongService.addSong(song)) {
				renderText("true");
			} else {
				renderText("false");
			}
		}
	}

	/**
	 * ��ȡ�ҵ�����
	 */
	public void getMySongs() {
		User user = (User) getSession().getAttribute("user");
		List<Song> songs = SongService.getMySongs(user);
		// ת��Ϊjson��ʽ
		String json = JsonKit.toJson(songs);
		// ����
		renderText(json);
	}

	/**
	 * ɾ��ָ������
	 */
	public void deleteSong() {
		String s = HttpKit.readData(getRequest());
		// �õ���Ҫ�洢��
		Song song = JsonKit.parse(s, Song.class);
		User user = (User) getSession().getAttribute("user");
		if (user.getId().equals(song.getAuthorid())) {
			renderText(SongService.deleteSong(song) ? "true" : "false");
		}
	}

	// TODO:����

}
