package com.kuangren.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kuangren.mapper.social.circle.MessageMapper;
import com.kuangren.po.PagingBean;
import com.kuangren.po.message.Message;
import com.kuangren.po.message.MessageCustom;
import com.kuangren.po.message.MessageQueryVo;
import com.kuangren.po.user.User;

public class MessageMapperTest {

	private ApplicationContext applicationContext;

	private MessageMapper messageMapper;

	// 在setUp这个方法得到spring容器
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		messageMapper = (MessageMapper) applicationContext.getBean("messageMapper");

	}

	@Test
	public void testGetPagingList() throws Exception {
		MessageQueryVo qVo = new MessageQueryVo();
		
		PagingBean pagingBean = new PagingBean(1);
		qVo.setPagingBean(pagingBean);
		
		List<Integer> ids = messageMapper.getLimitIds(qVo);
		
		qVo.setLimitIds(ids);
		
		List<MessageCustom> list = messageMapper.getPagingList(qVo);
		
		System.out.println(list);
	}
	
	@Test
	public void testGetList() throws Exception {
		Page<MessageCustom> page = PageHelper.startPage(4, 10);
		List<MessageCustom> list = messageMapper.getList();
		
		List<MessageCustom> result = page.getResult();
		
		PageInfo<MessageCustom> info = new PageInfo<MessageCustom>(page);
		List<MessageCustom> list2 = info.getList();
		
		
		for (MessageCustom messageCustom : list) {
			if (messageCustom.getUser_id() != null) {
				User user = messageCustom.getUser();
				System.out.println(user.getImgPath());
			}
		}
	}

	@Test
	public void testGetFullEntity() throws Exception {
		MessageCustom fullEntity = messageMapper.getFullEntity(66);
		System.out.println(fullEntity);
		for (Message child : fullEntity.getChildren()) {
			System.out.println(child.getId() + " : " + child.getContent());
		}
	}
	
	@Test
	public void getLimitIds() throws Exception {
		MessageQueryVo qVo = new MessageQueryVo();
		PagingBean pagingBean = new PagingBean(1);
		qVo.setPagingBean(pagingBean);
		List<Integer> limitIds = messageMapper.getLimitIds(qVo);
		for (int i = 0; i < limitIds.size(); i++) {
			System.out.println(limitIds.get(i));
		}
	}

}
