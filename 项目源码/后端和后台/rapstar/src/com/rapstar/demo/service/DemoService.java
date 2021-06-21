package com.rapstar.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rapstar.demo.dao.DemoDao;
import com.rapstar.entity.Demo;
import com.rapstar.entity.User;
import com.rapstar.util.Page;

@Service
@Transactional(readOnly = false)
public class DemoService {
	@Resource
	private DemoDao demoDao;
	/**
	 * ��ȡ����demo
	 * 
	 * @return
	 */
	public List<Demo> getAllDemos() {
		return demoDao.getAllDemos();
	}
	
	public Page<Demo> listByPage(int pageNum, int pageSize) {
		Page<Demo> page = new Page<Demo>(pageNum, pageSize);		
		int count = demoDao.countByPage();
		List<Demo> list = demoDao.findByPage(pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}



	/**
	 * ����id��name��ѯdemo��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	public Demo getDemoByIdOrName(String id, String name) {
		return demoDao.getDemoByIdOrName(id, name);
	}

	/**
	 * ����id��nameɾ��demo��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	public boolean deleteDemoByIdOrName(String id, String name) {
		return demoDao.deleteDemoByIdOrName(id, name);
	}

	/**
	 * ���demo
	 * 
	 * @param demo
	 * @return
	 */
	public boolean addDemo(Demo demo) {
		return demoDao.addDemo(demo);
	}
	
	
	/**
	 * 根据用户id得到demo
	 * 
	 * @return
	 */
	public List<Demo> getDemosById(Integer id) {
		return demoDao.getDemosById(id);
	}
	/*
	 * 
	 * 根据用户id和所要的收藏/本地等来查询歌曲列表
	 */
	public List<Demo> getDemosByUserAndWant(Integer id,String want){
		return demoDao.getDemosByUserAndWant(id, want);
	}

}
