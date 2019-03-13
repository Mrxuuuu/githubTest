package com.xuwem.show.service;

import java.util.List;

import com.xuwem.show.pojo.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(int id);
}
