package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class HomePage extends DriverScript {

	// ---------------------Page Element----------//
	
	@FindBy(linkText = "Log in") WebElement loginlink;
	@FindBy(linkText="Log out")WebElement logoutLink;
	
	
	//--------------------------Page Intialisation--------------------------//
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//--------------------------Page Action/methods--------------------------//
	
	public void clickloginlink() {
		
		loginlink.click();
		
		
	}
	public String getHomePageTitle() {
		
		return driver.getTitle();
	}
	public boolean islogoutLinkDisplayed() {
		return logoutLink.isDisplayed();
	}

	public void clickLogout() {

		logoutLink.click();
	}
	
}
