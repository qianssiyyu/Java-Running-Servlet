package com.rapstar.keyword.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rapstar.entity.KeyWord;
import com.rapstar.entity.User;

@Repository
public class KeywordDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public int countByPage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from KeyWord";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	
	public List<KeyWord> findAll() {
		Session session = this.sessionFactory.openSession();
		String hql = "from KeyWord k order by k.mycount desc";
		
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(10);
		
		return query.list();
	
	}

}
