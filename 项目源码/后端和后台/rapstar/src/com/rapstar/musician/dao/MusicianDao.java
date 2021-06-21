package com.rapstar.musician.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rapstar.entity.Musician;
import com.rapstar.entity.User;

@Repository
public class MusicianDao {
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 获取所有的Musician
	 * 
	 * @return
	 */
	public List<Musician> getAllMusicians() {
		Session session = sessionFactory.openSession();
		String hql = "from Musician";
		Query query = session.createQuery(hql);
		List<Musician> musicians = query.list();
		session.close();
		return musicians;
	}

	/**
	 * 根据id获取Musician
	 * 
	 * @param id
	 * @return
	 */
	public Musician getMusicianById(int id) {
		Session session = sessionFactory.openSession();
		Musician musician = session.get(Musician.class, new Integer(id));
		session.close();
		return musician;
	}
	
	/**
	 * 更新musician信息
	 * @param musician
	 * @return
	 */
	public boolean updateMusician(Musician musician) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isError = false;
		try {
			// 3.保存操作
			session.saveOrUpdate(musician);
			// 4.提交事务
			transaction.commit();

		} catch (Exception e) {
			isError = true;
		} finally {
			// 5.关闭session
			session.close();
		}
		return isError?false:true;
	}
	
	/**
	 * 根据id删除musician
	 * @param id
	 * @return
	 */
	public boolean delMusicianById(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isError = false;
		try {
			// 3.保存操作
			session.delete(getMusicianById(id));
			// 4.提交事务
			transaction.commit();

		} catch (Exception e) {
			isError = true;
		} finally {
			// 5.关闭session
			session.close();
		}
		return isError?false:true;
	}
	/**
	 * 统计一共有多少条数据
	 * @return
	 */
	public int countByPage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from Musician";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	/**
	 * 分页展示
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Musician> findByPage(int pageNum, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String hql = "from Musician";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	
	}
	
}
