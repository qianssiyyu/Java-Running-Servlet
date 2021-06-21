package com.rapstar.acclist.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rapstar.entity.Acclist;
import com.rapstar.entity.Manager;
import com.rapstar.entity.Song;
import com.rapstar.entity.SongList;

@Repository
public class AccListDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public int countByPage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from Acclist";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	public List<Acclist> findByPage(int pageNum, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String hql = "from Acclist";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	
	}
	
	/*
	 * 
	 * 得到全部伴奏单
	 */
	public List<Acclist> getAllAccLists(){
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Acclist");
		List<Acclist> acclists=query.list();
		
		if(null!=acclists&&0!=acclists.size()) {
			
			return acclists;
		}else {
			return null;
		}
	}
	


}
