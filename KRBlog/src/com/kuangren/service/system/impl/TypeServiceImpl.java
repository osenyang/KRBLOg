package com.kuangren.service.system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuangren.enumerate.SecretEnum;
import com.kuangren.enumerate.StatusEnum;
import com.kuangren.enumerate.TypeEnum;
import com.kuangren.mapper.system.TypeMapper;
import com.kuangren.po.type.Type;
import com.kuangren.po.type.TypeCustom;
import com.kuangren.po.type.TypeExample;
import com.kuangren.service.system.TypeService;
import com.kuangren.util.BeanMapper;
import com.kuangren.util.Counter;
@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeMapper typeMapper;
	
	@Override
	public TypeCustom getById(Integer id) throws Exception {
		Type type = typeMapper.selectByPrimaryKey(id);

		TypeCustom typeCustom = BeanMapper.map(type, TypeCustom.class);
		
		return typeCustom;
	}

	@Override
	public List<TypeCustom> list(TypeExample example) throws Exception {
		example.setOrderByClause("used desc");//, seeCount desc, replyCount desc");
		List<Type> typeList = typeMapper.selectByExample(example);

		List<TypeCustom> typeCustoms = BeanMapper.mapList(typeList, TypeCustom.class);
		
		return typeCustoms;
	}


	/** 设置或修改加密 */
	@Override
	public void encryption(Integer id, Integer secretCode) throws Exception {
		Type type = typeMapper.selectByPrimaryKey(id);
		type.setIsSecret(secretCode);
		typeMapper.updateByPrimaryKey(type);
	}

	@Override
	public void delete(Integer id) throws Exception {
		//TODO 删除之前先把底下的所有引用该类别的表的type 属性设置为null
		//查找出所有应用了该相册的表
		//修改并更新那些表的类别字段为null
		typeMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void save(Type type) throws Exception {
		//TODO 查询并检查类别名称是否已经存在
		type.setCreateTime(new Date());
		type.setIsSecret(SecretEnum.NORMAL);
		type.setStatus(StatusEnum.NORMAL);
//		type.setUsed(0);
		
		typeMapper.insert(type);
	}

	@Override
	public void usedPlus1(Integer id) throws Exception {
		Type type = typeMapper.selectByPrimaryKey(id);
//		Type type = new Type();
//		type.setId(id);
		type.setUsed(Counter.plus1(type.getUsed()));
		
		typeMapper.updateByPrimaryKeySelective(type);
		
	}

	@Override
	public List<Type> getTypesByMark(String mark) throws Exception {
		TypeExample example = new TypeExample();
		
		example.createCriteria().andMarkEqualTo(TypeEnum.ALL);
		example.or().andMarkEqualTo(mark);
		
		List<Type> types = typeMapper.selectByExample(example);
		
		return types;
	}

	
}
