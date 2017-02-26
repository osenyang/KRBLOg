package com.kuangren.mapper.social.blog;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuangren.po.log.Log;
import com.kuangren.po.log.LogCustom;
import com.kuangren.po.log.LogExample;
import com.kuangren.po.log.LogQueryVo;

public interface LogMapper {
	//public List<LogCustom> getListFrontCondition(LogQueryVo qVo) throws Exception;// 非管理员，带条件的
	
	public List<LogCustom> getListFront(LogQueryVo qVo) throws Exception;
	
    int countByExample(LogExample example);

    int deleteByExample(LogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExampleWithBLOBs(LogExample example);

    List<Log> selectByExample(LogExample example);

    Log selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    int updateByExampleWithBLOBs(@Param("record") Log record, @Param("example") LogExample example);

    int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKeyWithBLOBs(Log record);

    int updateByPrimaryKey(Log record);

}