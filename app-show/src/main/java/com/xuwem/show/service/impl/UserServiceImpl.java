package com.xuwem.show.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuwem.show.mapper.UserMapper;
import com.xuwem.show.pojo.User;
import com.xuwem.show.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserMapper userMapper;
	
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

}
