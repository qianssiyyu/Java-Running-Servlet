package com.rapstar.song.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.rapstar.entity.Song;
import com.rapstar.song.service.SongService;

@Controller
@RequestMapping("/song1")
public class SongController1 {

	@Resource
	private SongService songService;
	/* 
	 * 得到全部歌曲
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public Map<String, Object> getAllSongs(String name, HttpSession httpSession) {
		String result = "fail";
		System.out.println(name);
	
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (name != null) {
			 result="success";
			 List<Song> list = songService.getAllSongs();
			 results.put("songs",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;

	}
	/*
	 * 
	 *得到热门歌曲
	 */
	@RequestMapping("/getHotSongs")
	@ResponseBody
	public Map<String, Object> getHotSongs(String name, HttpSession httpSession){
		String result = "fail";
		System.out.println(name);
	
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (name != null) {
			 result="success";
			 List<Song> list = songService.getHotSongs();
			 results.put("songs",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;
	}
	/*
	 * 
	 *得到随机生成歌曲
	 */
	@RequestMapping("/getRandomSongs")
	@ResponseBody
	public Map<String, Object> getRandomSongs(String name, HttpSession httpSession){
		String result = "fail";
		System.out.println(name);
	
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (name != null) {
			 result="success";
			 List<Song> list = songService.getRandomSongs();
			 results.put("songs",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;
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
	
	/*
	 * 
	 * 根据用户id和所要的收藏/本地等来查询歌曲列表
	 */
	@RequestMapping("/getSongsByUserAndWant")
	@ResponseBody
	public  Map<String, Object> getSongsByUserAndWant(Integer id,String want,HttpSession httpSession){
		String result = "fail";
	
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (id != null&&want!=null) {
			 result="success";
			 List<Song> list = songService.getSongsByUserAndWant(id, want);
			 results.put("songs",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;
	}
}
