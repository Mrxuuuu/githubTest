package com.xuwem.show.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuwem.show.mapper.DepMapper;
import com.xuwem.show.pojo.Department;
import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.User;
import com.xuwem.show.service.DepService;

@Service
public class DepServiceImpl implements DepService {

	/*
	 * @Autowired private TestDao testDao;
	 */
	@Override
	public void getDao() {
		// TODO Auto-generated method stub
		System.out.println("service");
	}

	@Autowired
	private DepMapper depMapper;
	
	/*
	 * @Override public User findOne(int id) { // TODO Auto-generated method stub
	 * return depMapper.findOne(id); }
	 */

	/**
	 * 借助分页插件分页
	 * 前段传当前页码row和页面大小pabg
	 * 后端传 当前记录和总记录数total
	 */
	@Override
	public PageResult findPage(int row, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(row, page);//启用分页插件
		Page<Department> result = (Page<Department>) depMapper.findAll();
		//返回PageResult对象
		return new PageResult(result.getTotal(), result.getResult());
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return depMapper.findAll();
	}

	@Override
	public void logicDelById(int id) {
		// TODO Auto-generated method stub
		depMapper.logicDelById(id);
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		depMapper.update(department);
	}

	@Override
	public Department findById(int id) {
		// TODO Auto-generated method stub
		return depMapper.findById(id);
		
	}

	@Override
	public void insert(Department department) {
		// TODO Auto-generated method stub
		depMapper.insert(department);
	}

	@Override
	public void delByIds(int[] ids) {
		// TODO Auto-generated method stub
		for(int i=0;i<ids.length;i++)
		{//遍历数组
			//
			depMapper.logicDelById(ids[i]);
		}
	}

	/*
	 * @Override public User findOne(int id) { // TODO Auto-generated method stub
	 * return null; }
	 */
	



	
}
