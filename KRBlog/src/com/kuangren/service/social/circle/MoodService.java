package com.kuangren.service.social.circle;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kuangren.po.mood.Mood;
import com.kuangren.po.mood.MoodCustom;

public interface MoodService {
	
	/** 查询最新心情，前面多少条记录 */
	//TODO 这几个返回首页的也是要判断是否管理员，从而选择返回的数据，这需要增加一条增加条件的查询于mapper.xml
	//public List<MoodCustom> getListFront(Integer front) throws Exception;
	
	public List<MoodCustom> getListFront(HttpSession session, Integer front) throws Exception;

	public MoodCustom getById(HttpSession session, Integer id) throws Exception;
	
	public List<MoodCustom> list(HttpSession session) throws Exception;

	/** 新增或者修改 */
	public void save(Mood mood) throws Exception;

	public void encryption(Integer id, Integer secretCode) throws Exception;

	public void delete(Integer id) throws Exception;

	public void setStatus(Integer id, Integer statusCode) throws Exception;

	public void setTop(Integer id) throws Exception;

	public void cancelTop(Integer id) throws Exception;

	/** 被观看 +1 */
	public void seePlus1(Integer id) throws Exception;

	public Mood getById(Integer id) throws Exception;

	

}
