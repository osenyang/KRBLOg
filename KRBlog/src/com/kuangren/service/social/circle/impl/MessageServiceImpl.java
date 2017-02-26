package com.kuangren.service.social.circle.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuangren.enumerate.StatusEnum;
import com.kuangren.mapper.social.circle.MessageMapper;
import com.kuangren.po.PagingBean;
import com.kuangren.po.Result;
import com.kuangren.po.message.Message;
import com.kuangren.po.message.MessageCustom;
import com.kuangren.po.message.MessageExample;
import com.kuangren.po.message.MessageQueryVo;
import com.kuangren.service.social.circle.MessageService;
import com.kuangren.util.BeanMapper;
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;

	@Override
	public MessageCustom getById(Integer id) throws Exception {
		Message message = messageMapper.selectByPrimaryKey(id);

		MessageCustom messageCustom = BeanMapper.map(message, MessageCustom.class);

		return messageCustom;
	}

	@Override
	public List<MessageCustom> list(MessageExample example) throws Exception {
		example.setOrderByClause("createTime desc");
		List<Message> messageList = messageMapper.selectByExample(example);

		List<MessageCustom> messageCustoms = BeanMapper.mapList(messageList, MessageCustom.class);

		return messageCustoms;
	}

	@Override
	public void save(HttpServletRequest request, Message message) throws Exception {
		Result result = new Result();
		
		if (message.getParent_id() != null) {// 暂时用面向实体来开发，不用拼接title 内容了。

			// 这里是回复，需要填充 title 里面的内容
			// 格式为：回复第 n 楼 “某某人” ：某某人他的内容
			// message.setTitle(title);

			//父留言的回复数+1
			Message parentMesg = messageMapper.selectByPrimaryKey(message.getParent_id());
			parentMesg.setReplyCount(parentMesg.getReplyCount() == null ? 1 : parentMesg.getReplyCount() + 1);
			messageMapper.updateByPrimaryKeySelective(parentMesg);
			
			result.setText("成功回复!");
		}

		message.setCreateTime(new Date());
		message.setStatus(StatusEnum.NORMAL);

		String ip = request.getRemoteAddr();// 获取 ip
//		String ip2 = NetworkUtil.getRealIpAddress(request);//获取真实的 ip address
//		String ip3 = NetworkUtil.getIpAddr(request);// 获取 ip
//		String ip4 = NetworkUtil.getIpAddr(request);// 获取 ip
											// address。不管用上面的还是这个方法，我自个获取的ip都是有点问题的
		message.setIp(ip);
		/*
		 * message.setSendWord(false); message.setReplyCount(0);
		 * message.setFavor(0); message.setTrample(0);
		 */

		// messageMapper.insertSelective(message);//选择性的更新，有值的才更新
		// 就算你用这条（插入所有字段）的插入，只要你上面没有设值，mybatis
		// 也不会帮你插入哪怕是0或者是FALSE的。所以你不想页面看到为空，那么0是必须要设值进去的
		messageMapper.insert(message);

		// 在mapper 文件中设置返回的最后插入的自增长id到
		// id里面。但是只有在插入完成之后，这个值才会设进去，所以getId只能写在insert 操作之后
		message.setFloor(message.getId());
		// 上面设置floor的值为刚刚获取的id的值。而且，在mapper文件中返回设置id已经有值了，所以再执行更新，就是刚刚新增的那条数据了
		// mybatis 和hibernate 不同，对象没有“游离态”，所以你在insert
		// 操作之后再修改里面的值，它不会自动帮你更新，只能你手动进行更新
		if (message.getNickname() == null) {
			message.setNickname("网友" + message.getFloor());
		}
		messageMapper.updateByPrimaryKeySelective(message);//把id给楼数。把楼数拼接给昵称，更新到数据库

		request.setAttribute("result", result);

	}

	@Override
	public void delete(Integer id) throws Exception {
		// 删除之前先把它的子的子的...一并删除了
		// messageMapper.deleteByPrimaryKey(id);
		deleteAll(id);
	}

	private void deleteAll(Integer id) throws Exception {
		MessageCustom messageCustom = messageMapper.getFullEntity(id);
		List<Message> children = messageCustom.getChildren();
		if (!children.isEmpty()) {
			/*for (int i = 0; i < children.size(); i++) {
				Message child = children.get(i);
				deleteAll(child.getId());
			}*/
			for (Message child : children) {
				deleteAll(child.getId());
			}
		}
		messageMapper.deleteByPrimaryKey(id);
		// return 1;
	}

	@Override
	public void setSend(Integer id) throws Exception {
		// 找出之前设为寄语的留言
		MessageExample example = new MessageExample();
		example.createCriteria().andSendWordEqualTo(true);
		List<Message> messages = messageMapper.selectByExample(example);

		if (!messages.isEmpty()) {
			Message sendWordMesg = messages.get(0);
			// 取消寄语
			sendWordMesg.setSendWord(false);
			messageMapper.updateByPrimaryKeySelective(sendWordMesg);
		}

		// 把刚刚那个要设为寄语的留言更新为寄语
		Message message = new Message();
		message.setId(id);
		message.setSendWord(true);

		messageMapper.updateByPrimaryKeySelective(message);

	}

	@Override
	public MessageCustom getSendWordMesg() throws Exception {
		MessageExample example = new MessageExample();
		example.createCriteria().andSendWordEqualTo(true);
		List<Message> messages = messageMapper.selectByExample(example);

		if (!messages.isEmpty()) {
			Message sendWordMesg = messages.get(0);

			return BeanMapper.map(sendWordMesg, MessageCustom.class);
		}
		return null;
	}

	@Override
	public List<MessageCustom> getList() throws Exception {
		return messageMapper.getList();
	}

	
	@Override
	public List<MessageCustom> getListFront(Integer front) throws Exception {
		MessageQueryVo qVo = new MessageQueryVo();
		
		PagingBean pagingBean = new PagingBean();
		pagingBean.setLimitFront(front);
		
		qVo.setPagingBean(pagingBean);
		
		return messageMapper.getListFront(qVo);
	}

	@Override
	public PagingBean getPagingList(Integer pageNum) throws Exception {
		/*方案1：用mybatis 的分页插件来分页查询。但是，这个插件还是不支持一对多关联查询*/
		/*Page<MessageCustom> page = PageHelper.startPage(pageNum, 10);
		messageMapper.getList();
		
		PageInfo<MessageCustom> info = new PageInfo<MessageCustom>(page);
		
		PagingBean pagingBean = new PagingBean(info);*/
		
		/*方案2：查询单表分页，取得id 列表。根据id 列表去查询关联查询的复杂结果*/
/*		MessageQueryVo qVo = new MessageQueryVo();
		
		PagingBean pagingBean = new PagingBean(pageNum);
		qVo.setPagingBean(pagingBean);
		
		List<Integer> ids = messageMapper.getLimitIds(qVo);//先单表查询出分页会包含的id 列表
		
		qVo.setLimitIds(ids);
		
		List<MessageCustom> list = messageMapper.getPagingList(qVo);//给这个复杂关联的查询定义查询的id 范围
		
		Integer totalCount = messageMapper.countByExample(null);
		
		pagingBean.setPoList(list);
		pagingBean.setTotalCount(totalCount);
		
		pagingBean.computeViewInfo();//把页面显示的相关的信息计算出来
*/		
		
		/*方案3：用子查询*/
		MessageQueryVo qVo = new MessageQueryVo();
		
		PagingBean pagingBean = new PagingBean(pageNum);
		
		qVo.setPagingBean(pagingBean);
		
		List<MessageCustom> list = messageMapper.getPagingList(qVo);//给这个复杂关联的查询定义查询的id 范围
		
		MessageExample countExample = new MessageExample();
		countExample.createCriteria().andStatusNotEqualTo(StatusEnum.DELETE).andStatusNotEqualTo(StatusEnum.MASK);//0为删除，3表示屏蔽
		Integer totalCount = messageMapper.countByExample(countExample);
		
		pagingBean.setPoList(list);
		pagingBean.setTotalCount(totalCount);//自动计算
		
//		pagingBean.computeViewInfo();//把页面显示的相关的信息计算出来
		
		return pagingBean;
	}

	/*@Override
	public Integer count() throws Exception {
//		return messageMapper.countByExample(null);
		return messageMapper.count();
	}*/
}
