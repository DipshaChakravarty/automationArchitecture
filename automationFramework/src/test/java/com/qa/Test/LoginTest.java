package com.qa.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.logic.pages.HomePage;
import com.qa.logic.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(priority = 1 , enabled = true)
	public void verifyLoginPageTitleTest() {
		String title= page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "actual title from page");
	}
	@Test(priority = 2, enabled = false)
	public void verifyLoginPageHeaderTest() {
		String header= page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "actual header from page");
	}
	@Test(priority = 2, enabled = false)
	public void verifyLoginTest(String username,String  pwd) {
		HomePage homepageobj= page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String homepageheader =homepageobj.getHomePageHeader();
		Assert.assertEquals(homepageheader, "Header of the next page after login");
	}
}
