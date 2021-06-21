package com.rapstar.musician.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rapstar.entity.Musician;
import com.rapstar.entity.User;
import com.rapstar.musician.service.MusicianService;
import com.rapstar.util.Page;

@Controller
@RequestMapping("/musician")
public class MusicianController {
	@Resource
	private MusicianService musicianService;

	/**
	 * 获取所有的Musician
	 * 
	 * @return
	 */
//	@RequestMapping(value = "/getAllMusicians", method = RequestMethod.POST)
//	public List<Musician> getAllMusicians() {
//		return musicianService.getAllMusicians();
//	}

//	@RequestMapping(value = "/getAllMusicians", method = RequestMethod.POST)
	@RequestMapping(value = "/getAllMusicians")
	@ResponseBody
	public String getAllMusicians(@RequestParam("page") int pageNum, @RequestParam("limit") int pageSize) {
		String json = null;
		Page<Musician> page = musicianService.listByPage(pageNum, pageSize);

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
	 * 根据id获取Musician
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getMusicianById", method = RequestMethod.POST)
	public Musician getMusicianById(@RequestParam("id") int id) {
		return musicianService.getMusicianById(id);
	}

	/**
	 * 更新musician信息
	 * 
	 * @param musician
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public boolean updateMusician(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("shortpro") String shortPro, @RequestParam("longpro") String longPro,
			@RequestParam("sex") String sex, @RequestParam("userid") int userId,
			@RequestParam("photopath") String photoPath) {
		Musician musician = new Musician();
		musician.setId(id);
		musician.setLongProfile(longPro);
		musician.setName(name);
		musician.setPhotoPath(photoPath);
		musician.setSex(sex);
		musician.setShortProfile(shortPro);
		musician.setUserId(userId);
		System.out.println("要添加的信息 ：musician：" + musician);
		return musicianService.updateMusician(musician);
	}
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String updateMusician(HttpServletRequest request) {		
		request.setAttribute("type", "musician");		
		return "editForm";
	}

	/**
	 * 根据id删除musician
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delMusicianById", method = RequestMethod.POST)
	public boolean delMusicianById(@RequestParam("id") int id) {
		return musicianService.delMusicianById(id);
	}

}
