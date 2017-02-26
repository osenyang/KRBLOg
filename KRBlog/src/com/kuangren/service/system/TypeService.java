package com.kuangren.service.system;

import java.util.List;

import com.kuangren.po.type.Type;
import com.kuangren.po.type.TypeCustom;
import com.kuangren.po.type.TypeExample;

public interface TypeService {

	public TypeCustom getById(Integer id) throws Exception;

	public List<TypeCustom> list(TypeExample example) throws Exception;

	public void encryption(Integer id, Integer secretCode) throws Exception;

	public void delete(Integer id) throws Exception;

	/** 新增 */
	public void save(Type type) throws Exception;

	public void usedPlus1(Integer id) throws Exception;

	/** 根据标记mark，（包含all）找出类别列表 */
	public List<Type> getTypesByMark(String mark) throws Exception;

}
