package com.yanbh.ssm.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yanbh.ssm.entity.StudentInfo;
import com.yanbh.ssm.service.StudentInfoService;

@Controller
public class StudentInfoController extends BaseController {

	@Resource
	private StudentInfoService studentInfoService;

	@RequestMapping("/stuinfo.htm")
	public String getStuById(HttpServletRequest request, Model model) {

		String stuId = request.getParameter("stuId");
		StudentInfo stu = studentInfoService.getStuById(stuId);
		model.addAttribute("stu", stu);
		return "stulist";
	}

	@RequestMapping("/savestuinfo.htm")
	public String saveStuById(HttpServletRequest request, Model model) {

		StudentInfo stu = new StudentInfo();
		stu.setStudentId("ybh2");
		stu.setStudentName("ybh2");
		stu.setStudentSex("b2");
		stu.setStudentBirthday(new Date());
		stu.setClassId("no3");
		studentInfoService.saveStuInfo(stu);
		model.addAttribute("stu", stu);
		return "stulist";
	}
	
	@RequestMapping("/opCookie.htm")
	public String opCookie(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
		for(Cookie cookie : cookies){
		    cookie.getName();  // get the cookie name
		    cookie.getValue(); // get the cookie value
		}
		
		Cookie cookie = new Cookie("age","21");
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
		return "stulist";
	}
	
	

}
