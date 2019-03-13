package com.xuwem.show.service.impl;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuwem.show.mapper.EmpMapper;
import com.xuwem.show.mapper.OrderMapper;
import com.xuwem.show.mapper.UserMapper;
import com.xuwem.show.pojo.Employee;
import com.xuwem.show.pojo.Order;
import com.xuwem.show.pojo.OrderVo;
import com.xuwem.show.pojo.PageResult;
import com.xuwem.show.pojo.User;
import com.xuwem.show.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private EmpMapper empMapper;
	

	/*
	 * 从数据库角度来看
	 *  订单表传 user_id 和 charge_id
	 * 从前台取值时 要把Username 和chargeName 传过去
	 * 从数据库查3次  分别findAll   好过findById 
	 * 筛选
	 * (non-Javadoc)
	 * @see com.xuwem.show.service.OrderService#findPage(int, int)
	 */
	
	@Override
	public PageResult findPage(int page ,int rows) {
		//分页开始
        PageHelper.startPage(page, rows);////////
        List<Order> listOrder=orderMapper.findAll();
        
        
		Page<Order> result=(Page<Order>) listOrder;
		
		//从订单表取值 
		//数据合并
		List<User> listUser=userMapper.findAll();
		List<Employee> listEmp=empMapper.findAll();
		List<OrderVo> list=new ArrayList<OrderVo>();
		
		
		
		OrderVo orderVo=null;
		//从员工表根据员工id取员工名字
		for(Order order:listOrder)
			
		{   //对每个Order创建一个OrderVo对象
			orderVo=new OrderVo();
		    orderVo.setOrder(order);
			for(User user:listUser)
			{//取User表里的UserName
				
				if(order.getUserId()==user.getUserId())
				{
					//封装userId对应的userName
					orderVo.setUserName(user.getUserName());
					break;//退出当前循环
				}
			}
			
			for(Employee employee:listEmp)
			{//取emp表里的empName
				
				if(employee.getEmpId()==order.getChargeId())
				{
					//封装userId对应的userName
					orderVo.setChargeName(employee.getEmpName());
					break;//退出当前循环
				}
			}
			//讲合并后的对象添加到集合
			list.add(orderVo);
		}
		
		return new PageResult(result.getTotal(), list);
	}


	@Override
	public OrderVo findById(int ordId,int userId,int chargeId) {
		// TODO Auto-generated method stub
		//查找order_id出来的Order  此时的用户和员工都是id
		Order order=orderMapper.findById(ordId);
//		user
		User user=userMapper.findById(userId);
//		Employee
		Employee employee=empMapper.findById(chargeId);
		
		OrderVo orderVo=new OrderVo();
		orderVo.setOrder(order);
		orderVo.setChargeName(employee.getEmpName());
		orderVo.setUserName(user.getUserName());
		return orderVo;
	}


	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		orderMapper.update(order);
	}


	@Override
	public void delById(int id) {
		// TODO Auto-generated method stub
		orderMapper.delById(id);
	}


	@Override
	public void add(Order order) {
		// TODO Auto-generated method stub
		
		
		  
		
		  order.setOrdTime(new Date());
		 
		
		orderMapper.add(order);
		System.out.println("执行完了》》》add server...");
	}


	/**
	 * 此方法测试我逻辑是否行的通
	 * 实际上，取goodsName这一项在service层做更好
	 * 因为一个方法就可以搞定
	 * 如果测得通，就该为在此接收search对象
	 * 然后进行值类型转换
	 * 最后执行分页合并操作
	 */
	@Override
	public PageResult findByName(int page,int rows,String goodsName) {
		// TODO Auto-generated method stub
		
		PageHelper.startPage(page, rows);
		System.out.println("orderMapper。。。");
		List<Order> listOrder=orderMapper.findByName(goodsName);
		System.out.println("listOrder:"+listOrder);
        Page<Order> result=(Page<Order>) listOrder;
        
		//从订单表取值 
		//数据合并
		List<User> listUser=userMapper.findAll();
		List<Employee> listEmp=empMapper.findAll();
		List<OrderVo> list=new ArrayList<OrderVo>();

		OrderVo orderVo=null;
		//从员工表根据员工id取员工名字
		for(Order order:listOrder)
			
		{   //对每个Order创建一个OrderVo对象
			orderVo=new OrderVo();
		    orderVo.setOrder(order);
			for(User user:listUser)
			{//取User表里的UserName
				
				if(order.getUserId()==user.getUserId())
				{
					//封装userId对应的userName
					orderVo.setUserName(user.getUserName());
					break;//退出当前循环
				}
			}
			
			for(Employee employee:listEmp)
			{//取emp表里的empName
				
				if(employee.getEmpId()==order.getChargeId())
				{
					//封装userId对应的userName
					orderVo.setChargeName(employee.getEmpName());
					break;//退出当前循环
				}
			}
			//讲合并后的对象添加到集合
			list.add(orderVo);
		}
		
		return new PageResult(result.getTotal(), list);
	}
	
	/**
	 * 此方法测试我逻辑是否行的通
	 * 实际上，取goodsName这一项在service层做更好
	 * 因为一个方法就可以搞定
	 * 如果测得通，就该为在此接收search对象
	 * 然后进行值类型转换
	 * 最后执行分页合并操作
	 * 
	 * 此方法行的通
	 * 后面先写出各个方法
	 * 然后优化
	 */
	@Override
	public PageResult findByUserId(int page,int rows,int userId) {
		// TODO Auto-generated method stub
		
		PageHelper.startPage(page, rows);
		System.out.println("orderMapper。。。");
		List<Order> listOrder=orderMapper.findByUserId(userId);
		System.out.println("listOrder:"+listOrder);
        Page<Order> result=(Page<Order>) listOrder;
        
		//从订单表取值 
		//数据合并
		List<User> listUser=userMapper.findAll();
		List<Employee> listEmp=empMapper.findAll();
		List<OrderVo> list=new ArrayList<OrderVo>();

		OrderVo orderVo=null;
		//从员工表根据员工id取员工名字
		for(Order order:listOrder)
			
		{   //对每个Order创建一个OrderVo对象
			orderVo=new OrderVo();
		    orderVo.setOrder(order);
			for(User user:listUser)
			{//取User表里的UserName
				
				if(order.getUserId()==user.getUserId())
				{
					//封装userId对应的userName
					orderVo.setUserName(user.getUserName());
					break;//退出当前循环
				}
			}
			
			for(Employee employee:listEmp)
			{//取emp表里的empName
				
				if(employee.getEmpId()==order.getChargeId())
				{
					//封装userId对应的userName
					orderVo.setChargeName(employee.getEmpName());
					break;//退出当前循环
				}
			}
			//讲合并后的对象添加到集合
			list.add(orderVo);
		}
		
		return new PageResult(result.getTotal(), list);
	}
	
}
