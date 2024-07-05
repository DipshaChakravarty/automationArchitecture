package com.qa.logic.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	
	//page locators: to achieve encapsulation declare it private can not be accessed out of the class.
	private By emailTextbox = By.name("");
	private By passwordbox = By.id("");
	private By submitButton = By.xpath("");
	private By header = By.xpath("");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getEmailTextbox() {
		return getElement(emailTextbox);
	}
	
	public WebElement getPasswordbox() {
		return getElement(passwordbox);
	}

	public WebElement getSubmitButton() {
		return getElement(submitButton);
	}
	public String getLoginPageHeader() {
		return getPageHeader(header);
	}
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	//positive login
	public HomePage doLogin(String username, String password) {
		getEmailTextbox().sendKeys(username);
		getEmailTextbox().sendKeys(password);
		getSubmitButton().click();
		return getInstance(HomePage.class);
	}
	
	//with method overloading: negative login without username, password
	public void doLogin() {
		getEmailTextbox().sendKeys("");
		getEmailTextbox().sendKeys("");
		getSubmitButton().click();
	}
	
	//method overloading again with blank password
	public void doLogin(String username) {
		getEmailTextbox().sendKeys(username);
		getEmailTextbox().sendKeys("");
		getSubmitButton().click();
	}
}
