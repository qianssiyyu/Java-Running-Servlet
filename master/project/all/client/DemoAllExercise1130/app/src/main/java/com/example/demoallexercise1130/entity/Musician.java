package com.example.demoallexercise1130.entity;

public class Musician {
    private int id;//歌手id
    private String name;
    private String shortpro;
    private String longpro;
    private String  sex;
    private int userId;
    private String photoId;

    public Musician(int id, String name, String shortpro, String longpro, String sex, int userId, String photoId) {
        this.id = id;
        this.name = name;
        this.shortpro = shortpro;
        this.longpro = longpro;
        this.sex = sex;
        this.userId = userId;
        this.photoId = photoId;
    }

    public Musician() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortpro() {
        return shortpro;
    }

    public void setShortpro(String shortpro) {
        this.shortpro = shortpro;
    }

    public String getLongpro() {
        return longpro;
    }

    public void setLongpro(String longpro) {
        this.longpro = longpro;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }
}
