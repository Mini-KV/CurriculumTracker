package org.ictkerala.testcases;

import java.io.IOException;

import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.DashboardPage;
import org.ictkerala.pages.LoginPage;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*
 * @author Mini
 */
public class AdmDashbdPageTest extends TestBase{

	DashboardPage objAddReqPage;
	LoginPage objLogin;
	
	@BeforeMethod
	public void login() throws IOException {
		String email = ExcelUtility.readExcel(1,0,"AdminLogin");
		String password = ExcelUtility.readExcel(1,1,"AdminLogin");
		objAddReqPage = new DashboardPage(driver,wait);
		objLogin = new LoginPage(driver,wait);
		objLogin.clickLogintBtn();
		objLogin.clickSubmitBtn(email,password);			
	}

	//Test Create requirement functionality
	@Test(priority=2, description="verify Create requirement functionality")
	public void verifyCreateReqt() throws IOException {
		objAddReqPage.clickCreateReqBtn(); 	
		String req	=  ExcelUtility.readExcel(1,0,"CreateReqt");
		String area =  ExcelUtility.readExcel(1,1,"CreateReqt");
		String inst =  ExcelUtility.readExcel(1,2,"CreateReqt");
		String catg =  ExcelUtility.readExcel(1,3,"CreateReqt");
		String hrs  =  ExcelUtility.readExcel(1,4,"CreateReqt");	
		String path =  ExcelUtility.readExcel(1,5,"CreateReqt");	
		objAddReqPage.clickReqSubmitBtn(req,area,inst,catg,hrs,path);
	    Assert.assertEquals(objAddReqPage.getReqAlert(), AutomationConstants.EXP_REQ_ALERT);			
	}
	
	
	//Approve functionality
	@Test(priority=5, description="approve pending curriculum ")
	public void apprCurrlm() throws IOException {
		String req	=  ExcelUtility.readExcel(1,0,"CreateReqt");
		objAddReqPage.apprPendCurrlm(req);
		Assert.assertEquals(objAddReqPage.getReqAlert(), AutomationConstants.EXP_CURR_APPR_ALERT);
	}
}
