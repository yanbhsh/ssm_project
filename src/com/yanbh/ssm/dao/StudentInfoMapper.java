package com.yanbh.ssm.dao;

import java.util.List;

import com.yanbh.ssm.entity.StudentInfo;

public interface StudentInfoMapper {
	
    int deleteByPrimaryKey(String studentId);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(String studentId);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
    
    List<StudentInfo> selectStuList();
}