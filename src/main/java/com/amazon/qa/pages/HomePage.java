package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//PageFactory
	@FindBy(xpath="//span[@class='nav-line-1' and text()='Hello, Himanshu']")
	WebElement accountvalidation;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchbox;
	@FindBy(xpath="//input[@value='Go']")
	WebElement goButton;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	public SearchResultPage searchProduct(String product) {
		searchbox.sendKeys(product);
		goButton.click();
		return new SearchResultPage();
	}

}
