package com.xuwem.show.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuwem.show.mapper.DepRecoverMapper;
import com.xuwem.show.pojo.Department;
import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.Result;
import com.xuwem.show.service.DepRecoverService;

@Service
public class DepRecoverServiceImpl implements DepRecoverService {

	@Autowired
	private DepRecoverMapper depRecoverMapper;
	
	/*
	 * row 第几页
	 * page 页面大小
	 * (non-Javadoc)
	 * @see com.xuwem.show.service.DepRecoverService#findPage(int, int)
	 */
	@Override
	public PageResult findPage(int page,int row) {
		// TODO Auto-generated method stub	
		PageHelper.startPage(page, row);	
		Page<Department> result= (Page<Department>) depRecoverMapper.findPage();
		return new PageResult(result.getTotal(), result.getResult());
	}

	@Override
	public Result recover(int id) {
		// TODO Auto-generated method stub
		return depRecoverMapper.recover(id);
	}

	@Override
	public Result delById(int id) {
		// TODO Auto-generated method stub
		return depRecoverMapper.delById(id);
	}
}
