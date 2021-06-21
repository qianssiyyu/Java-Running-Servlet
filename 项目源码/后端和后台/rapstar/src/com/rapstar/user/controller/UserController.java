package com.rapstar.user.controller;

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
import com.rapstar.entity.User;
import com.rapstar.user.service.UserService;
import com.rapstar.util.Page;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	/**
	 * �����ֻ��Ų�ѯid
	 * @param phone
	 * @return
	 */
//	@RequestMapping("/getIdByPhone")
	public int getIdByPhone(String phone) {
		return userService.getIdByPhone(phone);
	}
	
	/**
	 * ���ڵ�¼�ж�
	 * @param phone
	 * @param password
	 * @return
	 */
//	@RequestMapping("/login")
	public boolean login(String phone,String password) {
		return userService.login(phone, password);
	}

	/**
	 * ����id���ֻ������ѯ�û���Ϣ
	 * @param arg
	 * @return
	 */
//	@RequestMapping("/getUserByIdOrPhone")
	public User getUserByIdOrPhone(String id,String phone) {
		return userService.getUserByIdOrPhone(id, phone);
	}
	
	/**
	 * ��ȡ�����û���Ϣ
	 * @return
	 */
//	@RequestMapping("/getAllUsers")
	@RequestMapping("/getall")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	/**
	 * ��ȡ�����û���Ϣ
	 * @return
	 */
	@RequestMapping("/getAllUsers")
	@ResponseBody
	public String getAllUsers(@RequestParam("page") int pageNum,@RequestParam("limit") int pageSize) {
		String json = null;
		Page<User> page = userService.listByPage(pageNum, pageSize);
		
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
	 * ����id���ֻ�����ɾ���û�
	 * @param arg
	 * @return
	 */
//	@RequestMapping("/deleteUserByIdOrPhone")
	public boolean deleteUserByIdOrPhone(String id,String phone) {
		
		return userService.deleteUserByIdOrPhone(id, phone);
	}

	/**
	 * 根据ID删除用户
	 * @param arg
	 * @return
	 */
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	@ResponseBody
	public String deleteUserByIdOrPhone(@RequestParam("uid") int id) {		
		System.out.println("进去了哈哈哈哈");
		int count = userService.removeUser(id);
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
	
	
	@RequestMapping(value = "/edit", method=RequestMethod.POST)
	@ResponseBody
	public String edit(User u) {
		System.out.println(u);
		int i = userService.editUser(u);
		Gson gson = new Gson();
		Map<String, Object> result = new HashMap<String, Object>();
		if(i == 1) {			
			result.put("state", 1);
		}else {
			result.put("state", 0);
		}
		String json = gson.toJson(result);
		
		return json;
	
	}
	
	
	@RequestMapping(value = "/edit", method=RequestMethod.GET)
	public String edit(HttpServletRequest request) {
		request.setAttribute("type", "user");
		return "editForm";
	
	}
}
