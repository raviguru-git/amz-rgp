package com.amazon.product.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	String item = null;
	WebDriver driver;
	
	@FindBy(name="field-keywords")
	private WebElement srchtxtbx;
	
	public String getItem() {
		return item;
	}

	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getSrchtxtbx() {
		return srchtxtbx;
	}


	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterSearchTxt(String searchtxt)
	{
		srchtxtbx.sendKeys(searchtxt+Keys.ENTER);
	}
	

	public  void selectFromAutoSuggest(String item)
	{
		driver.findElement(By.xpath("//div[contains(text(),'"+item+"')]")).click();
		
	}
	
}
