package com.xuwem.show.mapper;




import java.util.List;

import com.xuwem.show.pojo.Department;
import com.xuwem.show.pojo.DepartmentExample;
import com.xuwem.show.pojo.User;

public interface DepMapper {

	//public User findOne(int id);
	
	
	/**查询全部
	 * 
	 * @return
	 */
	public List<Department> findAll();
	
	/**
	  *逻辑删除
	 * @param id
	 */
	public void logicDelById(int id);
	
	
	
	/**
	 * 修改操作
	 * @param department
	 */
	public void update(Department department);
	
	/**
	 * 插入操作
	 * @param department
	 */
	public void insert(Department department);
	
	/**
	 * 修改前查询
	 * @param id
	 */
	public Department findById(int id);
	
	/**
	 * 根据id进行删除
	 * @param id
	 */
	public void delById(int id);
}
