package com.teamsankhya.webapp.test;

// WAP to do the test operations using jwebunit
import org.junit.Test;

import junit.framework.TestCase;
import net.sourceforge.jwebunit.WebTester;

public class TestCases extends TestCase {

	private WebTester tester = new WebTester();
	private static final String BASE_URL = "http://localhost:8080/StudentDb/";

	@Override
	protected void setUp() throws Exception {

		tester.getTestContext().setBaseUrl(BASE_URL);
		// TODO Auto-generated method stub
		super.setUp();
	} 

	@Test
	public void testCase() {
		tester.beginAt("CreateStudentForm.jsp");
		// http://localhost:8080/StudentDb/CreateStudentForm.jsp

		tester.assertFormPresent();
		tester.setFormElement("regno", "12");
		tester.setFormElement("firstname", "Jake");
		tester.setFormElement("middlename", "Allen");
		tester.setFormElement("lastname", "Titus");
		tester.setFormElement("addtype", "Permanent");
		tester.setFormElement("address1", "123");
		tester.setFormElement("address2", "street2");
		tester.setFormElement("city", "san francisco");
		tester.setFormElement("pincode", "675876");
		tester.setFormElement("guardian_firstname", "Tom");
		tester.setFormElement("guardian_middlename", "Henry");
		tester.setFormElement("guardian_lastname", "Titus");

		tester.submit();

		tester.assertTextPresent("Student data inserted");

		tester.clickLinkWithText("Click here for homepage");

	}
	
	@Test
	public void deleteTestCase()
	{
		//call delete.jsp
		//
	}
}
