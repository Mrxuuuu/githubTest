package com.xuwem.show.mapper;

import java.util.List;

import com.xuwem.show.pojo.Order;
import com.xuwem.show.pojo.User;

public interface UserMapper {
	/**
	 * 查询所有记录
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * 根据UserId查找
	 * @param userId
	 * @return
	 */
	public User findById(int userId);
	
	
}
