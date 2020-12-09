package com.example.demoallexercise1130.mine.beans;

public class User {
    private String name;//用户名
    private String songlist;//歌单名
    private String path;//歌单封面路径

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSonglist() {
        return songlist;
    }
    public void setSonglist(String songlist) {
        this.songlist = songlist;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", songlist='" + songlist + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
