package com.rapstar.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

public class IndexController extends Controller{
	
	public void index() {
		renderJsp("index.jsp");
	}

}
