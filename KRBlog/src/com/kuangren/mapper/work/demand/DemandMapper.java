package com.kuangren.mapper.work.demand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuangren.po.demand.Demand;
import com.kuangren.po.demand.DemandExample;

public interface DemandMapper {
    int countByExample(DemandExample example);

    int deleteByExample(DemandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Demand record);

    int insertSelective(Demand record);

    List<Demand> selectByExampleWithBLOBs(DemandExample example);

    List<Demand> selectByExample(DemandExample example);

    Demand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Demand record, @Param("example") DemandExample example);

    int updateByExampleWithBLOBs(@Param("record") Demand record, @Param("example") DemandExample example);

    int updateByExample(@Param("record") Demand record, @Param("example") DemandExample example);

    int updateByPrimaryKeySelective(Demand record);

    int updateByPrimaryKeyWithBLOBs(Demand record);

    int updateByPrimaryKey(Demand record);
}