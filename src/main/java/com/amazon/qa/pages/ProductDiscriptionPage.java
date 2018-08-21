package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class ProductDiscriptionPage extends TestBase {
	
	//PageFactory
	@FindBy(xpath="//span[contains(text(), 'Apple iPhone X, Fully Unlocked 5.8\", 64 GB - Silver (Certified Refurbished)')]")
	WebElement productName;
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	WebElement price;
	@FindBy(xpath="//*[@id=\"add-to-cart-button\"]")
	WebElement addToCartButton;
	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement clickonCart;
	
	public ProductDiscriptionPage() {
		PageFactory.initElements(driver, this);
	}
	public String productDescription() {
		return productName.getText();
	}
	public String prodcutPrice() {
		return price.getText();
	}
	public void productQuantity() {
		Select pQuantity = new Select(driver.findElement(By.id("quantity")));
		pQuantity.selectByValue("1");
	}
	public void addToCart() {
		addToCartButton.click();	
	}
	public CartDetails clickOnCart() {
		clickonCart.click();
		return new CartDetails();
	}

}
