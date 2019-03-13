package com.xuwem.show.service;

import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.Result;

public interface DepRecoverService {
	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageResult findPage(int page, int rows);

	/**
	 * 逻辑恢复
	 * 
	 * @param id
	 * @return
	 */
	public Result recover(int id);

	/**
	 * 硬盘删除
	 * 
	 * @param id
	 * @return
	 */
	public Result delById(int id);
}
