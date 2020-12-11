package com.rapstar.service;

import java.util.ArrayList;
import java.util.List;

import com.rapstar.model.Song;
import com.rapstar.model.User;

public class SongService {
	/**
	 * 判断添加的是否已经存在
	 * 
	 * @param song
	 * @return
	 */
	// TODO：add code
	public static boolean isExistSong(Song song) {
		List<Song> songs = getAllSongs();
		for (Song song2 : songs) {
			// 已经存在该伴奏
			if (song.getName().equals(song2.getName())) {
				//存在该歌曲
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断添加的是否已经存在
	 * 
	 * @param song
	 * @return
	 */
	// TODO：add code
	public static Song getSongMsg(Song song) {
		List<Song> songs = getAllSongs();
		for (Song song2 : songs) {
			// 已经存在该歌曲
			if (song.getName().equals(song2.getName())) {
				return song;
			}
		}
		return null;
	}

	/**
	 * 获取所有歌曲信息
	 * 
	 * @return
	 */
	public static List<Song> getAllSongs() {
		List<Song> songs = Song.dao.find("select * from song");
		return songs;
	}

	/**
	 * 获取指定用户创作的音乐
	 * 
	 * @return
	 */
	public static List<Song> getMySongs(User user) {
		List<Song> songs = new ArrayList<Song>();
		// 获取所有歌曲信息
		List<Song> songs0 = getAllSongs();
		// 查找“我创作的歌曲信息”
		for (Song song : songs0) {
			if (song.getAuthorid().equals(user.getId())) {
				songs.add(song);
			}
		}
		return songs;
	}

	/**
	 * 删除指定音乐
	 * 
	 * @return
	 */
	public static boolean deleteSong(Song song) {
		return song.delete();
	}

	/**
	 * 增加音乐
	 * 
	 * @param song
	 * @return
	 */
	public static boolean addSong(Song song) {
		return song.save();
	}

}
