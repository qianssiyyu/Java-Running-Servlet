package com.rapstar.following.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.rapstar.entity.Following;
import com.rapstar.entity.User;
import com.rapstar.following.dao.FollowingDao;

@Service
public class FollowingService {

	@Resource
	private FollowingDao followingDao;

	/**
	 * 获取所有followings
	 * 
	 * @return
	 */
	public List<Following> getAllFollowings() {
		return followingDao.getAllFollowings();
	}

	/**
	 * 加入一条记录
	 * 
	 * @param following
	 * @return
	 */
	public boolean addFollowing(Following following) {
		return followingDao.addFollowing(following);
	}

	/**
	 * 查找我的folowers
	 * 
	 * @param starId
	 * @return
	 */
	public List<Following> getFollowersById(String starId) {
		return followingDao.getFollowersById(starId);
	}

	/**
	 * 查找我的stars
	 * 
	 * @param starId
	 * @return
	 */
	public List<Following> getStarsById(String followerId) {
		return followingDao.getStarsById(followerId);
	}

	/**
	 * 取消关注
	 * 
	 * @param following
	 * @return
	 */
	public boolean dismissFollowing(Following following) {

		return followingDao.dismissFollowing(following);
	}

}
