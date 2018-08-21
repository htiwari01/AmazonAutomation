package com.amazon.qa.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SearchResultPage;
import com.amazon.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	SearchResultPage searchresultpage;
	
	public HomePageTest() {
		super();
	}
	@BeforeTest
	public void setUp() {
		initialization();
		landingpage = new LandingPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		searchresultpage = new SearchResultPage();
		landingpage.clickOnLoginButton();
		loginpage.validLoginCredentials(prop.getProperty("correctEmailid"), prop.getProperty("correctPassword"));	
	}
	@Test(priority=1)
	public void homePageTitleTest() {
		String title = homepage.homePageTitle();
		System.out.println("Home page title is - " +title);
	}
	@Test(priority=2)
	public void searchProductTest() {
		searchresultpage = homepage.searchProduct(prop.getProperty("product"));
	}

}
