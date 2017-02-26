package com.kuangren.mapper.social.circle;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuangren.po.message.Message;
import com.kuangren.po.message.MessageCustom;
import com.kuangren.po.message.MessageExample;
import com.kuangren.po.message.MessageQueryVo;

public interface MessageMapper{
	
	public List<MessageCustom> getPagingList(MessageQueryVo qVo) throws Exception;
	/*public int count() throws Exception;*/
	
	public List<MessageCustom> getListFront(MessageQueryVo qVo) throws Exception;
	/** 查询完整的留言列表，包括留言的父与子 */
	public List<MessageCustom> getList() throws Exception;
	/** 查询这条留言，附带所有子 */
	public MessageCustom getFullEntity(Integer id) throws Exception;
	/** 查询分页ids */
	public List<Integer> getLimitIds(MessageQueryVo qVo) throws Exception;
	
	
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}