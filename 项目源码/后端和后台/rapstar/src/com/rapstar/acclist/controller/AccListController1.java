package com.rapstar.acclist.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rapstar.acclist.service.AccListService;
import com.rapstar.entity.Acclist;
import com.rapstar.entity.Song;
import com.rapstar.entity.SongList;
import com.rapstar.song.service.SongService;
import com.rapstar.songlist.service.SongListService;
import com.rapstar.util.Page;

@Controller
@RequestMapping("/acclist")
public class AccListController1 {

	@Resource
	private AccListService acclistService;
	
	
	@RequestMapping("/getall")
	@ResponseBody
	public String getAllUsers(@RequestParam("page") int pageNum,@RequestParam("limit") int pageSize) {
		String json = null;
		Page<Acclist> page = acclistService.listByPage(pageNum, pageSize);
		
		Gson gson = new Gson();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "发送啦");
		result.put("count", page.getTotalCount());
		result.put("data", page.getList());
		json = gson.toJson(result);
		return json;
	}
	/*
	 * 
	 * 得到全部伴奏单
	 */
	@RequestMapping("/getAllAccLists")
	@ResponseBody
	public Map<String, Object> getAllAccLists(String name, HttpSession httpSession) {
		String result = "fail";
		System.out.println(name);
	
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (name != null) {
			 result="success";
			 List<Acclist> list = acclistService.getAllAccLists();
			 results.put("acclists",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;

	}
	

}
