package com.student.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.util.StudentServiceManager;


public class UpdateStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int regnum = Integer.parseInt(req.getParameter("regno"));
		String name = req.getParameter("firstname");
		
		StudentDAO dao = StudentServiceManager
				.getInstence()
				.daoGenarater();
		System.out.println("calling update method");
		dao.updateStudentData(regnum, name);
		System.out.println("data updated");
		
		System.out.println("sending response");
		
		req.getRequestDispatcher("UpdateStudentResponse.jsp").forward(req, resp);
		System.out.println("response done");
		
		
	}

}

