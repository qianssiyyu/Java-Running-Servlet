package com.rapstar.song.service;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rapstar.entity.Song;
import com.rapstar.entity.User;
import com.rapstar.song.dao.SongDao;
import com.rapstar.util.Page;

@Service
@Transactional(readOnly = false)
public class SongService {
	@Resource
	private SongDao songDao;
	
	
	public int editSong(int id,int mystate) {
		int row = songDao.editSong(mystate, id);
		return row;
	}
	/*
	 * 
	 * ��ȡ���и���
	 */
	public List<Song> getAllSongs(){
		System.out.println("1");
		return songDao.getAllSongs();
	}
    /*
	 * 
	 *得到热门歌曲
	 */
	public List<Song> getHotSongs(){
		return songDao.getHotSongs();
	}
	/*
	 * 随机生成歌曲
	 */
	public List<Song> getRandomSongs(){
		return songDao.getRandomSongs();
	}
	
	/*
	 * ���ݸ赥id�鿴�����б�
	 */
	public List<Song> getSongsBySonglistid(Integer id){
		return songDao.getSongsBySonglistid(id);
	}
	
	/*
	 * ���ݸ����������ϸ��Ϣ
	 * 
	 */
	public Song getDetailByName(String name) {
		return songDao.getDetailByName(name);	
	}
	
	/*
	 * 
	 * ���ݸ���id�õ�������ϸ��Ϣ
	 */
	public Song getDetailById(Integer id) {
		return songDao.getDetailById(id);		
	}
	/*
	 * 
	 * 根据用户id和所要的收藏/本地等来查询歌曲列表
	 */
	public List<Song> getSongsByUserAndWant(Integer id,String want){
		return songDao.getSongsByUserAndWant(id, want);
	}
	
	public Page<Song> listByPage(int pageNum, int pageSize) {
		Page<Song> page = new Page<Song>(pageNum, pageSize);		
		int count = songDao.countByPage();
		List<Song> list = songDao.findByPage(pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}
	
	public Page<Song> listBySomePage(int pageNum, int pageSize) {
		Page<Song> page = new Page<Song>(pageNum, pageSize);		
		int count = songDao.countBySomePage();
		List<Song> list = songDao.findBySomePage(pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}
	
	
	
	
}
