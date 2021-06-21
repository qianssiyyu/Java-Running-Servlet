package com.rapstar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	private Integer id;
	private String phone;// �û��ֻ���
	private String nickName;// �û��ǳ�
	private String password;// �û�����
	private String photoPath;// �û�ͷ��
	private String sex;// �û��Ա�
	private String intro;// �û�����
	private int stars;// �û���ע���˵ĸ���
	private int followers;// ��ע�û�������
	private String isVip;// �����Ƿ���vip
	private String certification;// ������ݣ�0Ϊ��ͨ�û� 1��ʾ��������֤��������Ʒ�ģ�

	public User() {
		super();
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "nick_name")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Column(name = "pwd")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "photo_path")
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getStars() {
		return stars;
	}

	
	public void setStars(int stars) {
		this.stars = stars;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}
	@Column(name = "isvip")
	public String getIsVip() {
		return isVip;
	}

	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", nickName=" + nickName + ", password=" + password
				+ ", photoPath=" + photoPath + ", sex=" + sex + ", intro=" + intro + ", stars=" + stars + ", followers="
				+ followers + ", isVip=" + isVip + ", certification=" + certification + "]";
	}


	
	
	

}
