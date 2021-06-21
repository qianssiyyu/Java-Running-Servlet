package com.rapstar.trend.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.rapstar.trend.dao.TrendDao;
import com.rapstar.demo.dao.DemoDao;
import com.rapstar.entity.Demo;
import com.rapstar.entity.Trend;

@Service
public class TrendService {
	@Resource
	private TrendDao trendDao;
	/**
	 * 得到全部动态内容，点赞数由高到低
	 * 
	 * @return
	 */
	public List<Trend> getAllTrends() {
		return trendDao.getAllTrends();
	}
	/**
	 * 根据用户id得到发表过的动态
	 * 
	 * @return
	 */
	public List<Trend> getTrendsByUserName(String name) {
		return trendDao.getTrendsByUserName(name);
	}
	/*
	 * 添加动态
	 */
	public void upLoadTrends(Trend trend) {
		trendDao.upLoadTrends(trend);
	}

	/**
	 * 根据id得动态
	 * 
	 * @return
	 */
	public Trend getTrendsById(Integer id) {
		return trendDao.getTrendsById(id);
	}
}
