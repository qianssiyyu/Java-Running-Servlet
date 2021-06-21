package com.rapstar.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rapstar.entity.Musician;
import com.rapstar.entity.User;
import com.rapstar.user.service.UserService;

@Controller
@RequestMapping("/user1")
public class UserController1 {
	@Resource
	private UserService userService;
	/**
	 * 根据用户输入的手机号获取用户信息
	 * @param phone
	 * @return
	 */
	@RequestMapping("/getUserByPhone")
	@ResponseBody
	public Map<String,Object> getUserByPhone(String phone,HttpSession httpSession) {
		System.out.println(phone);
		Map<String, Object> results = new HashMap<String, Object>();
		if(phone!=null) {
			User user=userService.getUserByPhone(phone);
			results.put("user",user);
			System.out.println(user);
		}
		return results;
	}
	
	/*
	 * 得到热门歌手
	 */
	@RequestMapping("/getHotMusicians")
	@ResponseBody
	public  Map<String,Object> getHotMusicians(String name,HttpSession httpSession) {
		Map<String, Object> results = new HashMap<String, Object>();
		if(name!=null) {
			List<Musician> musicians=userService.getHotMusicians();
			results.put("musicians",musicians);
			System.out.println(musicians);
		}
		return results;
	}
	/*
	 * 得到全部音乐人
	 */
	@RequestMapping("/getAllMusicians")
	@ResponseBody
	public  Map<String,Object> getAllMusicians(String name,HttpSession httpSession) {
		Map<String, Object> results = new HashMap<String, Object>();
		if(name!=null) {
			List<Musician> musicians=userService.getAllMusicians();
			results.put("musicians",musicians);
			System.out.println(musicians);
		}
		return results;
	}
	/**
	 * 根据音乐人id得到音乐人
	 * @param arg
	 * @return
	 */
	@RequestMapping("/getMusicianById")
	@ResponseBody
	public  Map<String,Object>  getMusicianById(String id,HttpSession httpSession) {
		Map<String, Object> results = new HashMap<String, Object>();
		if(id!=null) {
			Musician musician =userService.getMusicianById(new Integer(id));
			results.put("musician",musician);
			System.out.println(musician);
		}
		return results;
	}
	
	
}