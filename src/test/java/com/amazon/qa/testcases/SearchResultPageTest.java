package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SearchResultPage;
import com.amazon.qa.util.TestUtil;


public class SearchResultPageTest extends TestBase {
	
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	SearchResultPage searchresultpage;
	
	public SearchResultPageTest() {
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
		homepage.searchProduct(prop.getProperty("product"));
	}
	@Test(priority=1)
	public void searchProductPageValidationTest() {
		String sResult = searchresultpage.searchProductPageValidation();
		Assert.assertEquals(sResult, "Showing most relevant results. See all results for" );
	}
	@Test(priority=2)
	public void clickonSearchedProductTest() {
		searchresultpage.clickonSearchedProduct();
	}
	

}
