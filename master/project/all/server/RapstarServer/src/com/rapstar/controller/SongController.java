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
	 * 上传歌曲
	 */
	public void upload() {
		String s = HttpKit.readData(getRequest());
		// 拿到需要存储的
		Song song = JsonKit.parse(s, Song.class);
		User user = (User) getSession().getAttribute("user");
		// 外键
		song.setAuthorid(user.getId());
		// 判断添加的歌曲
		boolean flag = SongService.isExistSong(song);
		if (flag) {
			// 歌曲存在
			renderText("false");
		} else {
			// 歌曲不存在
			if (SongService.addSong(song)) {
				renderText("true");
			} else {
				renderText("false");
			}
		}
	}

	/**
	 * 获取我的音乐
	 */
	public void getMySongs() {
		User user = (User) getSession().getAttribute("user");
		List<Song> songs = SongService.getMySongs(user);
		// 转化为json
		Gson gson = new Gson();
		String jsonString = gson.toJson(songs);
		render(jsonString);
	}

	/**
	 * 删除指定音乐
	 */
	public void deleteSong() {
		String s = HttpKit.readData(getRequest());
		// 拿到需要存储的
		Song song = JsonKit.parse(s, Song.class);
		User user = (User) getSession().getAttribute("user");
		if (user.getId().equals(song.getAuthorid())) {
			renderText(SongService.deleteSong(song) ? "true" : "false");
		}
	}

	// TODO:搜索

}
