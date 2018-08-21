package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;

public class CartDetails extends TestBase {
	
	//PageFactory
	@FindBy(xpath="//span[@class='a-size-medium sc-product-title a-text-bold']")
	WebElement productDiscription;
	@FindBy(xpath="//span[@class='a-size-medium a-color-price sc-price sc-white-space-nowrap sc-product-price sc-price-sign a-text-bold']")
	WebElement productPrice;
	@FindBy(xpath="//span[contains(text(), 'Subtotal (1 item)')]")
	WebElement productQuantity;
	@FindBy(xpath="//span[@class='a-dropdown-prompt']")
	WebElement accountButton;
	@FindBy(xpath="//span[@class='nav-text' and text()='Sign Out']")
	WebElement logout;
	
	//PageFactory Initialization
	public CartDetails() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String productdetails() {
		String pName= productDiscription.getText();
		return pName;
	}
	public String productAmount() {
		String price = productPrice.getText();
		return price;
	}
	public String productQuantity() {
		String quantity = productQuantity.getText();
		return quantity;
	}
	public void Logout() {
		Actions mover = new Actions(driver);
		mover.moveToElement(accountButton).build().perform();
		logout.click();
		
	}
}
