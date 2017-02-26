package com.kuangren.service.social.blog;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kuangren.po.log.Log;
import com.kuangren.po.log.LogCustom;

public interface LogService {
	
	/** 查询最新日志，前面多少条记录 */
	//这几个返回首页的也是要判断是否管理员，从而选择返回的数据，这需要增加一条增加条件的查询于mapper.xml
	//public List<LogCustom> getListFront(Integer front) throws Exception;
	public List<LogCustom> getListFront(HttpSession session, Integer front) throws Exception;
	
	
	public LogCustom getById(HttpSession session, Integer id) throws Exception;
	
	public List<LogCustom> list(HttpSession session) throws Exception;

	/** 新增或者修改 */
	public void save(Log log) throws Exception;

	public void encryption(Integer id, Integer secretCode) throws Exception;

	public void delete(Integer id) throws Exception;

	public void setStatus(Integer id, Integer statusCode) throws Exception;

	public void setTop(Integer id) throws Exception;

	public void cancelTop(Integer id) throws Exception;

	/** 被观看 +1 */
	public void seePlus1(Integer id) throws Exception;

	public Log getById(Integer id) throws Exception;

}
