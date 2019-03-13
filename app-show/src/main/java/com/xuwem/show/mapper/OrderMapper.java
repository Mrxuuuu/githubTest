package com.xuwem.show.mapper;

import java.util.List;

import com.xuwem.show.pojo.Order;
import com.xuwem.show.pojo.OrderVo;

public interface OrderMapper {

	/**
	 * 查询所有
	 */
	public List<Order> findAll();
	
	/**
	 * 根据Id进行查询
	 * @param id
	 * @return
	 */
	public Order findById(int id);
	
	/**
	 * 保存修改实体
	 * @param OrderVo
	 */
	public void update(Order order);
	
	/**
	 * 根据id删除
	 * @param id
	 */
	public void delById(int id);
	
	/**
	 * 新增订单
	 * @param order
	 */
	public void add(Order order);
	
	/**
	 * 根据名字进行模糊查询
	 * @param goodsName
	 * @return
	 */
	public List<Order> findByName(String goodsName);
	
	/**
	 * 根据userId进行订单准确查找
	 * @param page
	 * @param rows
	 * @param userId
	 * @return
	 */
	public List<Order> findByUserId(int userId);
	
	
	
	
}
