package com.amazon.qa.testcases;

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

public class CartDetailsTest extends TestBase {
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	SearchResultPage searchresultpage;
	ProductDiscriptionPage productdescription;
	CartDetails cartdetail;
	
	public CartDetailsTest() {
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
		productdescription = new ProductDiscriptionPage();
		cartdetail = new CartDetails();
		landingpage.clickOnLoginButton();
		loginpage.validLoginCredentials(prop.getProperty("correctEmailid"), prop.getProperty("correctPassword"));
		homepage.searchProduct(prop.getProperty("product"));
		searchresultpage.clickonSearchedProduct();
		productdescription.addToCart();
		productdescription.clickOnCart();
	}
	@Test(priority=1)
	public void productdetailsTest() {
		String pDetails = cartdetail.productdetails();
		System.out.println("Added prodcut description is - " +pDetails);
	}
	@Test(priority=2)
	public void productAmountTest() {
		String pAmount = cartdetail.productAmount();
		System.out.println("Product amount is - " +pAmount);
	}
	@Test(priority=3)
	public void productQuantityTest() {
		String pQuantity = cartdetail.productQuantity();
		System.out.println("Product quantity is - " +pQuantity);
	}
	@Test(priority=4)
	public void LogoutTest() {
		cartdetail.Logout();
		System.out.println("User logged out successfully");
	}
	@Test(priority=5)
	public void relogin() {
		loginpage.validLoginCredentials(prop.getProperty("correctEmailid"), prop.getProperty("correctPassword"));
		productdescription.clickOnCart();
		cartdetail.productQuantity();
		cartdetail.productAmount();
		cartdetail.Logout();
	}

}
