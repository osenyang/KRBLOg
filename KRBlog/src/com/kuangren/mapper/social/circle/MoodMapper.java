package com.kuangren.mapper.social.circle;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuangren.po.mood.Mood;
import com.kuangren.po.mood.MoodCustom;
import com.kuangren.po.mood.MoodExample;
import com.kuangren.po.mood.MoodQueryVo;

public interface MoodMapper {
	
	public List<MoodCustom> getListFront(MoodQueryVo qVo) throws Exception;
	
    int countByExample(MoodExample example);

    int deleteByExample(MoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mood record);

    int insertSelective(Mood record);

    List<Mood> selectByExample(MoodExample example);

    Mood selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mood record, @Param("example") MoodExample example);

    int updateByExample(@Param("record") Mood record, @Param("example") MoodExample example);

    int updateByPrimaryKeySelective(Mood record);

    int updateByPrimaryKey(Mood record);
}