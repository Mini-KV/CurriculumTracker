package org.ictkerala.testcases;

import java.io.IOException;

import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.LoginPage;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*
 * @author Mini
 */
public class LoginPageTest extends TestBase {
	LoginPage objLogin;
	
	@BeforeMethod
	public void intitMethod() {
		objLogin = new LoginPage(driver,wait);
	}

	//verify admin login with valid email and valid password
	@Test(priority=1,description="admin valid login")
	public void admValidLogin() throws IOException {
		String email = ExcelUtility.readExcel(1,0,"AdminLogin");
		String password = ExcelUtility.readExcel(1,1,"AdminLogin");
		objLogin.clickLogintBtn();
		objLogin.clickSubmitBtn(email,password);
		Assert.assertTrue(objLogin.loginMsg.getText().contains(AutomationConstants.LOGIN_SUCCESS_MSG));
	}
	
	//verify admin login with valid email and invalid password
	@Test(priority=2,description="admin valid email/invalid password")
	public void admValEmailInvalPass() throws IOException {
		String email =ExcelUtility.readExcel(2,0,"AdminLogin");
		String password =ExcelUtility.readExcel(2,1,"AdminLogin");
		objLogin.clickLogintBtn();
		objLogin.clickSubmitBtn(email,password);
		Assert.assertTrue(objLogin.loginMsg.getText().contains(AutomationConstants.LOGIN_FAILURE_MSG));
	}
		
	//verify admin logout
	@Test(priority=3,description="admin logout")	
	public void admLogout() throws IOException {	
		String email =ExcelUtility.readExcel(1,0,"AdminLogin");
		String password =ExcelUtility.readExcel(1,1,"AdminLogin");
		objLogin.clickLogintBtn();
		objLogin.clickSubmitBtn(email,password);
		objLogin.clickLogoutBtn();
	}

	//verify faculty login with valid email and valid password
	@Test(priority=4,description="faculty valid login")
	public void facValidLogin() throws IOException {
		String email = ExcelUtility.readExcel(1,0,"FacultyLogin");
		String password = ExcelUtility.readExcel(1,1,"FacultyLogin");
		objLogin.clickLogintBtn();
		objLogin.clickSubmitBtn(email,password);
		Assert.assertTrue(objLogin.loginMsg.getText().contains(AutomationConstants.LOGIN_SUCCESS_MSG));
	}
		
	//verify faculty login with valid email and invalid password
	@Test(priority=5,description="faculty valid email/invalid password")
	public void facValEmailInvalPass() throws IOException {
		String email =ExcelUtility.readExcel(2,0,"FacultyLogin");
		String password =ExcelUtility.readExcel(2,1,"FacultyLogin");
		objLogin.clickLogintBtn();
		objLogin.clickSubmitBtn(email,password);
		Assert.assertTrue(objLogin.loginMsg.getText().contains(AutomationConstants.LOGIN_FAILURE_MSG));
	}
			
	//verify faculty logout
	@Test(priority=6,description="faculty logout")	
	public void facLogout() throws IOException {	
		String email =ExcelUtility.readExcel(1,0,"FacultyLogin");
		String password =ExcelUtility.readExcel(1,1,"FacultyLogin");
		objLogin.clickLogintBtn();
		objLogin.clickSubmitBtn(email,password);
		objLogin.clickLogoutBtn();
	}
}
