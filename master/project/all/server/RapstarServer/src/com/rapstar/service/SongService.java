package com.rapstar.service;

import java.util.ArrayList;
import java.util.List;

import com.rapstar.model.Song;
import com.rapstar.model.User;

public class SongService {
	/**
	 * �ж���ӵ��Ƿ��Ѿ�����
	 * 
	 * @param song
	 * @return
	 */
	// TODO��add code
	public static boolean isExistSong(Song song) {
		List<Song> songs = getAllSongs();
		for (Song song2 : songs) {
			// �Ѿ����ڸð���
			if (song.getName().equals(song2.getName())) {
				//���ڸø���
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �ж���ӵ��Ƿ��Ѿ�����
	 * 
	 * @param song
	 * @return
	 */
	// TODO��add code
	public static Song getSongMsg(Song song) {
		List<Song> songs = getAllSongs();
		for (Song song2 : songs) {
			// �Ѿ����ڸø���
			if (song.getName().equals(song2.getName())) {
				return song;
			}
		}
		return null;
	}

	/**
	 * ��ȡ���и�����Ϣ
	 * 
	 * @return
	 */
	public static List<Song> getAllSongs() {
		List<Song> songs = Song.dao.find("select * from song");
		return songs;
	}

	/**
	 * ��ȡָ���û�����������
	 * 
	 * @return
	 */
	public static List<Song> getMySongs(User user) {
		List<Song> songs = new ArrayList<Song>();
		// ��ȡ���и�����Ϣ
		List<Song> songs0 = getAllSongs();
		// ���ҡ��Ҵ����ĸ�����Ϣ��
		for (Song song : songs0) {
			if (song.getAuthorid().equals(user.getId())) {
				songs.add(song);
			}
		}
		return songs;
	}

	/**
	 * ɾ��ָ������
	 * 
	 * @return
	 */
	public static boolean deleteSong(Song song) {
		return song.delete();
	}

	/**
	 * ��������
	 * 
	 * @param song
	 * @return
	 */
	public static boolean addSong(Song song) {
		return song.save();
	}

}
