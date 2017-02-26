package com.kuangren.mapper.work.show;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuangren.po.works.Works;
import com.kuangren.po.works.WorksExample;

public interface WorksMapper {
    int countByExample(WorksExample example);

    int deleteByExample(WorksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Works record);

    int insertSelective(Works record);

    List<Works> selectByExampleWithBLOBs(WorksExample example);

    List<Works> selectByExample(WorksExample example);

    Works selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Works record, @Param("example") WorksExample example);

    int updateByExampleWithBLOBs(@Param("record") Works record, @Param("example") WorksExample example);

    int updateByExample(@Param("record") Works record, @Param("example") WorksExample example);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKeyWithBLOBs(Works record);

    int updateByPrimaryKey(Works record);
}