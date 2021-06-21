package com.rapstar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Musician {
	private Integer id;// 歌手id
	private String name;
	private String shortProfile;
	private String longProfile;
	private String sex;
	private Integer userId;
	private String photoPath;// id.jpg

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

	@Column(name = "shortpro")
	public String getShortProfile() {
		return shortProfile;
	}

	public void setShortProfile(String shortProfile) {
		this.shortProfile = shortProfile;
	}

	@Column(name = "longpro")
	public String getLongProfile() {
		return longProfile;
	}

	public void setLongProfile(String longProfile) {
		this.longProfile = longProfile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "userid")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "photopath")
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@Override
	public String toString() {
		return "Musician [id=" + id + ", name=" + name + ", shortProfile=" + shortProfile + ", longProfile="
				+ longProfile + ", sex=" + sex + ", userId=" + userId + ", photoPath=" + photoPath + "]";
	}

}
