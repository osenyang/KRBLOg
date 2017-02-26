package com.kuangren.mapper.work.resume;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuangren.po.resume.Resume;
import com.kuangren.po.resume.ResumeExample;
import com.kuangren.po.resume.ResumeWithBLOBs;

public interface ResumeMapper {
    int countByExample(ResumeExample example);

    int deleteByExample(ResumeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResumeWithBLOBs record);

    int insertSelective(ResumeWithBLOBs record);

    List<ResumeWithBLOBs> selectByExampleWithBLOBs(ResumeExample example);

    List<Resume> selectByExample(ResumeExample example);

    ResumeWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResumeWithBLOBs record, @Param("example") ResumeExample example);

    int updateByExampleWithBLOBs(@Param("record") ResumeWithBLOBs record, @Param("example") ResumeExample example);

    int updateByExample(@Param("record") Resume record, @Param("example") ResumeExample example);

    int updateByPrimaryKeySelective(ResumeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ResumeWithBLOBs record);

    int updateByPrimaryKey(Resume record);
}