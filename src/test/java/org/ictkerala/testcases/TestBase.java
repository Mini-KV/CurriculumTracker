package org.ictkerala.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.Properties;

import org.ictkerala.constants.AutomationConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/*
 * @author Mini
 */
public class TestBase {
	
	WebDriver driver;
	WebDriverWait wait;
	public static Properties properties;
	
	//initial configuration
	@BeforeMethod
	public void configMethod() {
		String browser = properties.getProperty("browser");

		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(properties.getProperty("url"));	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	//read properties file
	public TestBase() {
		properties = new Properties();
		File configFile = new File (System.getProperty("user.dir")+ AutomationConstants.CONFIG_PATH);
		
		try {
			FileInputStream inputStream = new FileInputStream(configFile);
			properties.load(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//quit browser
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
