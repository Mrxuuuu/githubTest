package com.xuwem.show.service;

import java.util.List;

import com.xuwem.show.pojo.Order;
import com.xuwem.show.pojo.OrderVo;
import com.xuwem.show.pojo.PageResult;

public interface OrderService {

	/**
	 * 分页查询
	 * 返回包装pojo OrderVo
	 * @return
	 */
	public PageResult findPage(int page ,int rows);
	
	/**
	 * 根据id进行查找
	 * @param id
	 * @return
	 */
    public OrderVo findById(int ordId,int userId,int chargeId);
    
    /**
     * 保存修改对象
     * @param orderVo
     */
    public void update(Order order);
    
    /**
     * 新增对象
     * @param order
     */
    public void add(Order order);
    
    
    /**
     * 根据id删除
     * @param id
     */
    public void delById(int id);
    
    /**
     * 根据名字模糊查询
     * @param goodsName
     * @return
     */
    public PageResult findByName(int page,int rows,String goodsName);
    
    /**
     * 根据userId进行准确查询
     * @param page
     * @param rows
     * @param userId
     * @return
     */
    public PageResult findByUserId(int page,int rows,int userId); 
}
