package com.kuangren.service.social.blog.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuangren.enumerate.SecretEnum;
import com.kuangren.enumerate.StatusEnum;
import com.kuangren.mapper.social.blog.LogMapper;
import com.kuangren.po.PagingBean;
import com.kuangren.po.log.Log;
import com.kuangren.po.log.LogCustom;
import com.kuangren.po.log.LogExample;
import com.kuangren.po.log.LogQueryVo;
import com.kuangren.po.user.User;
import com.kuangren.service.impl.BaseServiceImpl;
import com.kuangren.service.social.blog.LogService;
import com.kuangren.util.BeanMapper;
import com.kuangren.util.Counter;
import com.kuangren.util.DateUtil;

@Service
public class LogServiceImpl extends BaseServiceImpl implements LogService {

	@Autowired
	private LogMapper logMapper;
	
	@Override
	public LogCustom getById(Integer id) throws Exception {
		Log log = logMapper.selectByPrimaryKey(id);
		
		LogCustom logCustom = BeanMapper.map(log, LogCustom.class);
		
		return logCustom;
	}
	
	@Override
	public LogCustom getById(HttpSession session, Integer id) throws Exception {
		Log log = logMapper.selectByPrimaryKey(id);

		LogCustom logCustom = BeanMapper.map(log, LogCustom.class);
		
		//普通的数据，直接给你返回
		if (logCustom.getStatus() != StatusEnum.DELETE && logCustom.getIsSecret() == SecretEnum.NORMAL) {
			return logCustom;
		}else {
			User manager = getSessionManager(session);
			if (manager == null) {//不是管理员
				return null;
			}else {//管理员
				return logCustom;
			}
		}
	}

	@Override
	public List<LogCustom> list(HttpSession session) throws Exception {
		LogExample example = new LogExample();
		
		if (getSessionManager(session) == null) {
			example.createCriteria().andStatusNotEqualTo(StatusEnum.DELETE)
				.andIsSecretEqualTo(SecretEnum.NORMAL).andStatusNotEqualTo(StatusEnum.DRAFT);
		}
		example.setOrderByClause("topTime desc, createTime desc");
		List<Log> logList = logMapper.selectByExample(example);

		List<LogCustom> logCustoms = BeanMapper.mapList(logList, LogCustom.class);
		
		/** 判断并且修改是否置顶 */
		for (LogCustom logCustom : logCustoms) {
			
			if (DateUtil.isNewDate(logCustom.getTopTime())){
				logCustom.setIsTop(true);
			}
		}
		
		return logCustoms;
	}

	@Override
	public void save(Log log) throws Exception {
		
		if (log.getId() == null) {
			// 新增
			log.setCreateTime(new Date());
			if (log.getIsSecret() == null) {
				log.setIsSecret(SecretEnum.NORMAL);
			}
			
			if (log.getStatus() == null) {
				log.setStatus(StatusEnum.NORMAL);
			}
			/*log.setReplyCount(0);
			log.setSeeCount(0);*/
			
			log.setTopTime(DateUtil.getOldDate());
			
			logMapper.insert(log);
		} else {
			// 修改
			log.setUpdateTime(new Date());
			logMapper.updateByPrimaryKeySelective(log);
		}
		
	}

	/** 设置或修改加密 */
	@Override
	public void encryption(Integer id, Integer secretCode) throws Exception {
		Log log = new Log();
		log.setId(id);
		log.setIsSecret(secretCode);
		logMapper.updateByPrimaryKeySelective(log);
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		logMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void setStatus(Integer id, Integer statusCode) throws Exception {
		Log log = new Log();
		log.setId(id);
		log.setStatus(statusCode);

		logMapper.updateByPrimaryKeySelective(log);
		
	}

	private void changeTop(Integer id, Date date) throws Exception {
		Log log = new Log();
		log.setId(id);
		log.setTopTime(date);
		
		logMapper.updateByPrimaryKeySelective(log);
	}
	
	@Override
	public void setTop(Integer id) throws Exception {
		
		changeTop(id, new Date());
		
	}

	@Override
	public void cancelTop(Integer id) throws Exception {
		
		changeTop(id, DateUtil.getOldDate());
		
	}

	
	@Override
	public void seePlus1(Integer id) throws Exception {
		Log log = logMapper.selectByPrimaryKey(id);
		log.setSeeCount(Counter.plus1(log.getSeeCount()));
		
		logMapper.updateByPrimaryKeySelective(log);
	}

	@Override
	public List<LogCustom> getListFront(HttpSession session, Integer front) throws Exception {
		LogQueryVo qVo = new LogQueryVo();
		
		if (getSessionManager(session) == null) {
			LogCustom poCustom = new LogCustom();
			poCustom.setStatus(StatusEnum.DELETE);
			poCustom.setIsSecret(SecretEnum.NORMAL);
//			qVo.setLogCustom(logCustom);
			qVo.setPoCustom(poCustom);
		}
		
		PagingBean pagingBean = new PagingBean();
		pagingBean.setLimitFront(front);
		
		qVo.setPagingBean(pagingBean);
		
		/*if (getSessionManager(session) == null) {
			
			return logMapper.getListFrontCondition(qVo);
		}*/
		
		return logMapper.getListFront(qVo);
	}
	
}
