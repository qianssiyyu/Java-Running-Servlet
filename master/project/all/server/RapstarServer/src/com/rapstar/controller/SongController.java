package com.rapstar.controller;

import java.util.List;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Song;
import com.rapstar.model.User;
import com.rapstar.service.SongService;
import com.rapstar.service.UserService;

public class SongController extends Controller {
	/**
	 * �ϴ�����
	 */
	public void upload() {
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
		// ת��Ϊjson
		Gson gson = new Gson();
		String jsonString = gson.toJson(songs);
		render(jsonString);
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
