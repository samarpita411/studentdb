package com.student.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.dto.StudentMasterBean;
import com.student.util.StudentServiceManager;



public class ReadStudent extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int regnum = Integer.parseInt(req.getParameter("regno"));
		
		
		StudentDAO dao = StudentServiceManager
				.getInstence()
				.daoGenarater();
		StudentMasterBean bean = dao.readStudent(regnum);
		PrintWriter out = resp.getWriter();
		out.println("Regno : " + bean.getStudent_info_bean().getRegno());
		out.println("First Nname:   " + bean.getStudent_info_bean().getFnm());
		out.println("Middle Name  : " + bean.getStudent_info_bean().getMnm());
		out.println("Last Name : " + bean.getStudent_info_bean().getLnm());
		out.println("guardian First name : "+bean.getGuardian_info_bean().getGfnm());
		out.println("guardian middle name : "+bean.getGuardian_info_bean().getGmnm());
		out.println("guardian Last name : "+bean.getGuardian_info_bean().getGlnm());
		out.println("Adress Type :"+bean.getStudent_add_info_bean().getAdd_type());
		out.println("Adress  1 :"+ bean.getStudent_add_info_bean().getAdd1());
		out.println("Adress  2 :"+ bean.getStudent_add_info_bean().getAdd2());
		out.println("City :"+ bean.getStudent_add_info_bean().getCity());
		out.println("Pincode :"+ bean.getStudent_add_info_bean().getPin());
		
		
		
	}

}
