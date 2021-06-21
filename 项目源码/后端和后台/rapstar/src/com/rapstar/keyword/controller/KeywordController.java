package com.rapstar.keyword.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rapstar.entity.KeyWord;
import com.rapstar.entity.Manager;
import com.rapstar.keyword.service.KeywordService;
import com.rapstar.manager.service.ManagerService;
import com.rapstar.util.Page;

@Controller
@RequestMapping("/keyword")
public class KeywordController {
	@Resource
	private KeywordService keywordService;

	
	
	
	@RequestMapping("/getall")
	@ResponseBody
	public String getAllManagers() {
		String json = null;
		
		
		List<KeyWord> list = keywordService.listByPage();
		Gson gson = new Gson();
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "发送啦");
		
		result.put("count", 10);
		result.put("data", list);
		json = gson.toJson(result);
		return json;
	}
	

}
