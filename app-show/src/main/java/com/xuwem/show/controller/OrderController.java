package com.xuwem.show.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuwem.show.pojo.Order;
import com.xuwem.show.pojo.OrderVo;
import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.Result;
import com.xuwem.show.pojo.SearchType;
import com.xuwem.show.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	/**
	 * 分页查找
	 * 
	 * @return
	 */
	
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		return orderService.findPage(page, rows);
	}

	/**
	 * 修改前查找
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findById")
	public OrderVo findById(int ordId, int userId, int chargeId) {

		return orderService.findById(ordId, userId, chargeId);

	}

	/**
	 * 保存修改
	 * 
	 * @param OrderVo
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody OrderVo orderVo) {
		try {
			/*
			 * System.out.println(orderVo.getOrder().getOrdId());
			 * System.out.println(orderVo.getOrder().getGoodsName());
			 */

			orderService.update(orderVo.getOrder());
			System.out.println("执行插入");
			return new Result(true, "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "修改失败");
		}

	}

	/*
	 * update 测试
	 * 
	 * @RequestMapping("/update1") public void update() { Order order=new Order();
	 * order.setGoodsName("update1"); order.setOrdId(1); orderService.update(order);
	 * }
	 */

	/**
	 * 新增订单
	 * 
	 * @param orderVo
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody OrderVo orderVo) {
		try {
			 Order order=orderVo.getOrder();
             
			 System.out.println("过来了。。。add");
			/*
			 * System.out.println(order.getOrdType()); System.out.println(order.getPrice());
			 * System.out.println(order.getGoodsName());
			 * System.out.println(order.getGoodsNum());
			 */
			orderService.add(order);
			System.out.println("执行了》》》add");
			return new Result(true, "新增成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "新增失败");
		}

	}

	/**
	 * 添加测试
	 */
	/*
	 * @RequestMapping("/add1") public Result add1() { try {
	 * 
	 * Order order=new Order(); order.setOrdType("水果1"); order.setPrice(100);
	 * order.setGoodsName("苹果1"); order.setGoodsNum(1);
	 * System.out.println(order.getOrdType()); System.out.println(order.getPrice());
	 * System.out.println(order.getGoodsName());
	 * System.out.println(order.getGoodsNum()); orderService.add(order); return new
	 * Result(true, "新增成功"); } catch (Exception e) { // TODO: handle exception
	 * return new Result(false, "新增失败"); }
	 * 
	 * }
	 */

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/delById")
	public Result delById(int id) {
		try {
			orderService.delById(id);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(true, "删除失败");
		}
	}

	/**
	 * 条件查询 条件为空即为查询全部 条件不为空则根据条件查询
	 * 
	 * @param page
	 * @param rows
	 * @param searchType
	 * @return
	 */
	@RequestMapping("/selectByType")
	public PageResult selectByType(int page, int rows, @RequestBody SearchType searchType) {
		PageResult pageResult = null;
		if (searchType.getType() != null && searchType.getType() != "" && searchType.getInfo() != null
				&& searchType.getInfo() != "")
		{

			if (searchType.getType().equals("name")) {
				
				// 根据名字查询即 select * from ord where ... 模糊查询
				// 取名字
				String goodsName = (String) searchType.getInfo();
				pageResult = orderService.findByName(page, rows, goodsName);
			}
			
			if (searchType.getType().equals("user")){
				// 根据userId查
				//从前端封装的信息中取出userId
				//此时searchType.getInfo()里的id为字符串类型
				
				int userId = Integer.parseInt((String) searchType.getInfo());
				System.out.println(userId);
				
				// 给pageResult赋值
				pageResult = orderService.findByUserId(page, rows, userId);
			}
			
			if (searchType.getType() == "charge") {
				// 跟据chargeId查
			}
			
			if (searchType.getType() == "statu") {
				// 根据订单状态查 后期将前端作为下拉框处理
			}
		} 
		else {
			// 查询类别为空即查询全部
			pageResult = orderService.findPage(page, rows);
		}

		return pageResult;
	}

}
