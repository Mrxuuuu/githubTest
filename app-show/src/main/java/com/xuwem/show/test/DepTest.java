package com.xuwem.show.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xuwem.show.mapper.DepMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:ApplicationContext-*.xml\"")
public class DepTest {
	
  @Autowired
  private DepMapper depMapper;

  @org.junit.Test
  public void Test() {
	  int id=1;
	  System.out.println( depMapper.findById(id));
	 
  }
  
}
