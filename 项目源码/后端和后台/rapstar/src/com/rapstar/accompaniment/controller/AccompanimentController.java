package com.rapstar.accompaniment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rapstar.accompaniment.service.AccompanimentService;
import com.rapstar.entity.Accompaniment;
import com.rapstar.entity.User;
import com.rapstar.util.Page;

@Controller
@RequestMapping("/acc")
public class AccompanimentController {
	@Resource
	private AccompanimentService accompanimentService;
	/**
	 * ��ȡ����Accompaniment
	 * 
	 * @return
	 */
	@RequestMapping("/getAllAccompaniments")
	@ResponseBody
	public String getAllAccompaniments(@RequestParam("page") int pageNum,@RequestParam("limit") int pageSize) {
		String json = null;
		Page<Accompaniment> page = accompanimentService.listByPage(pageNum, pageSize);
		
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
	 * ����id��name��ѯAccompaniment��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
//	@RequestMapping("/getAccompanimentByIdOrName")
	public Accompaniment getAccompanimentByIdOrName(@RequestParam("id")String id, @RequestParam("name")String name) {
		return accompanimentService.getAccompanimentByIdOrName(id, name);
	}

	/**
	 * ����id��nameɾ��Accompaniment��Ϣ
	 * 
	 * @param arg
	 * @return
	 */
//	@RequestMapping("/deleteAccompanimentByIdOrName")
	public boolean deleteAccompanimentByIdOrName(@RequestParam("id")String id, @RequestParam("name")String name) {
		return accompanimentService.deleteAccompanimentByIdOrName(id, name);
	}

	/**
	 * ���Accompaniment
	 * 
	 * @param Accompaniment
	 * @return
	 */
//	@RequestMapping("/addAccompaniment")
	public boolean addAccompaniment(@RequestParam("accompaniment")String accStr) {
		Accompaniment accompaniment = new Gson().fromJson(accStr, Accompaniment.class);
		return accompanimentService.addAccompaniment(accompaniment);
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.POST)
	@ResponseBody
	public String edit(@RequestParam("id")int id,@RequestParam("flag")int flag) {
		
		int row = accompanimentService.editState(id,flag);
		Gson gson = new Gson();
		Map<String, Object> result = new HashMap<String, Object>();		
		if(row>0) {			
			result.put("s", 1);
		}else {
			result.put("s", 0);
		}
		String json = gson.toJson(result);
		return json;
	
	}

}
