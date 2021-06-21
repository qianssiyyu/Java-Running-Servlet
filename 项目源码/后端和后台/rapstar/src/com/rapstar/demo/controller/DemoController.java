package com.rapstar.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rapstar.demo.service.DemoService;
import com.rapstar.entity.Demo;
import com.rapstar.entity.User;
import com.rapstar.util.Page;

@Controller
@RequestMapping("/demo")
public class DemoController {
	@Resource
	private DemoService demoService;
	
	
	
	@RequestMapping("/getall")
	@ResponseBody
	public String getAllUsers(@RequestParam("page") int pageNum,@RequestParam("limit") int pageSize) {
		String json = null;
		Page<Demo> page = demoService.listByPage(pageNum, pageSize);
		
		Gson gson = new Gson();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "发送啦");
		result.put("count", page.getTotalCount());
		result.put("data", page.getList());
		json = gson.toJson(result);
		return json;
	}
	/**
	 * ��ȡ����demo
	 * 
	 * @return
	 */
	@RequestMapping("/getAllDemos")
	public List<Demo> getAllDemos() {
		return demoService.getAllDemos();
	}



	/**
	 * ����id��name��ѯdemo��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	@RequestMapping("/getDemoByIdOrName")
	public Demo getDemoByIdOrName(String id, String name) {
		return demoService.getDemoByIdOrName(id, name);
	}

	/**
	 * ����id��nameɾ��demo��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
	@RequestMapping("/deleteDemoByIdOrName")
	public boolean deleteDemoByIdOrName(String id, String name) {
		return demoService.deleteDemoByIdOrName(id, name);
	}

	/**
	 * ���demo
	 * 
	 * @param demo
	 * @return
	 */
	@RequestMapping("/addDemo")
	public boolean addDemo(@RequestParam("demoStr") String demoStr) {
		Demo demo = new Gson().fromJson(demoStr, Demo.class);
		return demoService.addDemo(demo);
	}

}
