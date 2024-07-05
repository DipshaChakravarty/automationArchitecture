package com.qa.logic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
	
	private By header = By.xpath("");
	
	public HomePage(WebDriver driver) {
		super(driver);	
	}
	
	public String getHomePageHeader() {
		return getPageHeader(header);
	}
	
	public WebElement gethomeHeader() {
		return getElement(header);
	}
	
	public String getHomePagetitle() {
		return getPageTitle();
	}

}
