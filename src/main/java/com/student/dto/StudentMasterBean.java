package com.student.dto;

public class StudentMasterBean
{
	private StudentInfoBean student_info_bean=new StudentInfoBean();
	private StudentAddressInfoBean student_add_info_bean=new StudentAddressInfoBean();
	private GuardianInfoBean guardian_info_bean= new GuardianInfoBean();
	public StudentInfoBean getStudent_info_bean() {
		return student_info_bean;
	}
	public void setStudent_info_bean(StudentInfoBean student_info_bean) {
		this.student_info_bean = student_info_bean;
	}
	public StudentAddressInfoBean getStudent_add_info_bean() {
		return student_add_info_bean;
	}
	public void setStudent_add_info_bean(StudentAddressInfoBean student_add_info_bean) {
		this.student_add_info_bean = student_add_info_bean;
	}
	public GuardianInfoBean getGuardian_info_bean() {
		return guardian_info_bean;
	}
	public void setGuardian_info_bean(GuardianInfoBean guardian_info_bean) {
		this.guardian_info_bean = guardian_info_bean;
	}
	

}
