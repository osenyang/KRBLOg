package com.kuangren.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kuangren.enumerate.TypeEnum;
import com.kuangren.mapper.system.TypeMapper;
import com.kuangren.po.type.Type;
import com.kuangren.po.type.TypeExample;

public class TypeMapperTest {
	
	private ApplicationContext applicationContext;
	
	private TypeMapper typeMapper;


	//在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		typeMapper = (TypeMapper) applicationContext.getBean("typeMapper");
		
	}

	@Test
	public void testSelectByExample() {
		TypeExample example = new TypeExample();
		example.createCriteria().andMarkEqualTo(TypeEnum.ALL);
		example.or().andMarkEqualTo(TypeEnum.MOOD);
		
		@SuppressWarnings("unused")
		List<Type> list = typeMapper.selectByExample(example);
		System.out.println("hole on");
	}

}
