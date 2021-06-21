package com.rapstar.songlist.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rapstar.entity.Song;
import com.rapstar.entity.SongList;
import com.rapstar.entity.User;
import com.rapstar.song.dao.SongDao;
import com.rapstar.songlist.dao.SongListDao;
import com.rapstar.util.Page;

@Service
@Transactional(readOnly = false)
public class SongListService {
	@Resource
	private SongListDao songListDao;
	
	
	public Page<SongList> listByPage(int pageNum, int pageSize) {
		Page<SongList> page = new Page<SongList>(pageNum, pageSize);		
		int count = songListDao.countByPage();
		List<SongList> list = songListDao.findByPage(pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}
	/*
	 * 
	 * 得到全部歌单
	 */
	public List<SongList> getAllSongs(){
		System.out.println("1");
		return songListDao.getAllSongLists();
	}
	/*
	 * 
	 * 根据用户id和所要的收藏/本地等来查询歌曲列表
	 */
	public List<SongList> getSonglistsByUserAndWant(Integer id,String want){
		return songListDao.getSonglistsByUserAndWant(id, want);
	}
	
	
}
