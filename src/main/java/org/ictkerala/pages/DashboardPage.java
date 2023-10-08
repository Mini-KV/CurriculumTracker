package org.ictkerala.pages;

import java.time.Duration;

import org.ictkerala.constants.AutomationConstants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
 * @author Mini
 */
public class DashboardPage {
	WebDriver driver;
	WebDriverWait wait;
	
	//locate web elements
	@FindBy(xpath = "//i[@routerlink ='/dashboard/requirement-list/rform']")
	WebElement crtReqt;
	
	@FindBy(id = "requirementName")
	WebElement reqName;
	
	@FindBy(id = "trainingArea")
	WebElement trainName;
	
	@FindBy(id = "institution")
	WebElement instName;
	
	@FindBy(id = "category")
	WebElement catgName;
	
	@FindBy(id = "trainingHours")
	WebElement trainHours;
		
	@FindBy(name = "files")
	WebElement fileUpl;
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "//input[@placeholder='Search ']")
	WebElement searchBox;	

	@FindBy(xpath = "//h5[contains(text(),'Automation')]")
	WebElement searchReq;
	
	@FindBy(xpath ="//i[contains(@class,'bi-arrow-right-square-fill')]")
	WebElement clickArrow;
	
	@FindBy(id = "curriculum_id")
	WebElement slNo;
	
	@FindBy(id = "description")
	WebElement desc;
	
	@FindBy(id = "inputGroupFile03")
	WebElement editFile;
	
	@FindBy(xpath = "//button[contains(@class,'btn-primary')]")
	WebElement submitEdit;
	
	@FindBy(xpath = "//button[contains(@class,'accordion')]")
	WebElement facResponse;
	
	@FindBy(id = "input")
	WebElement inputMsg;	
	
	@FindBy(xpath = "//button[text() = 'Send']")
	WebElement sendBtn;
	
	@FindBy(xpath = "//button[text()='Approve']")
	WebElement apprBtn;
	
	@FindBy(xpath = "//a[@routerlink='/dashboard/pending']")
	WebElement pendLink;
	
	WebElement srchCurrclm;
		
	public String reqAlertText;
	
	//constructor
	public DashboardPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	//Click Create Req button
	public void clickCreateReqBtn() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", crtReqt);
		js.executeScript("arguments[0].click();", crtReqt);
	}
	
	//enter data and click Submit button
	public void clickReqSubmitBtn(String inpReq,String inpArea,String inpInst,String inpCat,String inpHrs, String inpPath) {
		reqName.sendKeys(inpReq);		
		trainName.sendKeys(inpArea);
		instName.sendKeys(inpInst);
		catgName.sendKeys(inpCat);
		trainHours.sendKeys(inpHrs);
		fileUpl.sendKeys(inpPath);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", submitBtn);
		js.executeScript("arguments[0].click();", submitBtn);
	}
	
	//Get create req alert
	public String getReqAlert() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert reqAlert = driver.switchTo().alert();
		reqAlertText = reqAlert.getText();	
		reqAlert.accept();
		return reqAlertText;		
		}	
	
	//search for a requirement
	public void searchReq(String inpSrchTerm) {
		searchBox.sendKeys(inpSrchTerm);
	}
		
	//click on requirement search result
	public void clickSrchReq(String inpSrchTerm) {
		driver.findElement(By.xpath("//h5[contains(text(),'"+inpSrchTerm+"')]")).click();
	 }
	
	//submit requirement
	public void submitReq(String inpSlNo,String inpDesc,String inpFilePath,String inpResp) {
		clickArrow.click();
		slNo.sendKeys(inpSlNo);
		desc.sendKeys(inpDesc);
		editFile.sendKeys(inpFilePath);
		facResponse.click();
		inputMsg.sendKeys(inpResp);
		sendBtn.click();
		submitEdit.click();		
	 }
	
	//approve pending curriculum
	public void apprPendCurrlm(String inpSrchTerm) {
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", pendLink);	
		System.out.println(inpSrchTerm);
		System.out.println(driver.getCurrentUrl());		
		srchCurrclm = driver.findElement(By.xpath("//a[contains(.,'"+inpSrchTerm+"')]"));
		js.executeScript("arguments[0].scrollIntoView;", srchCurrclm);	
		js.executeScript("arguments[0].click();", srchCurrclm);	
		Actions action = new Actions(driver);
		action.moveToElement(apprBtn);
		action.click(apprBtn);
		Action a = action.build();
		a.perform();
	 }
		
	//verify requirement page url
	public boolean verifyReqURL() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.urlToBe(AutomationConstants.REQ_FORM_URL));
	}
}
