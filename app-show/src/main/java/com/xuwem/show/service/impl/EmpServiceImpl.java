package com.xuwem.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuwem.show.mapper.EmpMapper;
import com.xuwem.show.pojo.Employee;
import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpMapper empMapper;
	
	@Override
	public PageResult findPage(int page, int rows) {
		// TODO Auto-generated method stub
		//分页
		PageHelper.startPage(page, rows);
		Page<Employee> result= (Page<Employee>) empMapper.findAll();
		return new PageResult(result.getTotal(), result.getResult());
	}

	
	/**
	 * 此方法仅供测试测试
	 */
	  @Override public void uploadFile() { // TODO Auto-generated method stub
	  Employee employee=new Employee(); String
	  empImg="E:/upload/img6e140e15-b15a-4a08-9e70-5239310d0045banner1.png"; int
	  id=2; employee.setEmpId(id); employee.setEmpImg(empImg);
	  empMapper.uploadFile(employee); }
	 


	@Override
	public void uploadFile(String empImg) {
		// TODO Auto-generated method stub
		Employee employee=new Employee();
		employee.setEmpImg(empImg);
		employee.setEmpId(3);
		empMapper.uploadFile(employee);
	}

	
}
