package com.kuangren.service.social.circle.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuangren.enumerate.SecretEnum;
import com.kuangren.enumerate.StatusEnum;
import com.kuangren.mapper.social.circle.MoodMapper;
import com.kuangren.po.PagingBean;
import com.kuangren.po.mood.Mood;
import com.kuangren.po.mood.MoodCustom;
import com.kuangren.po.mood.MoodExample;
import com.kuangren.po.mood.MoodQueryVo;
import com.kuangren.po.user.User;
import com.kuangren.service.impl.BaseServiceImpl;
import com.kuangren.service.social.circle.MoodService;
import com.kuangren.util.BeanMapper;
import com.kuangren.util.Counter;
import com.kuangren.util.DateUtil;
@Service
public class MoodServiceImpl extends BaseServiceImpl implements MoodService {

	@Autowired
	private MoodMapper moodMapper;
	
	@Override
	public MoodCustom getById(Integer id) throws Exception {
		Mood mood = moodMapper.selectByPrimaryKey(id);
		
		MoodCustom moodCustom = BeanMapper.map(mood, MoodCustom.class);
		
		return moodCustom;
		
	}
	
	@Override
	public MoodCustom getById(HttpSession session, Integer id) throws Exception {
		Mood mood = moodMapper.selectByPrimaryKey(id);

		MoodCustom moodCustom = BeanMapper.map(mood, MoodCustom.class);
		
//		MoodCustom moodCustom = new MoodCustom();
//		BeanUtils.copyProperties(mood, moodCustom);
		
		//普通的数据，直接给你返回
		if (moodCustom.getStatus() != StatusEnum.DELETE && moodCustom.getIsSecret() == SecretEnum.NORMAL) {
			return moodCustom;
		}else {
			User manager = getSessionManager(session);
			if (manager == null) {//不是管理员
				return null;
			}else {//管理员
				return moodCustom;
			}
		}
		
	}

	@Override
	public List<MoodCustom> list(HttpSession session) throws Exception {
		MoodExample example = new MoodExample();
		
		if (getSessionManager(session) == null) {//不是管理员
			//状态是非删除的，加密是不加密的（正常的）
			example.createCriteria().andStatusNotEqualTo(StatusEnum.DELETE).andIsSecretEqualTo(SecretEnum.NORMAL);
		}
		example.setOrderByClause("topTime desc, createTime desc");
		List<Mood> moodList = moodMapper.selectByExample(example);

		List<MoodCustom> moodCustoms = BeanMapper.mapList(moodList, MoodCustom.class);
		
		/** 判断并且修改是否置顶 */
		for (MoodCustom moodCustom : moodCustoms) {
			
			if (DateUtil.isNewDate(moodCustom.getTopTime())){
				moodCustom.setIsTop(true);
			}
		}
		
		/*List<MoodCustom> moodCustoms = new ArrayList<MoodCustom>();
		for (int i = 0; i < moodList.size(); i++) {
			MoodCustom moodCustom = new MoodCustom();
			BeanUtils.copyProperties(moodList.get(i), moodCustom);
			moodCustoms.add(moodCustom);
		}*/
		
		return moodCustoms;
	}

	@Override
	public void save(Mood mood) throws Exception {
		
		if (mood.getId() == null) {
			// 新增
			mood.setCreateTime(new Date());
			mood.setIsSecret(SecretEnum.NORMAL);
			mood.setStatus(StatusEnum.NORMAL);
			/*mood.setReplyCount(0);
			mood.setSeeCount(0);*/
			
			mood.setTopTime(DateUtil.getOldDate());
			
			moodMapper.insert(mood);
		} else {
			// 修改
			moodMapper.updateByPrimaryKeySelective(mood);
		}
		
	}

	/** 设置或修改加密 */
	@Override
	public void encryption(Integer id, Integer secretCode) throws Exception {
//		Mood mood = moodMapper.selectByPrimaryKey(id);
		Mood mood = new Mood();
		mood.setId(id);
		mood.setIsSecret(secretCode);
		moodMapper.updateByPrimaryKeySelective(mood);
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		moodMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void setStatus(Integer id, Integer statusCode) throws Exception {
		Mood mood = new Mood();
		mood.setId(id);
//		mood.setStatus(StatusEnum.ELITE);
		mood.setStatus(statusCode);

		moodMapper.updateByPrimaryKeySelective(mood);
		
	}

	private void changeTop(Integer id, Date date) throws Exception {
		Mood mood = new Mood();
		mood.setId(id);
//		mood.setStatus(StatusEnum.TOP);
		mood.setTopTime(date);
		
		moodMapper.updateByPrimaryKeySelective(mood);
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
		Mood mood = moodMapper.selectByPrimaryKey(id);
//		Mood mood = new Mood();
//		mood.setId(id);
		mood.setSeeCount(Counter.plus1(mood.getSeeCount()));
		
		moodMapper.updateByPrimaryKeySelective(mood);
	}

	
	@Override
	public List<MoodCustom> getListFront(HttpSession session, Integer front) throws Exception {
		MoodQueryVo qVo = new MoodQueryVo();
		
		if (getSessionManager(session) == null) {
			MoodCustom poCustom = new MoodCustom();
			poCustom.setStatus(StatusEnum.DELETE);
			poCustom.setIsSecret(SecretEnum.NORMAL);
//			qVo.setLogCustom(moodCustom);
			qVo.setPoCustom(poCustom);
		}
		
		PagingBean pagingBean = new PagingBean();
		pagingBean.setLimitFront(front);
		
		qVo.setPagingBean(pagingBean);
		
		return moodMapper.getListFront(qVo);
	}
}
