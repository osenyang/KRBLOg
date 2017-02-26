package com.kuangren.mapper.social.circle;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuangren.po.photo.Photo;
import com.kuangren.po.photo.PhotoCustom;
import com.kuangren.po.photo.PhotoExample;
import com.kuangren.po.photo.PhotoQueryVo;

public interface PhotoMapper {
	
	/** 查询照片前面多少条记录（排序：最新创建的照片）*/
	public List<PhotoCustom> getListFront(PhotoQueryVo qVo) throws Exception;
	
    int countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}