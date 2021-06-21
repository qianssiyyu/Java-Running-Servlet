package com.rapstar.songlist.controller;

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
import com.rapstar.entity.Song;
import com.rapstar.entity.SongList;
import com.rapstar.entity.User;
import com.rapstar.song.service.SongService;
import com.rapstar.songlist.service.SongListService;
import com.rapstar.util.Page;

@Controller
@RequestMapping("/songlist")
public class SongListController1 {

	@Resource
	private SongListService songlistService;
	
	
	
	@RequestMapping("/getall")
	@ResponseBody
	public String getAllUsers(@RequestParam("page") int pageNum,@RequestParam("limit") int pageSize) {
		String json = null;
		Page<SongList> page = songlistService.listByPage(pageNum, pageSize);
		
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
	 * 得到全部歌单
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String, Object> getAllSongs(String name, HttpSession httpSession) {
		String result = "fail";
		System.out.println(name);
	
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (name != null) {
			 result="success";
			 List<SongList> list = songlistService.getAllSongs();
			 results.put("songlists",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;

	}
	/*
	 * 
	 * 根据用户id和所要的收藏/本地等来查询歌曲列表
	 */
	@RequestMapping("/getSonglistsByUserAndWant")
	@ResponseBody
	public Map<String, Object>  getSonglistsByUserAndWant(Integer id,String want){
		String result = "fail";
	
	
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (id != null && want!=null) {
			 result="success";
			 List<SongList> list = songlistService.getSonglistsByUserAndWant(id,want);
			 results.put("songlists",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;
	}

}
