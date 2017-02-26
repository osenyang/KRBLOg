package com.kuangren.service;

import java.util.List;
/**
 * 基本的service
 * Title: com.kuangren.service.BaseService
 * Description:
 * @createTime: 2017年2月18日 - 下午3:16:16
 * @Company: KuangRen
 * @author: OsenYang
 * @version: 1.0
 */
public interface BaseService <C>{

	
	public C getById(Integer id) throws Exception;

	public List<C> list() throws Exception;

	public void delete(Integer id) throws Exception;

	/** 新增与修改 */
	public void save(C entity) throws Exception;
}
