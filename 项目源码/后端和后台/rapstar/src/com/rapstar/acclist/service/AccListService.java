package com.rapstar.acclist.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.rapstar.acclist.dao.AccListDao;
import com.rapstar.entity.Acclist;
import com.rapstar.entity.Song;
import com.rapstar.entity.SongList;
import com.rapstar.song.dao.SongDao;
import com.rapstar.songlist.dao.SongListDao;
import com.rapstar.util.Page;

@Service
public class AccListService {
	@Resource
	private AccListDao accListDao;
	/*
	 * 
	 * 得到全部伴奏单
	 */
	public List<Acclist> getAllAccLists(){
		System.out.println("1");
		return accListDao.getAllAccLists();
	}
	
	public Page<Acclist> listByPage(int pageNum, int pageSize) {
		Page<Acclist> page = new Page<Acclist>(pageNum, pageSize);		
		int count = accListDao.countByPage();
		List<Acclist> list = accListDao.findByPage(pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}
	
	
	
}
