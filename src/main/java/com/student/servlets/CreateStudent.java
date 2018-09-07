package com.student.servlets;

//CONTROLLER
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.dto.GuardianInfoBean;
import com.student.dto.StudentAddressInfoBean;
import com.student.dto.StudentInfoBean;
import com.student.dto.StudentMasterBean;
import com.student.util.StudentServiceManager;

//@WebServlet("/createstudent")
public class CreateStudent extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StudentInfoBean student_info = new StudentInfoBean();
		student_info.setRegno(Integer.parseInt(req.getParameter("regno")));
		student_info.setFnm(req.getParameter("firstname"));
		student_info.setMnm(req.getParameter("middlename"));
		student_info.setLnm(req.getParameter("lastname"));

		StudentAddressInfoBean student_address = new StudentAddressInfoBean();
		student_address.setRegno(Integer.parseInt(req.getParameter("regno")));
		student_address.setAdd_type(req.getParameter("addtype"));
		student_address.setAdd1(req.getParameter("address1"));
		student_address.setAdd2(req.getParameter("address2"));
		student_address.setCity(req.getParameter("city"));
		student_address.setPin(Integer.parseInt(req.getParameter("pincode")));

		GuardianInfoBean guardian_info = new GuardianInfoBean();
		guardian_info.setRegno(Integer.parseInt(req.getParameter("regno")));
		guardian_info.setGfnm(req.getParameter("guardian_firstname"));
		guardian_info.setGmnm(req.getParameter("guardian_middlename"));
		guardian_info.setGlnm(req.getParameter("guardian_lastname"));

		StudentMasterBean student_master = new StudentMasterBean();
		student_master.setStudent_info_bean(student_info);
		student_master.setStudent_add_info_bean(student_address);
		student_master.setGuardian_info_bean(guardian_info);

		StudentDAO dao = StudentServiceManager.getInstence().daoGenarater();
		System.out.println("calling create method");
		dao.createStudent(student_master);
		System.out.println("create method called");
		
		req.getRequestDispatcher("CreateStudentResponse.jsp").forward(req, resp);

	}

}
