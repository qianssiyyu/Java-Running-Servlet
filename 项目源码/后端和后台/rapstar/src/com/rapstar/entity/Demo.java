package com.rapstar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Demo {
	private Integer id;
	private String name;
	private int authorid;
	private int accid;
	private String lyricpath;
	private String time;
	private String path;
	private int priority;
	private int statu;

	public Demo() {
		super();
	}

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

	public int getAccid() {
		return accid;
	}

	public void setAccid(int accid) {
		this.accid = accid;
	}

	public String getLyricpath() {
		return lyricpath;
	}

	public void setLyricpath(String lyricpath) {
		this.lyricpath = lyricpath;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + ", authorid=" + authorid + ", accid=" + accid + ", lyricpath="
				+ lyricpath + ", time=" + time + ", path=" + path + ", priority=" + priority + ", statu=" + statu + "]";
	}

}
