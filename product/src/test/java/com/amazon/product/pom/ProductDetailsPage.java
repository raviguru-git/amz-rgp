package com.amazon.product.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	@FindBy(xpath="(//input[@title='Add to Shopping Cart'])[2]")
	private WebElement cartbtn;
	
	@FindBy(xpath="//input[@aria-labelledby='attach-sidesheet-checkout-button-announce']")
	private WebElement proceed_chckout;
	
	public ProductDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickCartbtn()
	{
		cartbtn.click();
	}

	public void click_prcd_chckout()
	{
		proceed_chckout.click();
	}
}
