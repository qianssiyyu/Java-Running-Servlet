package com.rapstar.manager.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.rapstar.entity.Manager;
import com.rapstar.entity.User;

@Repository
public class ManagerDao {
	@Resource
	private SessionFactory sessionFactory;
	private Gson gson = new Gson();

	
	
	
	public int countByPage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from Manager";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	public List<Manager> findByPage(int pageNum, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String hql = "from Manager";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	
	}
	/**
	 * 根据phone获取id
	 * 
	 * @param phone
	 * @return
	 */
	public int getIdByPhone(String phone) {
		Session session = sessionFactory.openSession();
		String hql = "select id from Manager where phone=:phone";
		Query query = session.createQuery(hql);
		query.setParameter("phone", phone);
		System.out.println("phone:" + phone);
		if (null == query) {
			System.out.println("query is null");

		}
		int id;
		if (null == query.uniqueResult()) {
			System.out.println("query.uniqueResult() is null");
			id = -1;
		} else {
			id = (int) query.uniqueResult();
		}

		session.close();
		return id;
	}

	/**
	 * 登录
	 * 
	 * @param phone
	 * @param password
	 * @return
	 */
	public boolean login(String phone, String password) {
		Session session = sessionFactory.openSession();
		String hql = "from Manager where phone =:phone and password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("phone", phone);
		query.setParameter("password", password);
		Manager manager = (Manager) query.uniqueResult();
		session.close();
		return null == manager ? false : true;
	}

	/**
	 * 根据id或phone获取manager
	 * 
	 * @param arg
	 * @return
	 */
	public Manager getManagerByIdOrPhone(String id, String phone) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Manager.class);
		if (null != id) {
			Criterion c1 = Restrictions.eq("id", id);
			criteria.add(c1);
		}
		if (null != phone) {
			Criterion c2 = Restrictions.eq("phone", phone);
			criteria.add(c2);
		}
		Manager manager = (Manager) criteria.uniqueResult();
		session.close();

		return null != manager ? manager : null;
	}

	/**
	 * 获取所有manager
	 * 
	 * @return
	 */
	public List<Manager> getAllManagers() {
		Session session = sessionFactory.openSession();
		String hql = "from Manager";
		Query query = session.createQuery(hql);
		List<Manager> managers = query.list();
		session.close();
		if (null != managers && 0 != managers.size()) {
			return managers;
		} else {
			return null;
		}
	}

	/**
	 * 根据id或phone删除manager
	 * 
	 * @param arg
	 * @return
	 */
	public boolean deleteManagerByIdOrPhone(String id, String phone) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Manager manager = getManagerByIdOrPhone(id, phone);
		session.delete(manager);
		manager = getManagerByIdOrPhone(id, phone);
		transaction.commit();
		session.close();

		return null == manager ? true : false;
	}

}
