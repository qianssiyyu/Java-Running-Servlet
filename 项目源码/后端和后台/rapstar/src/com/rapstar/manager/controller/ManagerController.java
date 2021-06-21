package com.rapstar.manager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.rapstar.entity.Manager;
import com.rapstar.entity.User;
import com.rapstar.manager.service.ManagerService;
import com.rapstar.util.Page;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Resource
	private ManagerService managerService;

	
	
	
	
	@RequestMapping("/getall")
	@ResponseBody
	public String getAllManagers(@RequestParam("page") int pageNum,@RequestParam("limit") int pageSize) {
		String json = null;
		Page<Manager> page = managerService.listByPage(pageNum, pageSize);
		
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
	 * 登录
	 * 
	 * @param phone
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("phone") String phone, @RequestParam("password") String password,
			HttpServletRequest request) {
//		if (null == phone) {
//
//		}
//		if (managerService.login(phone, password)) {
//			// 登录成功
//			System.out.println("登录成功");
//			return "managerIndex";
//		} else {
//			// 登录失败
//			System.out.println("登录失败");
//			request.setAttribute("errorInfo", "管理员登录失败！");
//			return "index";
//		}

		// 判断信息是否为空
		if (phone != null && !phone.equals("")) {
			if (password != null && !password.equals("")) {

				// 检查用户是否存在
				if (managerService.isExist(phone)) {
					if (managerService.login(phone, password)) {
						System.out.println("管理员存在！");
						request.getSession().setAttribute("phone", phone);
						return "managerIndex";
					} else {
						System.out.println("密码错误！");
						request.setAttribute("errorInfo", "密码错误！");
						request.setAttribute("phone", phone);
						request.setAttribute("password", password);
						return "index";
					}
				} else {
					System.out.println("用户名不存在！");
					request.setAttribute("phone", phone);
					request.setAttribute("password", password);
					request.setAttribute("errorInfo", "该管理员不存在！");
					return "index";
				}
			} else {
				request.setAttribute("errorInfo", "密码不能为空！");
				request.setAttribute("phone", phone);
				return "index";
			}
		} else {
			request.setAttribute("errorInfo", "手机号不能为空！");
			return "index";
		}
	}
	
	

	/**
	 * TODO:退出登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logOut() {
		System.out.println("退出登录");
		return "index";
	}
}
