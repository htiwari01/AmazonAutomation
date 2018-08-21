package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	
	String sheetName = "login";
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		landingpage = new LandingPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		landingpage.clickOnLoginButton();
	}
	@Test(priority=1)
	public void singInTextValidationTest() {
		String logintext = loginpage.singInTextValidation();
		Assert.assertEquals(logintext, "Sign in" );
		System.out.println(logintext + "page is displayed");
	} 
	@Test(priority=2)
	public void loginPageLogoTest() {
		boolean flag = loginpage.loginPageLogo();
		Assert.assertTrue(flag);
		System.out.println("Amazon logo is displayed at loginPage " +flag);
	}
/*	@Test(priority=3)
	public void loginTest() {
		String emailErrorMsg = loginpage.keyInvalidEmailID(prop.getProperty("incorrectEmailid"));
		Assert.assertEquals(emailErrorMsg, "We cannot find an account with that email address");
		System.out.println("Invalid email entered - " +emailErrorMsg );
	} */
	@Test(priority=4)
	public void keyValidEmailIDTest() {
		loginpage =  loginpage.keyValidEmailID(prop.getProperty("correctEmailid"));
	}
/*	@Test(priority=5)
	public void keyInvalidPasswordTest() {
		String passwordErrorMsg = loginpage.keyInvalidPassword("invalidpassword");
		Assert.assertEquals(passwordErrorMsg, "Your password is incorrect");
		System.out.println("Invalid password entered - " +passwordErrorMsg);
	} */
	@Test(priority=6)
	public void validLoginCredentialsTest() {
		homepage = loginpage.validLoginCredentials(prop.getProperty("correctEmailid"), prop.getProperty("correctPassword"));
		System.out.println("user successfully logged in");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	} 

}
