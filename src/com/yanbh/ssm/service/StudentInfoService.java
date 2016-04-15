package com.yanbh.ssm.service;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yanbh.ssm.dao.StudentInfoMapper;
import com.yanbh.ssm.dao.UserInfoMapper;
import com.yanbh.ssm.entity.StudentInfo;

@Service("studentInfoService")
@Transactional
public class StudentInfoService {

	@Resource
	private StudentInfoMapper studentInfoMapper;
	
	@Resource
	private UserInfoMapper userInfoMapper;
	
	public StudentInfo getStuById(String studentId){
		
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

	public int saveStuInfo(StudentInfo record){
		
		return studentInfoMapper.insert(record);
	}
	
	public List<StudentInfo> selectStuInfoList(){
		
		return studentInfoMapper.selectStuList();
	}
}
