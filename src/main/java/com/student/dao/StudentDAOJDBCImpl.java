package com.student.dao;
//MODULE
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.student.dto.GuardianInfoBean;
import com.student.dto.StudentAddressInfoBean;
import com.student.dto.StudentInfoBean;
import com.student.dto.StudentMasterBean;

public class StudentDAOJDBCImpl implements StudentDAO 
{
	@Override
	public void createStudent(StudentMasterBean bean)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_ex1?user=root&password=root");
					PreparedStatement pstmt1 = con.prepareStatement("insert into student_info values(?,?,?,?)");
					PreparedStatement pstmt2 = con.prepareStatement("insert into student_address_info values(?,?,?,?,?,?)");
					PreparedStatement pstmt3 = con.prepareStatement("insert into guardian_info values(?,?,?,?)");){
				
				System.out.println("connection done");
				pstmt1.setInt(1, bean.getStudent_info_bean().getRegno());
				pstmt1.setString(2,bean.getStudent_info_bean().getFnm());
				pstmt1.setString(3,bean.getStudent_info_bean().getMnm());
				pstmt1.setString(4,bean.getStudent_info_bean().getLnm());
				System.out.println("setting values1 done");
				
				pstmt2.setInt(1, bean.getStudent_add_info_bean().getRegno());
				pstmt2.setString(2, bean.getStudent_add_info_bean().getAdd_type());
				pstmt2.setString(3, bean.getStudent_add_info_bean().getAdd1());
				pstmt2.setString(4, bean.getStudent_add_info_bean().getAdd2());
				pstmt2.setString(5, bean.getStudent_add_info_bean().getCity());
				pstmt2.setInt(6, bean.getStudent_add_info_bean().getPin());
				System.out.println("setting values2 done");	
				
				pstmt3.setInt(1, bean.getGuardian_info_bean().getRegno());
				pstmt3.setString(2,bean.getGuardian_info_bean().getGfnm());
				pstmt3.setString(3,bean.getGuardian_info_bean().getGmnm());
				pstmt3.setString(4,bean.getGuardian_info_bean().getGlnm());
				System.out.println("setting values3 done");
				
				pstmt1.execute();
				pstmt2.execute();
				pstmt3.execute();
				System.out.println("query execution done");
				}
			}
		catch (Exception e) {
			// TODO: handle exception
		}
	}//end of create method..NOT WORKING


	

	@Override
	public StudentMasterBean readStudent(int regno) {
		
		StudentMasterBean bean = new StudentMasterBean();
		StudentInfoBean student_info=new StudentInfoBean();
		StudentAddressInfoBean student_add_info=new StudentAddressInfoBean();
		GuardianInfoBean guardian_info= new GuardianInfoBean(); 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_ex1?user=root&password=root")) {
				try (PreparedStatement pstmt1 = con.prepareStatement("select * from student_info where regno=?");
						PreparedStatement pstmt2 = con.prepareStatement("select * from guardian_info where regno=?");
						PreparedStatement pstmt3 = con.prepareStatement("select * from student_address_info where regno=?"))

				{
					pstmt1.setInt(1, regno);

					try (ResultSet rs1 = pstmt1.executeQuery()) {
						if (rs1.next()) {
							System.out.println("student found");
							student_info.setRegno(rs1.getInt("regno"));
							student_info.setFnm(rs1.getString("firstname"));
							student_info.setMnm(rs1.getString("middlename"));;
							student_info.setLnm(rs1.getString("lastname"));
							

						}

					}
					pstmt2.setInt(1,regno);
					try (ResultSet rs2 = pstmt2.executeQuery()) {
						if (rs2.next()) {
							guardian_info.setRegno(rs2.getInt("regno"));
							guardian_info.setGfnm(rs2.getString("guardian_firstname"));
							guardian_info.setGfnm(rs2.getString("guardian_middlename"));
							guardian_info.setGlnm(rs2.getString("guardian_lastname"));

						}

					}

					pstmt3.setInt(1, regno);
					try (ResultSet rs3 = pstmt3.executeQuery()) {
						if (rs3.next()) {
							student_add_info.setRegno(rs3.getInt("regno"));
							student_add_info.setAdd1(rs3.getString("addtype"));
							student_add_info.setAdd1(rs3.getString("address1"));
							student_add_info.setAdd2(rs3.getString("address2"));
							student_add_info.setCity(rs3.getString("city"));
							student_add_info.setPin(rs3.getInt("pincode"));

						}
					}
					
					bean.setStudent_info_bean(student_info);
					bean.setStudent_add_info_bean(student_add_info);
					bean.setGuardian_info_bean(guardian_info);

				}

			}
	} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}//end of readStudent() method...WORKING

	@Override
	public void deleteStudent(int regnum) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_ex1?user=root&password=root")) {
				con.setAutoCommit(false);
				
				try (PreparedStatement pstmt1 = con.prepareStatement("delete from student_info where regno=?  ");
					 PreparedStatement pstmt2 = con.prepareStatement("delete from guardian_info where regno=? ");
					 PreparedStatement pstmt3 = con.prepareStatement("delete from student_address_info where regno=? ");) {

					pstmt1.setInt(1, regnum);
					pstmt2.setInt(1, regnum);
					pstmt3.setInt(1, regnum);
					int count1 = pstmt1.executeUpdate();
					int count2 = pstmt2.executeUpdate();
					int count3 = pstmt3.executeUpdate();
//					System.out.println(count1);
//					System.out.println(count2);
//					System.out.println(count3);
					con.commit();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}//end of delete method...WORKING
	

	@Override
	public void updateStudentData(int regnum, String name) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded");
			try (Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_ex1?user=root&password=root")) {
				con.setAutoCommit(false);
				System.out.println("connection done");
				try (PreparedStatement pstmt = con.prepareStatement("update student_info set firstname=? where regno=?");) {
					pstmt.setString(1, name);
					pstmt.setInt(2, regnum);
					int count = pstmt.executeUpdate();
					System.out.println(count);
					if(count!=0)
					System.out.println("data updated");
					
					con.commit();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}//end of update method...WORKING

	
	
}	//end of class