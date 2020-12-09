package com.example.demoallexercise1130.entity;

import android.graphics.Bitmap;

public class SongModel {
    private String name;
    private String author;
    private String accompaniment;
    private String style;
    private Bitmap img;
    private double money;
    private String url;

    public SongModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAccompaniment() {
        return accompaniment;
    }

    public void setAccompaniment(String accompaniment) {
        this.accompaniment = accompaniment;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getUrl() {
        return url;
    }
}
