package com.rapstar.musician.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rapstar.entity.Musician;
import com.rapstar.entity.User;
import com.rapstar.musician.dao.MusicianDao;
import com.rapstar.util.Page;
@Service
public class MusicianService {
	@Resource
	private MusicianDao musicianDao;

	/**
	 * 获取所有的Musician
	 * 
	 * @return
	 */
	public List<Musician> getAllMusicians() {
		return musicianDao.getAllMusicians();
	}

	/**
	 * 根据id获取Musician
	 * 
	 * @param id
	 * @return
	 */
	public Musician getMusicianById(int id) {
		return musicianDao.getMusicianById(id);
	}
	
	/**
	 * 更新musician信息
	 * @param musician
	 * @return
	 */
	public boolean updateMusician(Musician musician) {
		return musicianDao.updateMusician(musician);
	}
	
	/**
	 * 根据id删除musician
	 * @param id
	 * @return
	 */
	public boolean delMusicianById(Integer id) {
		return musicianDao.delMusicianById(id);
	}
	
	public Page<Musician> listByPage(int pageNum, int pageSize) {
		Page<Musician> page = new Page<Musician>(pageNum, pageSize);		
		int count = musicianDao.countByPage();
		List<Musician> list = musicianDao.findByPage(pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}
}
