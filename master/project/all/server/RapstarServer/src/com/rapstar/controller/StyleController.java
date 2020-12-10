package com.rapstar.controller;

import java.util.List;


import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.rapstar.model.Accompaniment;
import com.rapstar.model.Song;
import com.rapstar.model.Style;
import com.rapstar.service.StyleService;

public class StyleController extends Controller {
//	Gson gson = new Gson();
	
	/**
	 * �޸�����
	 */
	public void resetStyle() {
		String oldName = getPara("old");
		String newName = getPara("new");
		
		renderText(StyleService.resetStyle(newName, oldName)+"");
	}
	
	
	/**
	 * �õ�ĳһ���͵ĸ���
	 */
	public void getSongsByStyle() {
		String s = HttpKit.readData(getRequest());
		Style style = JsonKit.parse(s, Style.class);
		List<Song> songs = StyleService.getSongsByStyle(style);
		if (songs==null||songs.size()==0) {
			renderText("null");
		}
		//������صĲ���null����ʾ�д������
//		String json = gson.toJson(songs);
//		renderText(json);
	}
	
	/**
	 * �õ�ĳһ���͵İ���
	 */
	public void getAccsByStyle() {
		String s = HttpKit.readData(getRequest());
		Style style = JsonKit.parse(s, Style.class);
		List<Accompaniment> accs = StyleService.getAccsByStyle(style);
		if (accs==null||accs.size()==0) {
			renderText("null");
		}
		//������صĲ���null����ʾ�д������
//		String json = gson.toJson(accs);
//		renderText(json);
	}
	
	/**
	 * ��ȡ��������
	 */
	public void getAllStyles() {
		List<Style> styles = StyleService.getAllStyles();
		if (styles==null||styles.size()==0) {
			renderText(null);
		} else {
//			String jsonString = gson.toJson(styles);
//			renderText(jsonString);
		}
	}
}
