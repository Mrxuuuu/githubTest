package com.xuwem.show.service;

import java.util.List;

import com.xuwem.show.pojo.Department;
import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.User;




public interface DepService {

	public void getDao();
	
//	public User findOne(int id);
	
	/**
	 * 分页查询
	 * @param row
	 * @param page
	 * @return
	 */
	public PageResult findPage(int row,int page);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Department> findAll();
	
	/**
	 * 逻辑删除
	 * @param id
	 */
	public void logicDelById(int id);
	
	/**
	 * 修改部门
	 * @param department
	 */
	public void update(Department department);
	
	/**
	 * 新增部门
	 * @param department
	 */
	public void insert(Department department);
	
	/**
	 * 修改前查询
	 * @param id
	 * @return
	 */
	public Department findById(int id);
	
	/**
	 * 根据int[] 数组进行批量删除
	 * @param ids
	 */
	public void delByIds(int[] ids);
	
	
}
