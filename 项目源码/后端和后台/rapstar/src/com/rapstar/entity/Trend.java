package com.rapstar.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trend {
	private Integer id;
	private String userimage;//发帖用户头像
	private String nickname;//发帖用户昵称
	private String time;//发帖时间
	private String content;//发帖文字内容
	private Integer dianzannum;//点赞数
	private Integer commentnum;//评论数
	private Integer img;//携带一张为1，携带2张为2，3张为3，不携带为0，必须有值否则异常
	private String imgs;//图片以String类型返回，格式xxx.jpg;yyy.jpg;zzz.jpg
	private Integer sharemusic;//值为1或0，0为未使用音乐分享条，1为使用了音乐分享条
    //shareMusic值为1，还要传
	private String musicimage;//音乐条的歌曲封面
	private String songname;//歌名
	private String author;//歌曲作者
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserimage() {
		return userimage;
	}
	public void setUserimage(String userimage) {
		this.userimage = userimage;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getDianzannum() {
		return dianzannum;
	}
	public void setDianzannum(Integer dianzannum) {
		this.dianzannum = dianzannum;
	}
	public Integer getCommentnum() {
		return commentnum;
	}
	public void setCommentnum(Integer commentnum) {
		this.commentnum = commentnum;
	}
	public Integer getImg() {
		return img;
	}
	public void setImg(Integer img) {
		this.img = img;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public Integer getSharemusic() {
		return sharemusic;
	}
	public void setSharemusic(Integer sharemusic) {
		this.sharemusic = sharemusic;
	}
	public String getMusicimage() {
		return musicimage;
	}
	public void setMusicimage(String musicimage) {
		this.musicimage = musicimage;
	}
	public String getSongname() {
		return songname;
	}
	public void setSongname(String songname) {
		this.songname = songname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Trend [id=" + id + ", userimage=" + userimage + ", nickname=" + nickname + ", time=" + time
				+ ", content=" + content + ", dianzannum=" + dianzannum + ", commentnum=" + commentnum + ", img=" + img
				+ ", imgs=" + imgs + ", sharemusic=" + sharemusic + ", musicimage=" + musicimage + ", songname="
				+ songname + ", author=" + author + "]";
	}

}
