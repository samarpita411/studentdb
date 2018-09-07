package com.student.dao;

import com.student.dto.StudentMasterBean;

public interface StudentDAO 
{
	public void createStudent(StudentMasterBean bean);
	public StudentMasterBean readStudent(int regno);
	public void deleteStudent(int regnum);
	public void  updateStudentData(int regnum,String name);
	
	
}
