package com.amazon.product.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
	private WebElement cartbtn;
	
	//span[contains(text(),'Samsung Galaxy M34 5G')]
	@FindBy(xpath="//span[contains(text(),'Samsung Galaxy M34 5G')]")
	private WebElement mobidntify;
	
	@FindBy(xpath="(//span[contains(text(),'Samsung Galaxy S24')])[1]")
	private WebElement mob_actual;
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clkCartbtn()
	{
		cartbtn.click();
	}
	
	public String getMobText()
	{
		String mobtext = mob_actual.getText();
		return mobtext;
	}
	
	public WebElement getMobTextWebEle()
	
	{
		return mob_actual;
	}
}
