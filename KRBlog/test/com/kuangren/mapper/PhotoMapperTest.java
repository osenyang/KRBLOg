package com.kuangren.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kuangren.mapper.social.circle.PhotoMapper;
import com.kuangren.po.PagingBean;
import com.kuangren.po.photo.Photo;
import com.kuangren.po.photo.PhotoCustom;
import com.kuangren.po.photo.PhotoExample;
import com.kuangren.po.photo.PhotoExample.Criteria;
import com.kuangren.po.photo.PhotoQueryVo;
import com.kuangren.util.BeanMapper;

public class PhotoMapperTest {

	private ApplicationContext applicationContext;
	
	private PhotoMapper photoMapper;


	//在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		photoMapper = (PhotoMapper) applicationContext.getBean("photoMapper");
		
	}

	@Test
	public void test(){
		PhotoQueryVo photoQueryVo = new PhotoQueryVo();
		
		PhotoCustom poCustom1 = new PhotoCustom();
		photoQueryVo.setPoCustom(poCustom1);
		
		PhotoCustom poCustom = photoQueryVo.getPoCustom();
		poCustom.setFavor(666);
		
		System.out.println(poCustom.getFavor());
	}
	
	@Test
	public void testSelectByExample() {
		PhotoExample example = new PhotoExample();
		Criteria criteria = example.createCriteria();// 为何创建出来一个criteria 就帮你add进去
		criteria.andParent_idEqualTo(4);
		//example.or(criteria);// 因为上面创建的时候已经帮你add 进去了，所以这里无需在加进去
		
		List<Photo> photoList = photoMapper.selectByExample(example);
		
		System.out.println(BeanMapper.mapList(photoList, PhotoCustom.class));
	}

	@Test
	public void getListPaging() throws Exception {
		
		PhotoQueryVo qVo = new PhotoQueryVo();
		
		PagingBean pagingBean = new PagingBean();
		pagingBean.setLimitFront(6);
		
		qVo.setPagingBean(pagingBean);
		
		List<PhotoCustom> list = photoMapper.getListFront(qVo);
		for (PhotoCustom photoCustom : list) {
			System.out.println("id: " + photoCustom.getId() 
				+ "  name: " + photoCustom.getName()
				+ "  path: " + photoCustom.getImgPath());
		}
	}
}
