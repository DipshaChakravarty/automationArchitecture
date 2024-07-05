package com.qa.logic.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
		this.prop = new Properties();
	}
	
	//abstract methods:
	public abstract Properties getPropertiesFileData();
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
		
	//generic method:
	public <Pageinstance extends BasePage> Pageinstance getInstance(Class<Pageinstance> pageClass){
		
		try {
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
