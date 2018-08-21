package com.amazon.qa.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase {
		
		//PageFactory declaration
		@FindBy(xpath="//h1[@class='a-spacing-small']")
		@CacheLookup
		WebElement signInText;
		@FindBy(xpath="//i[@class='a-icon a-icon-logo']")
		@CacheLookup
		WebElement amazonLogo;
		@FindBy(xpath="//input[@id='ap_email']")
		WebElement emailId;
		@FindBy(xpath="//input[@class='a-input-text a-span12 auth-required-field']")
		WebElement RLUpEmailID;
		@FindBy(xpath="//input[@id='continue']")
		WebElement continueButton;
		@FindBy(xpath="//input[@id='ap_password']")
		WebElement password;
		@FindBy(xpath="//input[@id='signInSubmit']")
		WebElement signInButton;
		@FindBy(xpath="//span[contains(text(), 'We cannot find an account with that email address')]")
		WebElement invalidEmailidMsg;
		@FindBy(xpath="//span[contains(text(), 'Your password is incorrect')]")
		@CacheLookup
		WebElement invalidPasswordMsg;
		
		//PageFactory initialization
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		//Actions
		public String singInTextValidation() {
			return signInText.getText();
		}
		public boolean loginPageLogo() {
			return amazonLogo.isDisplayed();
		}
	/*	public String keyInvalidEmailID(String invalidemail) {
			emailId.sendKeys(invalidemail);
			continueButton.click();
			return invalidEmailidMsg.getText();
		} */
		public LoginPage keyValidEmailID(String validemail) {
			RLUpEmailID.clear();
			RLUpEmailID.sendKeys(validemail);
			//WebDriverWait wait = new WebDriverWait(driver, 15);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='continue']")));
			continueButton.click();
			return new LoginPage();
		}
	/*	public String keyInvalidPassword(String invalidpassword) {
			password.sendKeys(invalidpassword);
			signInButton.click();
			return invalidEmailidMsg.getText();
		} */
		public boolean isemailIdWebElementPresent() {
			try {
				emailId.isDisplayed();
				return true;
			} catch (NoSuchElementException e) {
				return false;
	        }
		}
		public boolean isContWebElementPresent() {
			try {
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				continueButton.isDisplayed();
				return true;
			} catch (NoSuchElementException e) {
				return false;
	        }
		}
		public boolean ispwdWebElementPresent() {
			try {
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				password.isDisplayed();
				return true;
			} catch (NoSuchElementException e) {
				return false;
	        }
		}
		public boolean isSignInWebElementPresent() {
			try {
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				signInButton.isDisplayed();
				return true;
			} catch (NoSuchElementException e) {
				return false;
	        }
		}
		public HomePage validLoginCredentials(String em, String pwd) {
			if(isemailIdWebElementPresent()) {
			
			emailId.clear();
			emailId.sendKeys(em);
			} else{
				System.out.println("Email ID webElement is not available on Login Page");
			}
			if(isContWebElementPresent()) {
				continueButton.click();
			}else {
				System.out.println("ContinueButton webElement is not available on Login Page");
			}
			if(ispwdWebElementPresent()) {
				password.clear();
				password.sendKeys(pwd);
			}else {
				System.out.println("Password webElement is not available on Login Page");
			}
			if(isSignInWebElementPresent()) {
				signInButton.click();
			}else {
				System.out.println("ClickButton webElement is not available on Login Page");
			}	
			return new HomePage();	
		}
}