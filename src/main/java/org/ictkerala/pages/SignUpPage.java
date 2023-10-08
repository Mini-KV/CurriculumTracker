package org.ictkerala.pages;

import java.time.Duration;

import org.ictkerala.constants.AutomationConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*
 * @author Mini
 */
public class SignUpPage {
	WebDriver driver;
	WebDriverWait wait;
	
	//locate web elements
	@FindBy(xpath = "//a[@routerlink='/signup']")
	WebElement newAcctLink;
	
	@FindBy(name = "Name")
	WebElement name;
	
	@FindBy(name = "Email")
	WebElement email;
	
	@FindBy(name = "Contact")
	WebElement phoneNo;
	
	@FindBy(name = "Password")
	WebElement password;
	
	@FindBy(name = "ConfirmPassword")
	WebElement confPassword;
	
	@FindBy(xpath = "//button[text()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(id = "swal2-title")
	public WebElement signUpMsg;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement signUpOKBtn;
	
	@FindBy(xpath = "//input[@name = 'Name']/following::small")
	WebElement nameError;
	
	@FindBy(xpath = "//input[@name = 'Contact']/following::small")
	WebElement phoneNoError;
	
	@FindBy(xpath = "//input[@name = 'Email']/following::small")
	WebElement emailError;

	@FindBy(xpath = "//input[@name = 'Password']/following::small")
	WebElement passwordError;
	
	@FindBy(xpath = "//input[@name = 'ConfirmPassword']/following::small")
	WebElement confPassEmptyError;
	
	@FindBy(xpath = "//input[@name = 'ConfirmPassword']/following::small/following::small")
	WebElement confPassMatchError;
	
	
	public SignUpPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	//click the Create New Account link
	public void clickNewAcctLink() {
		newAcctLink.click();
	}
	
	//set user name
	public void setName(String inpUser) {
		name.clear();
		name.sendKeys(inpUser);
	}
	
	//set password
	public void setPassword(String inpPass) {
		password.clear();
		password.sendKeys(inpPass);
	}
	
	//set confirm password
	public void setConfPassword(String inpConfPass) {
		confPassword.clear();
		confPassword.sendKeys(inpConfPass,Keys.TAB);
		
	}
	
	public void setPhone(String inpPhone) {
		phoneNo.clear();
		phoneNo.sendKeys(inpPhone);
	}
	
	//set email
	public void setEmail(String inpMail) {
		email.clear();
		email.sendKeys(inpMail);
	}
		
	//set data and click sign up button
	public void clickSignUpBtn () {
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", signUpBtn);		
		js.executeScript("arguments[0].click();", signUpBtn);
	}
	
	//click the OK button
	public void clickOKBtn() {
		signUpOKBtn.click();
	}
	
	//get name missing error
	public String getNameError() {
		return nameError.getText();
	} 
	
	//get phone number missing error
	public String getPhoneNoError() {			
		return phoneNoError.getText();	
	} 

	//get email missing error
	public String getEmailError() {	
		return emailError.getText();	
	} 

	//get password  missing error
	public String getPassError() {
		return passwordError.getText();	
	} 

	//get confirm password empty error
	public String getConfPassEmptyError() {	
		return confPassEmptyError.getText();	
	}
	
	//get confirm password different error
	public String getConfPassMatchError() {	
		return confPassMatchError.getText();	
	}
	
	//verify sign up url
	public boolean verifySignUpURL() {		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.urlToBe(AutomationConstants.SIGNUP_URL));
	}
}
