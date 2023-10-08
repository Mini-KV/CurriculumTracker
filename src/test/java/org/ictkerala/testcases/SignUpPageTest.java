package org.ictkerala.testcases;

import java.io.IOException;

import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.LoginPage;
import org.ictkerala.pages.SignUpPage;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*
 * @author Mini
 */
public class SignUpPageTest extends TestBase{
	
	SignUpPage objSignUp;
	LoginPage objLogin;
	
	@BeforeMethod
	public void intitMethod() {
		objSignUp = new SignUpPage(driver,wait);
		objLogin = new LoginPage(driver,wait);	
		objLogin.clickLogintBtn();
		objSignUp.clickNewAcctLink();
	}
	
	//verify faculty Create Account link redirects to correct page
	@Test(priority=1,description="verify faculty Create Account link")
	public void verifyCrtAcctNowLink() throws IOException {
		Assert.assertTrue(objSignUp.verifySignUpURL());
	}
	
	//create faculty account with valid data
	@Test(priority=2,description="create faculty account with valid data")
	public void validSignUpTest() throws IOException {
		objSignUp.setName(ExcelUtility.readExcel(1,0,"FacultySignUp"));
		objSignUp.setEmail(ExcelUtility.readExcel(1,1,"FacultySignUp"));
		objSignUp.setPhone(ExcelUtility.readExcel(1,2,"FacultySignUp"));
		objSignUp.setPassword(ExcelUtility.readExcel(1,3,"FacultySignUp"));
		objSignUp.setConfPassword(ExcelUtility.readExcel(1,4,"FacultySignUp"));
		objSignUp.clickSignUpBtn();
		Assert.assertTrue(objSignUp.signUpMsg.getText().contains(AutomationConstants.LOGIN_SUCCESS_MSG));
		objSignUp.clickOKBtn();
		
	}
	
	//verify if mandatory fields give error on blank
	@Test(priority=3,description="create faculty account with blank fields")
	public void blankFieldsTest() throws IOException {
		objSignUp.setName("");
		objSignUp.setEmail("");
		objSignUp.setPhone("");
		objSignUp.setPassword("");
		objSignUp.setConfPassword("");
		objSignUp.clickSignUpBtn();
		Assert.assertEquals(objSignUp.getNameError(), AutomationConstants.EXP_NAME_ERR);
		Assert.assertEquals(objSignUp.getPhoneNoError(), AutomationConstants.EXP_PH_ERR);
		Assert.assertEquals(objSignUp.getEmailError(), AutomationConstants.EXP_EMAIL_ERR);
		Assert.assertEquals(objSignUp.getPassError(), AutomationConstants.EXP_PASS_ERR);
		Assert.assertEquals(objSignUp.getConfPassEmptyError(), AutomationConstants.EXP_CONFPASS_EMPTY_ERR);
	}
	
	//verify error when name has non alphabets
	@Test(priority=4,description="user name has non alphabets")
	public void userNonAlph() throws IOException {
		objSignUp.setName(ExcelUtility.readExcel(2,0,"FacultySignUp"));
		objSignUp.setEmail(ExcelUtility.readExcel(2,1,"FacultySignUp"));
		objSignUp.setPhone(ExcelUtility.readExcel(2,2,"FacultySignUp"));
		objSignUp.setPassword(ExcelUtility.readExcel(2,3,"FacultySignUp"));
		objSignUp.setConfPassword(ExcelUtility.readExcel(2,4,"FacultySignUp"));
		objSignUp.clickSignUpBtn();
		Assert.assertEquals(objSignUp.getNameError(), AutomationConstants.EXP_NAME_ERR);
	}
	
	//verify error when email is not in correct format
	@Test(priority=5,description="email invalid")
	public void emailInvalidChar() throws IOException {
		objSignUp.setName(ExcelUtility.readExcel(3,0,"FacultySignUp"));
		objSignUp.setEmail(ExcelUtility.readExcel(3,1,"FacultySignUp"));
		objSignUp.setPhone(ExcelUtility.readExcel(3,2,"FacultySignUp"));
		objSignUp.setPassword(ExcelUtility.readExcel(3,3,"FacultySignUp"));
		objSignUp.setConfPassword(ExcelUtility.readExcel(3,4,"FacultySignUp"));
		objSignUp.clickSignUpBtn();
		Assert.assertEquals(objSignUp.getEmailError(), AutomationConstants.EXP_EMAIL_ERR);
	}	
	
	//verify error when phone number greater than 10 digits
	@Test(priority=6,description="phone number greater than 10 digits")
	public void phoneMoreThan10() throws IOException {
		objSignUp.setName(ExcelUtility.readExcel(3,0,"FacultySignUp"));
		objSignUp.setEmail(ExcelUtility.readExcel(3,1,"FacultySignUp"));
		objSignUp.setPhone(ExcelUtility.readExcel(3,2,"FacultySignUp"));
		objSignUp.setPassword(ExcelUtility.readExcel(3,3,"FacultySignUp"));
		objSignUp.setConfPassword(ExcelUtility.readExcel(3,4,"FacultySignUp"));
		objSignUp.clickSignUpBtn();
		Assert.assertEquals(objSignUp.getPhoneNoError(), AutomationConstants.EXP_PH_ERR);		
	}
		
	//verify error when phone number less than 10 digits
	@Test(priority=7,description="phone number less than 10 digits")
	public void phoneLessThan10() throws IOException {
		objSignUp.setName(ExcelUtility.readExcel(4,0,"FacultySignUp"));
		objSignUp.setEmail(ExcelUtility.readExcel(4,1,"FacultySignUp"));
		objSignUp.setPhone(ExcelUtility.readExcel(4,2,"FacultySignUp"));
		objSignUp.setPassword(ExcelUtility.readExcel(4,3,"FacultySignUp"));
		objSignUp.setConfPassword(ExcelUtility.readExcel(4,4,"FacultySignUp"));
		objSignUp.clickSignUpBtn();
		Assert.assertEquals(objSignUp.getPhoneNoError(), AutomationConstants.EXP_PH_ERR);	
	}	
	
	//verify error when phone number has invalid characters
	@Test(priority=8,description="phone number invalid characters")
	public void phoneNoInvalidChar() throws IOException {
		objSignUp.setName(ExcelUtility.readExcel(5,0,"FacultySignUp"));
		objSignUp.setEmail(ExcelUtility.readExcel(5,1,"FacultySignUp"));
		objSignUp.setPhone(ExcelUtility.readExcel(5,2,"FacultySignUp"));
		objSignUp.setPassword(ExcelUtility.readExcel(5,3,"FacultySignUp"));
		objSignUp.setConfPassword(ExcelUtility.readExcel(5,4,"FacultySignUp"));
		objSignUp.clickSignUpBtn();
		Assert.assertEquals(objSignUp.getPhoneNoError(), AutomationConstants.EXP_PH_ERR);	
	}	
				
	//verify error when password does meet specifications
	@Test(priority=8,description="password invalid")
	public void passLessThan6Char() throws IOException {
		objSignUp.setName(ExcelUtility.readExcel(6,0,"FacultySignUp"));
		objSignUp.setEmail(ExcelUtility.readExcel(6,1,"FacultySignUp"));
		objSignUp.setPhone(ExcelUtility.readExcel(6,2,"FacultySignUp"));
		objSignUp.setPassword(ExcelUtility.readExcel(6,3,"FacultySignUp"));
		objSignUp.setConfPassword(ExcelUtility.readExcel(6,4,"FacultySignUp"));
		objSignUp.clickSignUpBtn();
		Assert.assertEquals(objSignUp.getPassError(), AutomationConstants.EXP_PASS_ERR);	
	}
	
	//verify error when confirm password does not match password
	@Test(priority=9,description="confirm password different")
	public void confirmPassNotMatching() throws IOException {
		objSignUp.setName(ExcelUtility.readExcel(7,0,"FacultySignUp"));
		objSignUp.setEmail(ExcelUtility.readExcel(7,1,"FacultySignUp"));
		objSignUp.setPhone(ExcelUtility.readExcel(7,2,"FacultySignUp"));
		objSignUp.setPassword(ExcelUtility.readExcel(7,3,"FacultySignUp"));
		objSignUp.setConfPassword(ExcelUtility.readExcel(7,4,"FacultySignUp"));
		objSignUp.clickSignUpBtn();
		Assert.assertEquals(objSignUp.getConfPassMatchError(), AutomationConstants.EXP_CONFPASS_MATCH_ERR);	
	}	

}
