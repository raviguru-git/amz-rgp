package com.amazon.product.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	
	
	@FindBy(xpath="//input[@id='ap_email_login']")
	private WebElement emailtxbx;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement continuebtn;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement pwdtxbx;
	
	@FindBy(id="signInSubmit")
	private WebElement signinbtn;
	
	@FindBy(xpath="(//input[@class='a-button-input'])[2]")
	private WebElement usethisbtn;
	
	
	/*
	 * public WebElement getEmailtxbx() { return emailtxbx; }
	 * 
	 * public void setEmailtxbx(WebElement emailtxbx) { this.emailtxbx = emailtxbx;
	 * }
	 */

	public SigninPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setEmailtxbx(String usrname) {
		// TODO Auto-generated method stub
		emailtxbx.sendKeys(usrname);
		
	}

	public void setpwdtxbx(String pwd) {
		// TODO Auto-generated method stub
		pwdtxbx.sendKeys(pwd);
		
	}
	
	public void clickContinuebtn()
	{
		continuebtn.click();
	}
	
	public void signinbtn()
	{
		usethisbtn.click();
	}
	
	public void usethisbtn()
	{
		signinbtn.click();
	}
	
}
