package com.rapstar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Slistcollect {

	private Integer id;
	private Integer userid;
	private Integer songlistid;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getSonglistid() {
		return songlistid;
	}
	public void setSonglistid(Integer songlistid) {
		this.songlistid = songlistid;
	}
	
}
