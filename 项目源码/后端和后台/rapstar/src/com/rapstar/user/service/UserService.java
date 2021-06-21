package com.rapstar.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rapstar.entity.Musician;
import com.rapstar.entity.User;
import com.rapstar.user.dao.UserDao;
import com.rapstar.util.Page;

@Service
@Transactional(readOnly = false)
public class UserService {
	@Resource
	private UserDao userDao;
	
	public int editUser(User u) {
		System.out.print("userservice");
		userDao.editUser(u);
		return 1;
	}
	
	/**
	 * �����ֻ��Ų�ѯid
	 * @param phone
	 * @return
	 */
	public int getIdByPhone(String phone) {
		return userDao.getIdByPhone(phone);
	}
	
	/**
	 * ���ڵ�¼�ж�
	 * @param phone
	 * @param password
	 * @return
	 */
	public boolean login(String phone,String password) {
		return userDao.login(phone, password);
	}

	/**
	 * ����id���ֻ������ѯ�û���Ϣ
	 * @param arg
	 * @return
	 */
	public User getUserByIdOrPhone(String id,String phone) {
		return userDao.getUserByIdOrPhone(id, phone);
	}
	
	/**
	 * ��ȡ�����û���Ϣ
	 * @return
	 */
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	/**
	 * ����id���ֻ�����ɾ���û�
	 * @param arg
	 * @return
	 */
	public boolean deleteUserByIdOrPhone(String id,String phone) {
		
		return userDao.deleteUserByIdOrPhone(id, phone);
	}
	/**
	 * 根据电话查询用户
	 * @param phone
	 * @return
	 */
	public User getUserByPhone(String phone) {
		return userDao.getUserByPhone(phone);
	}
	
	public Page<User> listByPage(int pageNum, int pageSize) {
		Page<User> page = new Page<User>(pageNum, pageSize);		
		int count = userDao.countByPage();
		List<User> list = userDao.findByPage(pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}
	
	public int removeUser(int id) {
		int count = this.userDao.deleteUser(id);
		return count;
	}
               /*
	 * 得到热门歌手
	 */
	
	public List<Musician> getHotMusicians() {
		return userDao.getHotMusicians().subList(29,40);
	}
	
	/*
	 * 得到全部音乐人
	 */
	public List<Musician> getAllMusicians() {
		return userDao.getHotMusicians();
	}
	
	/**
	 * 根据音乐人id得到音乐人
	 * @param arg
	 * @return
	 */
	public Musician getMusicianById(Integer id) {
		return userDao.getMusicianById(id);
	}

}
