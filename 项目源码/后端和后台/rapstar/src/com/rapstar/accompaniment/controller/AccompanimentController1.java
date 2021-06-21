package com.rapstar.accompaniment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rapstar.accompaniment.service.AccompanimentService;
import com.rapstar.entity.Accompaniment;
import com.rapstar.entity.Song;

@Controller
@RequestMapping("/accompaniment1")
public class AccompanimentController1 {
	@Resource
	private AccompanimentService accompanimentService;
	/* 
	 * 得到全部伴奏
	 */
	@RequestMapping("/getAllAccompaniments")
	@ResponseBody
	public Map<String, Object> getAllSongs(String name, HttpSession httpSession) {
		String result = "fail";
		System.out.println(name);
	
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (name != null) {
			 result="success";
			 List<Accompaniment> list = accompanimentService.getAllAccompaniments();
			 results.put("accompaniments",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;

	}




}
