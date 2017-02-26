package com.kuangren.service.social.circle.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuangren.enumerate.StatusEnum;
import com.kuangren.enumerate.TypeEnum;
import com.kuangren.mapper.social.circle.PhotoMapper;
import com.kuangren.po.PagingBean;
import com.kuangren.po.photo.Photo;
import com.kuangren.po.photo.PhotoCustom;
import com.kuangren.po.photo.PhotoExample;
import com.kuangren.po.photo.PhotoExample.Criteria;
import com.kuangren.service.impl.BaseServiceImpl;
import com.kuangren.service.social.circle.PhotoService;
import com.kuangren.po.photo.PhotoQueryVo;
import com.kuangren.util.BeanMapper;
@Service
public class PhotoServiceImpl extends BaseServiceImpl implements PhotoService {

	@Autowired
	private PhotoMapper photoMapper;
	
	@Override
	public List<PhotoCustom> getImgsById(Integer albumId) throws Exception {
		PhotoExample example = new PhotoExample();
		Criteria criteria = example.createCriteria();// 为何创建出来一个criteria 就帮你add进去
		criteria.andParent_idEqualTo(albumId);
		
		List<Photo> photoList = photoMapper.selectByExample(example);
		
		return BeanMapper.mapList(photoList, PhotoCustom.class);
	}
	
	@Override
	public PhotoCustom getById(Integer id) throws Exception {
		Photo photo = photoMapper.selectByPrimaryKey(id);

		PhotoCustom photoCustom = BeanMapper.map(photo, PhotoCustom.class);
		
		return photoCustom;
	}

	@Override
	public List<PhotoCustom> list(PhotoExample example) throws Exception {
		List<Photo> photoList = photoMapper.selectByExample(example);

		List<PhotoCustom> photoCustoms = BeanMapper.mapList(photoList, PhotoCustom.class);
		
		return photoCustoms;
	}

	@Override
	public void save(Photo photo) throws Exception {
		
		if (photo.getId() == null) {
			// 新增
			photo.setCreateTime(new Date());
			photo.setStatus(StatusEnum.NORMAL);
			
			if (photo.getMark() == null || "".equals(photo.getMark())) {
				photo.setMark(TypeEnum.ALBUM);
			}
			
			photoMapper.insert(photo);
		} else {
			// 修改
			photoMapper.updateByPrimaryKeySelective(photo);
		}
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		photoMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<PhotoCustom> getListFront(HttpSession session, Integer front) throws Exception {
		PhotoQueryVo qVo = new PhotoQueryVo();
		
		if (getSessionManager(session) == null) {
			PhotoCustom poCustom = new PhotoCustom();
			poCustom.setIsConfine(true);
			qVo.setPoCustom(poCustom);
		}
		
		PagingBean pagingBean = new PagingBean();
		pagingBean.setLimitFront(front);
		
		qVo.setPagingBean(pagingBean);
		
		return photoMapper.getListFront(qVo);
	}

	
}
