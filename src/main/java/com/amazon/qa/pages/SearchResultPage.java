package com.amazon.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;

public class SearchResultPage extends TestBase {
	
	//PageFactory
	@FindBy(xpath="//span[contains(text(),'Showing most relevant results. See all results for ')]")
	WebElement searchValidation;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	public String searchProductPageValidation() {
		return searchValidation.getText();
	}
	public ProductDiscriptionPage clickonSearchedProduct() {
		List<WebElement> resultsList = driver.findElements(By.xpath("//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']/h2"));
		String firstProdcutName= resultsList.get(0).getText();
		System.out.println(firstProdcutName);
		resultsList.get(0).click();
		return new ProductDiscriptionPage();
	}
}
