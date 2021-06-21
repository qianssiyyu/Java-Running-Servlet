package com.rapstar.demo.dao;

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
import org.springframework.stereotype.Repository;

import com.rapstar.entity.Demo;
import com.rapstar.entity.User;

@Repository
public class DemoDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	
	public int countByPage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from Demo";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	public List<Demo> findByPage(int pageNum, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String hql = "from Demo";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	
	}

	/**
	 * ��ȡ����demo
	 * 
	 * @return
	 */
	public List<Demo> getAllDemos() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Demo");
		List<Demo> demos = query.list();
		session.close();
		if (null != demos && 0 != demos.size()) {
			return demos;
		} else {
			return null;
		}
	}

//	/**
//	 * TODO:demo�������� ����demo����ȡdemo��Ϣ
//	 * 
//	 * @param name
//	 * @return
//	 */
//	public Demo getDetailByName(String name) {
//		Session session = sessionFactory.openSession();
//		Query query = session.createQuery("from demo where name=:name");
//		query.setParameter("name", name);
//		Demo demo = (Demo) query.uniqueResult();
//		if (demo != null) {
//			return demo;
//		}
//		return null;
//	}

	/**
	 * ����id��name��ѯdemo��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	public Demo getDemoByIdOrName(String id, String name) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Demo.class);
		if (null != id) {
			Criterion c1 = Restrictions.eq("id", id);
			criteria.add(c1);
		}
		if (null != name) {
			Criterion c2 = Restrictions.eq("name", name);
			criteria.add(c2);
		}
		Demo demo = (Demo) criteria.uniqueResult();
		session.close();

		return null != demo ? demo : null;
	}

	/**
	 * ����id��nameɾ��demo��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	public boolean deleteDemoByIdOrName(String id, String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Demo demo = getDemoByIdOrName(id, name);
		session.delete(demo);
		demo = getDemoByIdOrName(id, name);
		session.close();

		return null == demo ? true : false;
	}

	/**
	 * ���demo
	 * 
	 * @param demo
	 * @return
	 */
	public boolean addDemo(Demo demo) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int num = (int) session.save(demo);
		transaction.commit();
		session.close();
		return num > 0 ? true : false;
	}
	
	
	/**
	 * 根据用户id得到demo
	 * 
	 * @return
	 */
	public List<Demo> getDemosById(Integer id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Demo where authorid=:id");
		query.setParameter("id", id);
		List<Demo> demos = query.list();
		session.close();
		if (null != demos && 0 != demos.size()) {
			return demos;
		} else {
			return null;
		}
	}
	/*
	 * 根据用户id和想要的collect
	 */
	
	public List<Demo> getDemosByUserAndWant(Integer id,String want){
		Session session=sessionFactory.openSession();
		List<Demo> demos=new ArrayList<Demo>();
		if(want.equals("collect")) {
			//根据用户id查询到歌曲id
			Query query=session.createQuery("select demoid from DemoCollect where userid=:x");
			query.setParameter("x", id);
			List<Integer> ids=query.list();
			//根据歌曲id查询歌曲列表
			for(int i=0;i<ids.size();i++) {
				Query query1=session.createQuery("from Demo where id=:id");
				query1.setParameter("id", ids.get(i));
				Demo demo=(Demo) query1.list().get(0);
				demos.add(demo);
			}	
		}
		
		session.close();
		if(null!=demos&&0!=demos.size()) {
			return demos;
		}else {
			return null;
		}
	}

}
