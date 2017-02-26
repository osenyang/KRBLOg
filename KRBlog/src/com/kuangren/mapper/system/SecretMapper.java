package com.kuangren.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuangren.po.secret.Secret;
import com.kuangren.po.secret.SecretExample;

public interface SecretMapper {
    int countByExample(SecretExample example);

    int deleteByExample(SecretExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Secret record);

    int insertSelective(Secret record);

    List<Secret> selectByExample(SecretExample example);

    Secret selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Secret record, @Param("example") SecretExample example);

    int updateByExample(@Param("record") Secret record, @Param("example") SecretExample example);

    int updateByPrimaryKeySelective(Secret record);

    int updateByPrimaryKey(Secret record);
}