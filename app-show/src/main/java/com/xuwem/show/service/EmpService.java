package com.xuwem.show.service;

import com.xuwem.show.pojo.PageResult;

public interface EmpService {

	/**
	 * 分页查询
	 * 查询全部
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageResult findPage(int page,int rows);
	
	/**
	 * 将文件路径上传到数据库
	 * @param filePath
	 */
	public void uploadFile(String empImg);
	
	/**
	 * 将文件路径上传到数据库
	 * @param filePath
	 */
	public void uploadFile();
}
