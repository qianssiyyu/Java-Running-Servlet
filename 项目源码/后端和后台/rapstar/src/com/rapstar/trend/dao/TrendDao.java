package com.rapstar.trend.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.sql.Insert;
import org.springframework.stereotype.Repository;

import com.rapstar.entity.Demo;
import com.rapstar.entity.Song;
import com.rapstar.entity.Trend;

@Repository
public class TrendDao {
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 得到全部动态内容，点赞数由高到低
	 * 
	 * @return
	 */
	public List<Trend> getAllTrends() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Trend order by dianzannum desc");
		List<Trend> trends = query.list();
		session.close();
		if (null != trends && 0 != trends.size()) {
			return trends;
		} else {
			return null;
		}
	}
	/**
	 * 根据用户昵称得到发表过的动态
	 * 
	 * @return
	 */
	public List<Trend> getTrendsByUserName(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Trend where nickname=:name");
		query.setParameter("name", name);
		List<Trend> trends = query.list();
		session.close();
		if (null != trends && 0 != trends.size()) {
			return trends;
		} else {
			return null;
		}
	}
	
	/**
	 * 根据id得动态
	 * 
	 * @return
	 */
	public Trend getTrendsById(Integer id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Trend where id=:id");
		query.setParameter("id", id);
		Trend trend = (Trend) query.list().get(0);
		session.close();
		return trend;
	}
	
	/*
	 * 添加动态
	 */
	public void upLoadTrends(Trend trend) {
		Session session=sessionFactory.openSession();
		session.save(trend);
	}
	
}
