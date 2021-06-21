package com.rapstar.accompaniment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rapstar.accompaniment.dao.AccompanimentDao;
import com.rapstar.entity.Accompaniment;
import com.rapstar.entity.User;
import com.rapstar.util.Page;
@Service
@Transactional(readOnly = false)
public class AccompanimentService {
	@Resource
	private AccompanimentDao accompanimentDao;
	/**
	 * ��ȡ����Accompaniment
	 * 
	 * @return
	 */
	public List<Accompaniment> getAllAccompaniments() {
		return accompanimentDao.getAllAccompaniments();
	}


	/**
	 * ����id��name��ѯAccompaniment��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	public Accompaniment getAccompanimentByIdOrName(String id, String name) {
		return accompanimentDao.getAccompanimentByIdOrName(id, name);
	}

	/**
	 * ����id��nameɾ��Accompaniment��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	public boolean deleteAccompanimentByIdOrName(String id, String name) {
		return accompanimentDao.deleteAccompanimentByIdOrName(id, name);
	}

	/**
	 * ���Accompaniment
	 * 
	 * @param Accompaniment
	 * @return
	 */
	public boolean addAccompaniment(Accompaniment accompaniment) {
		return accompanimentDao.addAccompaniment(accompaniment);
	}
	
	public Page<Accompaniment> listByPage(int pageNum, int pageSize) {
		Page<Accompaniment> page = new Page<Accompaniment>(pageNum, pageSize);		
		int count = accompanimentDao.countByPage();
		List<User> list = accompanimentDao.findByPage(pageNum, pageSize);
		page.setList(list);
		page.setTotalCount(count);
		return page;
	}
	
	public int editState(int id,int flag) {		
		return this.accompanimentDao.updateState(id,flag);
	}
	

}
