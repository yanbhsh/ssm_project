package com.yanbh.ssm.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sun.corba.se.impl.io.OptionalDataException;

class Teacher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2810682402866351208L;
	
	String name;
	int age;

	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3388849693842949765L;
	
	String name;// 常量对象
	int age;
	Teacher t;// 学生1和学生2的引用值都是一样的。

	public Student(String name, int age, Teacher t) {
		this.name = name;
		this.age = age;
		this.t = t;
	}

	public Object deepClone() throws Exception {// 将对象写到流里
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);// 从流里读出来
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}

	public static void main(String[] args) {
		try {
			Teacher t = new Teacher("tangliang", 30);
			Student s1 = new Student("zhangsan", 18, t);
			Student s2 = (Student) s1.deepClone();
			s2.t.name = "tony";
			s2.t.age = 40;
			// 学生1的老师不改变
			System.out.println("name=" + s1.t.name + "," + "age=" + s1.t.age);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}