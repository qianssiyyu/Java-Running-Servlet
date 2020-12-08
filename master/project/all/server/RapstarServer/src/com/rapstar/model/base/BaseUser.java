package com.rapstar.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	public M setPhone(java.lang.String phone) {
		set("phone", phone);
		return (M)this;
	}
	
	public java.lang.String getPhone() {
		return getStr("phone");
	}

	public M setName(java.lang.String name) {
		set("name", name);
		return (M)this;
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public M setPwd(java.lang.String pwd) {
		set("pwd", pwd);
		return (M)this;
	}
	
	public java.lang.String getPwd() {
		return getStr("pwd");
	}

	public M setPhotopath(java.lang.String photopath) {
		set("photopath", photopath);
		return (M)this;
	}
	
	public java.lang.String getPhotopath() {
		return getStr("photopath");
	}

	public M setSex(java.lang.String sex) {
		set("sex", sex);
		return (M)this;
	}
	
	public java.lang.String getSex() {
		return getStr("sex");
	}

	public M setIntro(java.lang.String intro) {
		set("intro", intro);
		return (M)this;
	}
	
	public java.lang.String getIntro() {
		return getStr("intro");
	}

	public M setStars(java.lang.Integer stars) {
		set("stars", stars);
		return (M)this;
	}
	
	public java.lang.Integer getStars() {
		return getInt("stars");
	}

	public M setFollowers(java.lang.Integer followers) {
		set("followers", followers);
		return (M)this;
	}
	
	public java.lang.Integer getFollowers() {
		return getInt("followers");
	}

	public M setIsvip(java.lang.String isvip) {
		set("isvip", isvip);
		return (M)this;
	}
	
	public java.lang.String getIsvip() {
		return getStr("isvip");
	}

	public M setCertification(java.lang.String certification) {
		set("certification", certification);
		return (M)this;
	}
	
	public java.lang.String getCertification() {
		return getStr("certification");
	}

}