package com.rapstar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
	private Integer id;
	private String name;
	private Integer authorid;
	private String lyricpath;
	private Integer acc;
	private Integer style;
	private String path;
	private double money;
	private String imgpath;
	private Integer songlistid;
	private Integer mycheck;
	private Integer mystate;
	public int getSonglistid() {
		return songlistid;
	}
	public void setSonglistid(int songlistid) {
		this.songlistid = songlistid;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
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
	public Integer getAuthorid() {
		return authorid;
	}
	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}
	public String getLyricpath() {
		return lyricpath;
	}
	public void setLyricpath(String lyricpath) {
		this.lyricpath = lyricpath;
	}
	public Integer getAcc() {
		return acc;
	}
	public void setAcc(Integer acc) {
		this.acc = acc;
	}
	public Integer getStyle() {
		return style;
	}
	public void setStyle(Integer style) {
		this.style = style;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public void setSonglistid(Integer songlistid) {
		this.songlistid = songlistid;
	}
	public Integer getMycheck() {
		return mycheck;
	}
	public void setMycheck(Integer mycheck) {
		this.mycheck = mycheck;
	}
	public Integer getMystate() {
		return mystate;
	}
	public void setMystate(Integer mystate) {
		this.mystate = mystate;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", authorid=" + authorid + ", lyricpath=" + lyricpath + ", acc="
				+ acc + ", style=" + style + ", path=" + path + ", money=" + money + ", imgpath=" + imgpath
				+ ", songlistid=" + songlistid + "]";
	}
	
	
	
	
	
}
