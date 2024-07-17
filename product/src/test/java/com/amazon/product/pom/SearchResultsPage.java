package com.amazon.product.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage {
	
	@FindBy(xpath="(//a[contains(@href,'Samsung')])[1]")
	private WebElement mobselect;
	
	@FindBy(xpath="//select[@data-action='a-dropdown-select']")
	private WebElement drpdwnbx;
	
	public SearchResultsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public  String getMobText()
	{
		
		String mob_text = mobselect.getText();
		return mob_text;
		
	}
	
	public  void selectHighValueMob()
	{
		String mob_text = mobselect.getText();
		mobselect.click();
	}
	
	public void sortHightoLow()
	{
		Select sc = new Select(drpdwnbx);
		//sc.selectByValue("price-desc-rank");
		sc.selectByVisibleText("Price: High to Low");
		
	}
	

}
