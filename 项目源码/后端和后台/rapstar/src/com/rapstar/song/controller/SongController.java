package com.rapstar.song.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rapstar.entity.Song;
import com.rapstar.entity.User;
import com.rapstar.song.service.SongService;
import com.rapstar.util.Page;

@Controller
@RequestMapping("/song")
public class SongController {

	@Resource
	private SongService songService;
	
	
	/*
	 * 
	 * 得到全部歌曲
	 */
	
	@RequestMapping("/getsomesong")
	@ResponseBody
	public String getSomeSongs(@RequestParam("page") int pageNum,@RequestParam("limit") int pageSize) {
		String json = null;
		Page<Song> page = songService.listBySomePage(pageNum, pageSize);
		
		Gson gson = new Gson();
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "发送啦");
		result.put("count", page.getTotalCount());
		result.put("data", page.getList());
		json = gson.toJson(result);
		System.out.println(json);
		return json;

	}
	/*
	 * 
	 * 得到全部歌曲
	 */
	
	@RequestMapping("/getallsong")
	@ResponseBody
	public String getAllSongs(@RequestParam("page") int pageNum,@RequestParam("limit") int pageSize) {
		String json = null;
		Page<Song> page = songService.listByPage(pageNum, pageSize);
		
		Gson gson = new Gson();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "发送啦");
		result.put("count", page.getTotalCount());
		result.put("data", page.getList());
		json = gson.toJson(result);
		System.out.println(json);
		return json;

	}

	/*
	 * 根据歌单id得到歌曲
	 */
	@RequestMapping("/getSongBySongListId")
	@ResponseBody
	public Map<String, Object> getSongsBySonglistid(String id, HttpSession httpSession) {
		
		String result = "fail";
		Map<String, Object> results = new HashMap<String, Object>();
		System.out.println("id��"+id);
		if (id != null) {
			result="success";
			 List<Song> list = songService.getAllSongs();
			 results.put("songs",list);
		}
		results.put("result", result);
	
		return results;
	}

	/*
	 * 根据歌曲名得到歌曲详情
	 * 
	 */
	@RequestMapping("/getDetailByName")
	@ResponseBody
	public Map<String, Object> getDetailByName(String name,HttpSession httpSession) {
		
		String result = "fail";
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (name != null) {
			 result="success";
			 Song song =songService.getDetailByName(name);
			 
			 results.put("song",song);
		}
		results.put("result", result);
	
		return results;
	}

	/*
	 * 
	 * 根据歌曲id得到详情
	 */
	@RequestMapping("/getDetailById")
	@ResponseBody
	public Map<String, Object> getDetailById(String id,HttpSession httpSession) {
		String result = "fail";
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (id != null) {
			 result="success";
			 Song song =songService.getDetailById(new Integer(id));
			 
			 results.put("song",song);
		}
		results.put("result", result);
	
		return results;
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.POST)
	@ResponseBody
	public String edit(@RequestParam("id") int id,@RequestParam("mystate") int mystate) {
		int count = songService.editSong(id,mystate);
		Gson gson = new Gson();
		Map<String, Object> result = new HashMap<String, Object>();
		if(count>0) {			
			result.put("state", 1);
		}else {
			result.put("state", 0);
		}
		String json = gson.toJson(result);
		return json;
	
	}
}
