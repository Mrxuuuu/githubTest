package com.xuwem.show.mapper;

import java.util.List;

import com.xuwem.show.pojo.Employee;

public interface EmpMapper {

	/**
	 * 查询全部
	 * @return
	 */
	public List<Employee> findAll();
	
	/**
	 * 根据id查询
	 * @param chargeId
	 * @return
	 */
	public Employee findById(int chargeId);
	
	/**
	 * 将文件路径上传到数据库
	 * @param filePath
	 */
	public void uploadFile(Employee employee);
}
