package com.qa.Test;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.qa.logic.pages.BasePage;
import com.qa.logic.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

//	initialise driver
	
	WebDriver driver;
	Properties prop ;
	public Page page;
	public BasePage basepage;
	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUpTest(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			System.out.println("No browser is defined in xml file..");
		}
		page = new BasePage(driver);
		prop = page.getPropertiesFileData();
		
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
