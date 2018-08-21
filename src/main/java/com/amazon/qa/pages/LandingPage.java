package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	//PageFactory 
	@FindBy(xpath="//span[@class='nav-sprite nav-logo-base']")
	WebElement amazonlogo;
	
	@FindBy(xpath="//span[contains(text(), 'Hello. Sign in')]")
	WebElement signinbutton;
	
	//initializing the PageFactory
	public LandingPage() {
		PageFactory.initElements(driver, this);	
	}
	
	//Actions
	public String validateLandingPageURL() {
		return driver.getTitle();
	}
	public boolean validateAmazonLogo() {
		return amazonlogo.isDisplayed();
	}
	public LoginPage clickOnLoginButton() {
		signinbutton.click();
		return new LoginPage();
	}
}
