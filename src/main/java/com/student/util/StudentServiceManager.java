package com.student.util;
//fACTORY DESIGN PATTERN

import java.io.FileReader;
import java.util.Properties;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOJDBCImpl;

public class StudentServiceManager 
{
	private StudentServiceManager() {}
	private static final StudentServiceManager STUDENT_SERVICE_MANAGER = new StudentServiceManager();
	public static StudentServiceManager getInstence() {
		return STUDENT_SERVICE_MANAGER;
	}
		public StudentDAO daoGenarater() {
//		Properties properties = new Properties();
//		String path = getClass().getResource("/student-config.properties").getPath();
//		try {
//			FileReader fileReader = new FileReader(path);
//			properties.load(fileReader);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
		StudentDAO dao =null;
		
//		StudentDAO dao = (StudentDAO)new StudentDAOJDBCImpl();
		
		try {
			dao = (StudentDAO)Class
					.forName("com.student.dao.StudentDAOJDBCImpl")
					.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

}
