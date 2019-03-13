package com.xuwem.show.mapper;

import java.util.List;

import com.xuwem.show.pojo.Department;
import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.Result;

public interface DepRecoverMapper {

	/**
	 * 分页查询
	 * @return
	 */
	public List<Department> findPage();
	
	/*
	 * 恢复
	 * 
	 */
	public Result recover(int id);
	
	/**
	 * 硬盘删除
	 * @param id
	 * @return
	 */
	public Result delById(int id);
}
