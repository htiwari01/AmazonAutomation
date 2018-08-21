package com.amazon.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.util.TestUtil;

public class LandingPageTest extends TestBase {
	
	LandingPage landingpage;
	LoginPage loginpage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		landingpage = new LandingPage();
		loginpage = new LoginPage();
	}
	@Test(priority=1)
	public void validateLandingPageURLTest() {
		String Title = landingpage.validateLandingPageURL();
		String AmazonTitle = driver.getTitle(); 
		Assert.assertEquals(Title, AmazonTitle );
		System.out.println("Title of the page is " +Title);
	}
	@Test(priority=2)
	public void validateAmazonLogoTest() {
		Boolean flag = landingpage.validateAmazonLogo();
		Assert.assertTrue(flag);
		System.out.println("Logo is being " +flag);
	}
	@Test(priority=3)
	public void clickOnLoginButtontest() {
		loginpage = landingpage.clickOnLoginButton();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Login page is displayed");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
