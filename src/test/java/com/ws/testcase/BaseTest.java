package com.ws.testcase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;

public class BaseTest extends DriverScript {
	
	
	HomePage homepage;
	LoginPage loginpage;
	
	
    @BeforeMethod
	public void setUp() {

		initApplication();
		homepage = new HomePage();
		loginpage = new LoginPage();
		

	}

	@AfterMethod
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(3000);
		quitDriver();

	}

}
