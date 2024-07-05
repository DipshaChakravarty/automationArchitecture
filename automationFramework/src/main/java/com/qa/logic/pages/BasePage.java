package com.qa.logic.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public Properties getPropertiesFileData() {

		String BasicPath = System.getProperty("user.dir");
		try {
			FileInputStream input = new FileInputStream(BasicPath + "\\resources\\config.properties");
			prop.load(input);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception occured and handled");
		} catch (IOException e) {
			System.out.println("IO exception occured and handled");
		}
		return prop;
	}
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		}catch(Exception e) {
			System.out.println("Some error occured while creating an element " +locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			System.out.println("some exception occured while waiting for element" + locator.toString());
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			System.out.println("some exception occured while waiting for title" + title);
		}
	}

	

}
