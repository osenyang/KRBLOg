package com.kuangren.service.social.circle;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kuangren.po.photo.Photo;
import com.kuangren.po.photo.PhotoCustom;
import com.kuangren.po.photo.PhotoExample;

public interface PhotoService {
	/** 查询最新图片，前面多少条记录 */
	//TODO 判断是否管理员。如果不是，那么判断，如果关联的相册不是公开的，那么照片就取出带条件的
//	public List<PhotoCustom> getListFront(Integer front) throws Exception;
	public List<PhotoCustom> getListFront(HttpSession session, Integer front) throws Exception;
	
	/** 根据相册id 找到所属的图片列表 */
	public List<PhotoCustom> getImgsById(Integer albumId) throws Exception;

	public PhotoCustom getById(Integer id) throws Exception;
	
	public List<PhotoCustom> list(PhotoExample example) throws Exception;

	/** 新增或者修改 */
	public void save(Photo photo) throws Exception;

	public void delete(Integer id) throws Exception;


}
