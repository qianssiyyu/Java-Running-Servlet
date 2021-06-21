package com.rapstar.following.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rapstar.entity.Following;
import com.rapstar.entity.User;

@Repository
public class FollowingDao {
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 获取所有followings
	 * 
	 * @return
	 */
	public List<Following> getAllFollowings() {

		Session session = sessionFactory.openSession();
		String hql = "from Following";
		Query query = session.createQuery(hql);
		List<Following> followings = query.list();
		session.close();
		if (null != followings && 0 != followings.size()) {
			return followings;
		} else {
			return null;
		}
	}

	/**
	 * 增加一个
	 * 
	 * @param following
	 * @return
	 */
	public boolean addFollowing(Following following) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int num = (int) session.save(following);
		//�޸�startid�еķ�˿��Ŀ
		User user1 = session.get(User.class, following.getStar());
		user1.setFollowers(user1.getFollowers()+1);
		session.saveOrUpdate(user1);
		//�޸�followerid�е�star��Ŀ
		User user2 = session.get(User.class, following.getStar());
		user2.setFollowers(user2.getFollowers()+1);
		session.saveOrUpdate(user2);
		
		transaction.commit();
		session.close();
		return num > 0 ? true : false;
	}

	/**
	 * 根据id得到
	 * 
	 * @param starId
	 * @return
	 */
	public List<Following> getFollowersById(String starId) {
		Session session = sessionFactory.openSession();
		String hql = "from Following where star = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", starId);
		List<Following> followings = query.list();
		session.close();
		if (null != followings && 0 != followings.size()) {
			return followings;
		} else {
			return null;
		}
	}

	/**
	 * 根据id获取关注列表
	 * 
	 * @param starId
	 * @return
	 */
	public List<Following> getStarsById(String followerId) {
		Session session = sessionFactory.openSession();
		String hql = "from Following where follower = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", followerId);
		List<Following> followings = query.list();
		session.close();
		if (null != followings && 0 != followings.size()) {
			return followings;
		} else {
			return null;
		}
	}
	/**
	 * 解除一条关注
	 * @param following
	 * @return
	 */
	public boolean dismissFollowing(Following following) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Following where starId =:star and follower =:follower";
		Query query = session.createQuery(hql);
		query.setParameter("star", following.getStar());
		query.setParameter("follower", following.getFollower());
		Following following2 = (Following)query.uniqueResult();
		session.delete(following2);
		//�޸�startid�еķ�˿��Ŀ
		User user1 = session.get(User.class, following.getStar());
		user1.setFollowers(user1.getFollowers()-1);
		session.saveOrUpdate(user1);
		//�޸�followerid�е�star��Ŀ
		User user2 = session.get(User.class, following.getStar());
		user2.setFollowers(user2.getFollowers()-1);
		session.saveOrUpdate(user2);
		Following following3 = (Following)query.uniqueResult();
		transaction.commit();
		session.close();
		return null==following3 ? true : false;
	}

}
