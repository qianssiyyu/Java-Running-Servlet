package com.rapstar.manager.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.rapstar.entity.Manager;
import com.rapstar.entity.User;
import com.rapstar.manager.dao.ManagerDao;
import com.rapstar.util.Page;

@Service
public class ManagerService {
	@Resource
	private ManagerDao managerDao;
	
	
	public Page<Manager> listByPage(int pageNum, int pageSize) {
		Page<Manager> page = new Page<Manager>(pageNum, pageSize);		
		int count = managerDao.countByPage();
		List<Manager> list = managerDao.findByPage(pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}
	
	/**
	 * 登录
	 * 
	 * @param phone
	 * @param password
	 * @return
	 */
	public boolean login(String phone, String password) {
		return managerDao.login(phone, password);
	}
	/**
	 * 判断管理员是否存在
	 * @param phone
	 * @return
	 */
	public boolean isExist(String phone) {
		
		return managerDao.getIdByPhone(phone)>0?true:false;
	}

	

}
