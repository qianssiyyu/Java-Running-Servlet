package com.rapstar.user.dao;

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
import com.rapstar.entity.Following;
import com.rapstar.entity.Musician;
import com.rapstar.entity.User;
//import com.sun.org.apache.regexp.internal.recompile;
//import com.sun.xml.internal.bind.v2.model.core.ID;

@Repository
public class UserDao {
	@Resource
	private SessionFactory sessionFactory;
	private Gson gson = new Gson();
	
	public void editUser(User u) {
		/*System.out.println("userdao");
		int id = u.getId();
		Session session = sessionFactory.openSession();
		String hql = "update User u set u.stars = :stars where id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("stars",u.getStars());
		query.setParameter("id",id);
		int row = query.executeUpdate();*/
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(u);
		tx.commit();
		session.close();
		
	}
	
	/**
	 * �����ֻ��Ų�ѯid
	 * @param phone
	 * @return
	 */
	public int getIdByPhone(String phone) {
		Session session = sessionFactory.openSession();
		String hql = "select id from User where phone=:phone";
		Query query = session.createQuery(hql);
		query.setParameter("phone",phone);
		int id = (int)query.uniqueResult();
		session.close();
		return id;
	}
	
	/**
	 * ���ڵ�¼�ж�
	 * @param phone
	 * @param password
	 * @return
	 */
	public boolean login(String phone,String password) {
		Session session = sessionFactory.openSession();
		String hql = "from User where phone =:phone and password = :password";
		Query query = session.createQuery(hql);
		query.setParameter("phone", phone);
		query.setParameter("password", password);
		User user = (User)query.uniqueResult();
		session.close();
		return null==user?false:true;
	}

	/**
	 * ����id���ֻ������ѯ�û���Ϣ
	 * @param arg
	 * @return
	 */
	public User getUserByIdOrPhone(String id,String phone) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		if (null!=id) {
			Criterion c1 = Restrictions.eq("id", id);
			criteria.add(c1);
		}
		if (null!=phone) {
			Criterion c2 = Restrictions.eq("phone", phone);
			criteria.add(c2);
		}
		User user = (User)criteria.uniqueResult();
		session.close();
		
		return null!=user?user:null;
	}
	
	/**
	 * ��ȡ�����û���Ϣ
	 * @return
	 */
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		String hql="from User";
		Query query = session.createQuery(hql);
		List<User> users = query.list();
		session.close();
		if(null!=users&&0!=users.size()){
			return users;
		}else {
			return null;
		}
	}
	
	/**
	 * ����id���ֻ�����ɾ���û�
	 * @param arg
	 * @return
	 */
	public boolean deleteUserByIdOrPhone(String id,String phone) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		User user = getUserByIdOrPhone(id, phone);
		session.delete(user);
		user=getUserByIdOrPhone(id, phone);
		transaction.commit();
		session.close();
		
		return null==user?true:false;
	}
	
	
	/**
	 * 根据用户手机号得到用户信息
	 * @param phone
	 * @return
	 */
	public User getUserByPhone(String phone) {
		Session session = sessionFactory.openSession();
		String hql = "from User where phone=:phone";
		Query query = session.createQuery(hql);
		query.setParameter("phone",phone);
		User user = (User)query.uniqueResult();
		
		Integer id=user.getId();
		
		String sql1="from Following where star=:star";
		Query query1=session.createQuery(sql1);
		query1.setParameter("star", id);
		List<Following> fs=query1.list();
		
		String sql2="from Following where follower=:follower";
		Query query2=session.createQuery(sql2);
		query2.setParameter("follower", id);
		List<Following> fss=query2.list();
		System.out.println("粉丝："+fs.size()+"     关注："+fss.size());
		user.setStars(fss.size());
		user.setFollowers(fs.size());
		
		session.close();
		return user;
	}
	
	public int countByPage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from User";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	public List<User> findByPage(int pageNum, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	
	}
	public int deleteUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "delete from User where id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		int row = query.executeUpdate();
		return row;
	}
/*
	 * 得到热门歌手
	 */
	
	public List<Musician> getHotMusicians() {
		Session session = sessionFactory.openSession();
		String hql="from Musician";
		Query query = session.createQuery(hql);
		List<Musician> musicians = query.list();
		session.close();
		if(null!=musicians&&0!=musicians.size()){
			return musicians;
		}else {
			return null;
		}
	}
	
	/**
	 * 根据音乐人id得到音乐人
	 * @param arg
	 * @return
	 */
	public Musician getMusicianById(Integer id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Musician.class);
		if (null!=id) {
			Criterion c1 = Restrictions.eq("id", id);
			criteria.add(c1);
		}
		
		Musician musician = (Musician)criteria.uniqueResult();
		session.close();
		
		return null!=musician?musician:null;
	}
}
