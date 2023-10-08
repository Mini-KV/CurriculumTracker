package org.ictkerala.pages;

import org.ictkerala.constants.AutomationConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
 * @author Mini
 */
public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//locate web elements
	@FindBy(linkText = "Login")
	WebElement loginBtn;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitBtn;
		
	@FindBy(id = "swal2-title")
	public WebElement loginMsg;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement okBtn;
	
	@FindBy(xpath = "//i[@class='bi bi-box-arrow-left']")
	WebElement logoutBtn;
	
			
	//constructor
	public LoginPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	//click Login button
	 public void clickLogintBtn() {
		 loginBtn.click();
	 }
	
	//enter email, password and click Submit button
	public void clickSubmitBtn(String inpEmail,String inpPassword) {
		email.clear();
		password.clear();
		email.sendKeys(inpEmail);		
		password.sendKeys(inpPassword);
		submitBtn.click();
		okBtn.click();
	}
	
	//click logout button
	public void clickLogoutBtn() {
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", logoutBtn);		
		js.executeScript("arguments[0].click();", logoutBtn);
	}
	
	//verify login url
	public boolean verifyLoginURL() {
		return wait.until(ExpectedConditions.urlToBe(AutomationConstants.LOGIN_URL));
	}

}
