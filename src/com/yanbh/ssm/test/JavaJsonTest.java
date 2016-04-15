package com.yanbh.ssm.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.yanbh.ssm.entity.StudentInfo;
import com.yanbh.ssm.util.Response;

public class JavaJsonTest {

	/**
	 * 默认返回{status:success}
	 * 
	 * @param response
	 */
	public static void printSuccess(HttpServletResponse response) {
		Response bean = new Response();
		bean.setStatus("success");
		printf(bean, response);
	}

	public static void printf(Response bean, HttpServletResponse response) {
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "must-revalidate");
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		PrintWriter out = null;

		try {
			out = response.getWriter();
			out.print(JavaJsonTest.bean2Json(bean));
		} catch (IOException e) {
		} finally {
			if (null != out)
				out.close();
		}
	}

	/***
	 * 将Java对象转换成 json字符串
	 * @param bean
	 * @return
	 */
	public static String bean2Json(Object bean) {
		JSONObject jsonobj = JSONObject.fromObject(bean);
		String jsonStr = jsonobj.toString();
		return jsonStr;
	}

	/***
	 * 将Java 集合转换成 json字符串
	 * @param list
	 * @return
	 */
	public static String listToJson(List<?> list) {
		//方法一：
		String jsonstr=null;
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(bean2Json(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		jsonstr=json.toString();
		//方法二：
		JSONArray array = JSONArray.fromObject(list);
	    jsonstr = array.toString();
	    return jsonstr;
	}

	/***
	 * 将json字符串转换成动态Java对象
	 * @param jsonStr
	 */
	private static void jsonToBean(String jsonStr) {
		//方法一：
		JSONArray ja = JSONArray.fromObject(jsonStr);
		for (int i = 0; i < ja.size(); i++) {
			JSONObject jo = ja.getJSONObject(i); // 转换成JSONObject对象
			StudentInfo p = (StudentInfo) JSONObject.toBean(jo, StudentInfo.class); // 转换成JavaBean
			System.out.println(p.getStudentId());
		}
		//方法二：
		JSONArray json = JSONArray.fromObject(jsonStr);
		List<StudentInfo> persons = (List<StudentInfo>)JSONArray.toCollection(json, StudentInfo.class);
		
	}

	private static JSONObject createJSONObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "kevin");
		jsonObject.put("Max.score", new Integer(100));
		jsonObject.put("Min.score", new Integer(50));
		jsonObject.put("nickname", "picglet");
		return jsonObject;
	}

	private static void testJSONObject() {
		JSONObject jsonObject = createJSONObject();
		// 输出jsonobject对象
		System.out.println("jsonObject==>" + jsonObject);
		// 判读输出对象的类型
		boolean isArray = jsonObject.isArray();
		boolean isEmpty = jsonObject.isEmpty();
		boolean isNullObject = jsonObject.isNullObject();
		System.out.println("isArray:" + isArray + " isEmpty:" + isEmpty
				+ " isNullObject:" + isNullObject);
		// 添加属性
		jsonObject.element("address", "swap lake");
		System.out.println("添加属性后的对象==>" + jsonObject);
		// 返回一个JSONArray对象
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(0, "this is a jsonArray value");
		jsonArray.add(1, "another jsonArray value");
		jsonObject.element("jsonArray", jsonArray);
		JSONArray array = jsonObject.getJSONArray("jsonArray");
		System.out.println("返回一个JSONArray对象：" + array);
		// 添加JSONArray后的值
		// {"name":"kevin","Max.score":100,"Min.score":50,"nickname":"picglet","address":"swap lake",
		// "jsonArray":["this is a jsonArray value","another jsonArray value"]}
		System.out.println(jsonObject);
		// 根据key返回一个字符串
		String jsonString = jsonObject.getString("name");
		System.out.println("jsonString==>" + jsonString);
	}

	public static void main(String[] args) {
		testJSONObject();
		String jsonStr = "[{\"studentId\":\"A2\",\"studentName\":23},{\"studentId\":\"A1\",\"studentName\":26}]";
		jsonToBean(jsonStr);
	}

}
