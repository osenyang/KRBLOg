package com.kuangren.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuangren.po.statistics.Statistics;
import com.kuangren.po.statistics.StatisticsExample;

public interface StatisticsMapper {
    int countByExample(StatisticsExample example);

    int deleteByExample(StatisticsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Statistics record);

    int insertSelective(Statistics record);

    List<Statistics> selectByExample(StatisticsExample example);

    Statistics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Statistics record, @Param("example") StatisticsExample example);

    int updateByExample(@Param("record") Statistics record, @Param("example") StatisticsExample example);

    int updateByPrimaryKeySelective(Statistics record);

    int updateByPrimaryKey(Statistics record);
}