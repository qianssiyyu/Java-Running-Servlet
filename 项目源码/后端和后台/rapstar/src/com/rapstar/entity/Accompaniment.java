package com.rapstar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Accompaniment {
	private Integer id;
	private String name;
	private int authorid;
	private String auname;
	private String intro;
	private String time;
	private String imgpath;
	private int style;
	private String stname;
	private double money;
	private String path;
	private int state;



	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	

	public String getAuname() {
		return auname;
	}

	public void setAuname(String auname) {
		this.auname = auname;
	}

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	@Override
	public String toString() {
		return "Accompaniment [id=" + id + ", name=" + name + ", authorid=" + authorid + ", intro=" + intro + ", time="
				+ time + ", imgpath=" + imgpath + ", style=" + style + ", money=" + money + ", path=" + path
				+ ", state=" + state + "]";
	}

	

	
}
