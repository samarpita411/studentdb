package com.student.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.dao.StudentDAO;
import com.student.util.StudentServiceManager;


public class DeleteStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int regnum = Integer.parseInt(req.getParameter("regno"));
		
		
		StudentDAO dao = StudentServiceManager
				.getInstence()
				.daoGenarater();
		dao.deleteStudent(regnum);
		System.out.println("data deleted");
		
		System.out.println("sending the response now");
		
		req.getRequestDispatcher("DeleteStudentResponse.jsp").forward(req, resp);
		System.out.println("response done");
	}

}
