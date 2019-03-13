package com.xuwem.show.controller;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xuwem.show.pojo.Department;
import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.Result;
import com.xuwem.show.pojo.User;
import com.xuwem.show.service.DepService;

@RestController
@RequestMapping("/dep")
public class DepController {

	@Autowired
	private DepService depService;
	

	
	@RequestMapping("/show")
	public String getService() {
		 depService.getDao();
		 return "ok";
	}
	
	/*
	 * @RequestMapping("/findOne") public String findOne(int id) { User
	 * user=depService.findOne(id); System.out.println(user); return "ok";
	 * 
	 * }
	 */
	
	
	/**
	 * 分页查询
	 * @param row
	 * @param page
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page,int rows)
	{
	PageResult result=depService.findPage(page, rows);
		return result;
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Department> findAll() {
		List<Department> list=depService.findAll();
		return list;
	}
	
	/**
	 * 逻辑删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/logicdelById")
	public Result logicDelById(int id)
	{
		
		try {
			depService.logicDelById(id);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "删除失败");
		}
	}
	
	/**
	 * 修改部门信息
	 * @return
	 */
	
	@RequestMapping(value="update",method = RequestMethod.POST)
	public Result update(@RequestBody Department department){
		
		try {
			depService.update(department);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(true, "修改失败");
		}
	}
	
	@RequestMapping(value="insert",method = RequestMethod.POST)
	public Result insert(@RequestBody Department department)
	{
		
		try {
			depService.insert(department);
			return new Result(true, "新增成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(true, "新增失败");
		}
	}
	
	/**
	 * 修改前信息查询
	 * @param id
	 * @return
	 */
	@RequestMapping("/findById")
	public Department findById(int id) {
		System.out.println(id);
		Department department=depService.findById(id);
		
		System.out.println(department);
		return department;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delByIds")
	public Result delByIds(int[] ids)
	{
		/* System.out.println(ids); */
		try {
			depService.delByIds(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "删除失败");
		}
		
	}

}
