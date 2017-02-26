package com.kuangren.service.social.circle;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kuangren.po.PagingBean;
import com.kuangren.po.message.Message;
import com.kuangren.po.message.MessageCustom;
import com.kuangren.po.message.MessageExample;

public interface MessageService {
	
	/** 查询最新留言，前面多少条记录 */
	public List<MessageCustom> getListFront(Integer front) throws Exception;

	public MessageCustom getById(Integer id) throws Exception;
	
	public List<MessageCustom> list(MessageExample example) throws Exception;

	/** 新增 */
	public void save(HttpServletRequest request, Message message) throws Exception;

	public void delete(Integer id) throws Exception;

	/** 设置为主人寄语 */
	public void setSend(Integer id) throws Exception;

	/** 取出设为寄语的留言 */
	public MessageCustom getSendWordMesg() throws Exception;

	/** 查询留言列表，附带留言的父留言 */
	public List<MessageCustom> getList() throws Exception;

	/** 查询留言列表==真分页 */
	public PagingBean getPagingList(Integer pageNum) throws Exception;

	/*public Integer count() throws Exception;*/

}
