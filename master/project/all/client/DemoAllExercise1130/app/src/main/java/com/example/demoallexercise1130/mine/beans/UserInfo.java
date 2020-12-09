package com.example.demoallexercise1130.mine.beans;

import java.util.List;

public class UserInfo {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "users=" + users +
                '}';
    }
}
