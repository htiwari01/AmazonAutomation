package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.CartDetails;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LandingPage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.ProductDiscriptionPage;
import com.amazon.qa.pages.SearchResultPage;
import com.amazon.qa.util.TestUtil;

public class ProductDiscriptionPageTest extends TestBase {
	
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	SearchResultPage searchresultpage;
	ProductDiscriptionPage productdiscription;
	CartDetails cartdetails;
	
	public ProductDiscriptionPageTest() {
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
		productdiscription = new ProductDiscriptionPage();
		landingpage.clickOnLoginButton();
		loginpage.validLoginCredentials(prop.getProperty("correctEmailid"), prop.getProperty("correctPassword"));
		homepage.searchProduct(prop.getProperty("product"));
		searchresultpage.clickonSearchedProduct();
	}
	@Test(priority=1)
	public void productDescriptionTest() {
		String description = productdiscription.productDescription();
		System.out.println("Product description is " +description);
	}
	@Test(priority=2)
	public void productQuantityTest() {
		productdiscription.productQuantity();
		System.out.println("Product quantity is added successfully");
	}
	@Test(priority=3)
	public void prodcutPriceTest() {
		String price = productdiscription.prodcutPrice();
		System.out.println("Price is " +price);
	}
	@Test(priority=4)
	public void addToCartTest() {
		productdiscription.addToCart();
		System.out.println("product added successfully");
	}
	@Test(priority=5)
	public void clickOnCarttest() {
		cartdetails = productdiscription.clickOnCart();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
