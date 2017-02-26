package com.kuangren.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kuangren.mapper.social.circle.MoodMapper;
import com.kuangren.po.mood.Mood;

public class MoodMapperTest {

	private ApplicationContext applicationContext;
	
	private MoodMapper moodMapper;


	//在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		moodMapper = (MoodMapper) applicationContext.getBean("moodMapper");
		
	}

	@Test
	public void testCountByExample() {
//		MoodExample example = new MoodExample();
//		example.setDistinct(true);
		int countByExample = moodMapper.countByExample(null);
		System.out.println("MoodMapperTest.testCountByExample()----------------------" +countByExample);
	}

	@Test
	public void testSelectByPrimaryKey() {
		System.out.println("MoodMapperTest.testSelectByPrimaryKey()");
		
		Mood mood = moodMapper.selectByPrimaryKey(6);
		
		System.out.println(mood);
	}

}
