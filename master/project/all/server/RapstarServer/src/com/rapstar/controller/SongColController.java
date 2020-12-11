package com.rapstar.controller;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Song;
import com.rapstar.model.Songcollect;
import com.rapstar.model.User;
import com.rapstar.service.SongColService;
import com.rapstar.service.SongService;
import com.rapstar.service.UserService;

public class SongColController extends Controller{
	
	/**
	 * ��ӵ��ղ�
	 */
	public void add2Col() {
		User user = (User) getSession().getAttribute("user");
		int uid = user.getId();
		String s = HttpKit.readData(getRequest());
		Song song0 = JsonKit.parse(s, Song.class);
		Song song =  SongService.getSongMsg(song0);
		Songcollect songcollect = new Songcollect();
		songcollect.setUserid(uid);
		songcollect.setSongid(song.getId());
		renderText(SongColService.add2Col(songcollect) + "");
	}

	/**
	 * ȡ���ղ�
	 */
	public void delFromCol() {
		User user = (User) getSession().getAttribute("user");
		int uid = user.getId();

		String s = HttpKit.readData(getRequest());
		Song song = JsonKit.parse(s, Song.class);
		Song song2 = SongService.getSongMsg(song);
		Songcollect songcollect = new Songcollect();
		songcollect.setUserid(uid);
		songcollect.setSongid(song2.getId());
		renderText(SongColService.delFromCol(songcollect) + "");
	}

	/**
	 * ��ȡ�ҵ��ղ�
	 * �޲�
	 * 
	 */
	public void getMyCol() {
		User user = (User) getSession().getAttribute("user");
		List<Songcollect> songcollects = SongColService.getAllCol();
		List<Song> songs = new ArrayList<Song>();
		for (Songcollect songcollect : songcollects) {
			if (songcollect.getUserid().equals(user.getId())) {
				songs.add(Song.dao.findById(songcollect.getSongid()));
			}
		}
		if (songs.size()!=0) {
			String json = JsonKit.toJson(songs);
			renderText(json);			
		}
		renderText(null);
	}

	/**
	 * ��ȡָ���û����ղ�
	 * ������user��json��ʽ 
	 * ���ص���songs ��json��ʽ
	 */
	public void getUserCol() {
		String s = HttpKit.readData(getRequest());
		User user0 = JsonKit.parse(s, User.class);
		User user = UserService.getUserMsg(user0);
		
		List<Songcollect> songcollects = SongColService.getAllCol();
		List<Song> songs = new ArrayList<Song>();
		for (Songcollect songcollect : songcollects) {
			if (songcollect.getUserid().equals(user.getId())) {
				songs.add(Song.dao.findById(songcollect.getSongid()));
			}
		}
		if (songs.size()!=0) {
			String json = JsonKit.toJson(songs);
			renderText(json);			
		}
		renderText(null);
	}

}
