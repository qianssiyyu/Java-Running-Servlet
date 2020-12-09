package com.example.demoallexercise1130.mine.beans;

import java.util.List;

public class UserBanzouInfo {
	private List<BanzouUser> users;

	public List<BanzouUser> getUsers() {
		return users;
	}

	public void setUsers(List<BanzouUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserBanzouInfo [users=" + users + "]";
	}

	
}

