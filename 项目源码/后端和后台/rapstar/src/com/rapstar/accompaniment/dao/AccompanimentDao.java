package com.rapstar.accompaniment.dao;

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

import com.rapstar.entity.Accompaniment;
import com.rapstar.entity.User;
@Repository
public class AccompanimentDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
	
	public int countByPage() {
		Session session = this.sessionFactory.openSession();
		String hql = "select count(*) from Accompaniment";
		Query query = session.createQuery(hql);
		long num = (Long)query.uniqueResult();		
		return (int)num;
	}
	
	
	public List<User> findByPage(int pageNum, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String hql = "from Accompaniment";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	
	}

	/**
	 * ��ȡ����Accompaniment
	 * 
	 * @return
	 */
	public List<Accompaniment> getAllAccompaniments() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Accompaniment");
		List<Accompaniment> accompaniments = query.list();
		session.close();
		if (null != accompaniments && 0 != accompaniments.size()) {
			return accompaniments;
		} else {
			return null;
		}
	}


	/**
	 * ����id��name��ѯAccompaniment��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	public Accompaniment getAccompanimentByIdOrName(String id, String name) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Accompaniment.class);
		if (null != id) {
			Criterion c1 = Restrictions.eq("id", id);
			criteria.add(c1);
		}
		if (null != name) {
			Criterion c2 = Restrictions.eq("name", name);
			criteria.add(c2);
		}
		Accompaniment accompaniment = (Accompaniment) criteria.uniqueResult();
		session.close();

		return null != accompaniment ? accompaniment : null;
	}

	/**
	 * ����id��nameɾ��Accompaniment��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	public boolean deleteAccompanimentByIdOrName(String id, String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Accompaniment accompaniment = getAccompanimentByIdOrName(id, name);
		session.delete(accompaniment);
		accompaniment = getAccompanimentByIdOrName(id, name);
		session.close();

		return null == accompaniment ? true : false;
	}

	/**
	 * ���Accompaniment
	 * 
	 * @param Accompaniment
	 * @return
	 */
	public boolean addAccompaniment(Accompaniment accompaniment) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int num = (int) session.save(accompaniment);
		transaction.commit();
		session.close();
		return num > 0 ? true : false;
	}
	
	public int updateState(int id,int flag) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = null;
		if(flag==0) {
			hql = "update Accompaniment a set a.state = 1 where id = :id";
		}else if(flag ==1) {
			hql = "update Accompaniment a set a.path = 'null' , a.state = 0 where id = :id";
		}
		Query query = session.createQuery(hql);
		
		query.setParameter("id", id);
		
		return query.executeUpdate();
		
		
		
		
	}

}
