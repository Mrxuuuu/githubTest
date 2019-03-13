package com.xuwem.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.Result;
import com.xuwem.show.service.DepRecoverService;

@RestController
@RequestMapping("/deprcv")
public class DepRecoverController {

	@Autowired
	private DepRecoverService depRecoverService;

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		/*
		 * System.out.println("page="+page); System.out.println("rows="+rows);
		 * System.out.println("hello");
		 */
		PageResult pageResult = depRecoverService.findPage(page, rows);
		/*
		 * System.out.println(pageResult.getTotal());
		 * System.out.println(pageResult.getRows().get(0));
		 */
		return pageResult;

	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delById")
	public Result delById(int id) {
		try {
			depRecoverService.delById(id);//
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(true, "删除失败");
		}
	}

	/**
	 * 恢复
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/recover")
	public Result recover(int id) {
		try {
			/* System.out.println(id); */
			depRecoverService.recover(id);//
			
			return new Result(true, "恢复成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(true, "恢复失败");
		}

	}
}
