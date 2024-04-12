package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class LoginPage extends DriverScript {
	
	//---------------------Page Element-----------------------------//
	
	@FindBy(id="Email")WebElement emailTextBox;
	@FindBy(name="Password")WebElement passwordTextBox;
	@FindBy(xpath="//input[@value='Log in']")WebElement loginbutton;
	@FindBy(linkText="Forgot password?")WebElement fogotPasswordLink;
	
	
	//---------------------Page Initalisation-----------------------------//

	public LoginPage() {
		
		PageFactory.initElements(driver,this);
	}
	
	//---------------------Page Action/Method-----------------------------//

	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
		
		
	}
	
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	
	public void clickLoginButton() {
		
		loginbutton.click();
		
	}
	
	public boolean isForgotPasswordlinkDisplayed() {
		return fogotPasswordLink.isDisplayed();
	}
	
	public String getLogintitle() {
		
		
		return driver.getTitle();
	}
}
