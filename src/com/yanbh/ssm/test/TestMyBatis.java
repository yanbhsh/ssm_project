package com.yanbh.ssm.test;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yanbh.ssm.entity.StudentInfo;
import com.yanbh.ssm.service.StudentInfoService;
import com.yanbh.ssm.util.ResultBuilder;
import com.yanbh.ssm.util.ResultType;


@RunWith(SpringJUnit4ClassRunner.class)     
@ContextConfiguration(locations={"file:WebContent/WEB-INF/spring-servlet.xml"}) 
public class TestMyBatis extends AbstractJUnit4SpringContextTests{

	private static Logger logger = Logger.getLogger(TestMyBatis.class);

	@Autowired
	StudentInfoService studentInfoService;

	@Test
	public void test1() {
		String stuId="ybh1";
		logger.info("入参："+stuId);
		
		//封装对象的json方式，调用方获取方式
		StudentInfo user = studentInfoService.getStuById(stuId);
		logger.info("出参："+(user!=null?user.getStudentName():null));
		Map<String, Object> result=new ResultBuilder(ResultType.SUCCESS).putJson( "user", user).toMap();
		StudentInfo stu=JSONObject.toJavaObject((JSON)result.get("user"), StudentInfo.class);
		//封装list的json方式，调用方获取方式
		List<StudentInfo> list=studentInfoService.selectStuInfoList();
		result=new ResultBuilder(ResultType.SUCCESS).putJson("list", list).toMap();
		JSONArray listArray = (JSONArray)result.get("list");
		if(listArray != null) {
            for(int i = 0; i< listArray.size(); i++) {
                JSONObject o = (JSONObject)listArray.get(i);
                stu = JSONObject.toJavaObject(o, StudentInfo.class);
                System.out.println(stu.getClassId());
            }
        }
	}
	
	
}
