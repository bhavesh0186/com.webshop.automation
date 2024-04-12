package com.ws.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestLoginPage extends BaseTest {
	

	@Test(priority = 1)
	public void testLoginPageTitle() {

		homepage.clickloginlink();

		String title = loginpage.getLogintitle();
		System.out.println("Page title :" + title);
		Assert.assertTrue(title.contains("Login"));

	}

	@Test (priority = 2)
	public void testloginFunction()
	{
		homepage.clickloginlink();
		loginpage.enterEmail("selauto1@test.com");
		loginpage.enterPassword("Pass@123");
		loginpage.clickLoginButton();
		boolean flag = homepage.islogoutLinkDisplayed();
		Assert.assertTrue(flag);
		homepage.clickLogout();
		 
	}
	@Test (priority = 3)
	public void testForgotPasswordRecover()
	{
		homepage.clickloginlink();
		boolean flag = loginpage.isForgotPasswordlinkDisplayed();
		Assert.assertTrue(flag);		


	}
}
