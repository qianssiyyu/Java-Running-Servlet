package com.rapstar.user.controller;


import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.User;
import com.rapstar.service.UserService;


public class UserController extends Controller{
	
    public void login(){
		//获取前端传来的json串
    	//获取数据，通过流的方式   	
		String s = HttpKit.readData(getRequest());
		User user = JsonKit.parse(s, User.class);
		boolean flag = UserService.isExitUser(user);
		String returnStr = String.valueOf(flag);
		renderText(returnStr);
    	
	}
    
    public void register() {
    	String s = HttpKit.readData(getRequest());
		User user = JsonKit.parse(s, User.class);
		boolean flag = UserService.addUser(user);
		String returnStr = String.valueOf(flag);
		renderText(returnStr);
    }

}
