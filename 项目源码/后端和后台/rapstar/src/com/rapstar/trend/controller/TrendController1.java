package com.rapstar.trend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rapstar.trend.service.TrendService;
import com.rapstar.demo.service.DemoService;
import com.rapstar.entity.Demo;
import com.rapstar.entity.Song;
import com.rapstar.entity.Trend;

@Controller
@RequestMapping("/trend1")
public class TrendController1 {
	@Resource
	private TrendService trendService;

	/**
	 * 得到全部动态，倒叙显示
	 * 
	 * @return
	 */
	@RequestMapping("/getAllTrends")
	@ResponseBody
	public Map<String, Object> getAllTrends(String name, HttpSession httpSession) {
		String result = "fail";

		Map<String, Object> results = new HashMap<String, Object>();

		if ("ss" != null) {
			result = "success";
			List<Trend> list = trendService.getAllTrends();
			System.out.println(list.get(0).toString());
			results.put("trends", list);
		}
		results.put("result", result);

		System.out.println(results);
		return results;
	}

	/**
	 * 根据用户昵称得到该用户发表的动态
	 * 
	 * @return
	 */
	@RequestMapping("/getTrendsByUserName")
	@ResponseBody
	public Map<String, Object> getTrendsByUserName(String name, HttpSession httpSession) {
		String result = "fail";

		Map<String, Object> results = new HashMap<String, Object>();

		if (name != null) {
			result = "success";
			List<Trend> list = trendService.getTrendsByUserName(name);
			results.put("trends", list);
		}
		results.put("result", result);

		System.out.println(results);
		return results;
	}

	/**
	 * 用户上传动态
	 * 
	 * @return
	 */
	@RequestMapping("/uploadTrend")
	@ResponseBody
	public Map<String, Object> uploadTrend(String trend, HttpSession httpSession) {
		String result = "fail";

		Map<String, Object> results = new HashMap<String, Object>();

		if (trend != null) {
			result = "success";
			JSONObject json = new JSONObject(trend);
			Trend t = new Trend();

			t.setAuthor((String) json.get("author"));
			t.setCommentnum((Integer) json.get("commentnum"));
			t.setContent((String) json.get("content"));
			t.setDianzannum((Integer) json.get("dianzannum"));
			t.setId((Integer) json.get("id"));
			t.setUserimage((String) json.get("userimage"));
			t.setNickname((String) json.get("nickname"));
			t.setTime((String) json.get("time"));
			t.setContent((String) json.get("content"));
			t.setImg((Integer) json.get("img"));
			t.setImgs((String) json.get("imgs"));
			t.setSharemusic((Integer) json.get("sharemusic"));
			t.setMusicimage((String) json.get("musicimage"));
			t.setSongname((String) json.get("songname"));
			trendService.upLoadTrends(t);
			// System.out.println( "获得对象的id："+json.get("id"));

		}
		results.put("result", result);

		System.out.println(results);
		return results;
	}

	/**
	 * 根据id得动态
	 * 
	 * @return
	 */

	@RequestMapping("/getTrendById")
	@ResponseBody
	public Map<String, Object> getTrendsById(String id, HttpSession httpSession) {
		String result = "fail";

		Map<String, Object> results = new HashMap<String, Object>();

		if (id != null) {
			result = "success";
			Trend t = trendService.getTrendsById(new Integer(id));
			results.put("trend", t);
		}
		results.put("result", result);

		System.out.println(results);
		return results;
	}
}
