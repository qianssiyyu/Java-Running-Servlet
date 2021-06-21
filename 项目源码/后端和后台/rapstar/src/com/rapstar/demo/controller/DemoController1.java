package com.rapstar.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rapstar.demo.service.DemoService;
import com.rapstar.entity.Demo;

@Controller
@RequestMapping("/demo1")
public class DemoController1 {
	@Resource
	private DemoService demoService;
	/**
	 * ��ȡ����demo
	 * 
	 * @return
	 */
	@RequestMapping("/getAllDemos")
	@ResponseBody
	public Map<String, Object> getAllDemos() {
		String result = "fail";
	
		Map<String, Object> results = new HashMap<String, Object>();
		
		if ("ss" != null) {
			 result="success";
			 List<Demo> list = demoService.getAllDemos();
			 results.put("demos",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;
	}
	/**
	 * 根据用户id得到demo
	 * 
	 * @return
	 */
	    @RequestMapping("/getDemosById")
		@ResponseBody
		public Map<String, Object> getDemosById(Integer id) {
		String result = "fail";
		
		Map<String, Object> results = new HashMap<String, Object>();
		
		if (id != null) {
			 result="success";
			 List<Demo> list = demoService.getDemosById(id);
			 results.put("demos",list);
		}
		results.put("result", result);
	
		System.out.println(results);
		return results;
	}
	    
	    /*
		 * 
		 * 根据用户id和所要的收藏/本地等来查询歌曲列表
		 */
	    @RequestMapping("/getDemosByUserAndWant")
		@ResponseBody
		public Map<String, Object> getDemosByUserAndWant(Integer id,String want){
	    	String result = "fail";
			
			Map<String, Object> results = new HashMap<String, Object>();
			
			if (id != null) {
				 result="success";
				 List<Demo> list = demoService.getDemosByUserAndWant(id, want);
				 results.put("demos",list);
			}
			results.put("result", result);
		
			System.out.println(results);
			return results;
		}



}
