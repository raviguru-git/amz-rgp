package com.amazon.product.generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.Helper;
import utils.ScreenShotUtils;
import utils.WebDriverUtil;

public class BaseClass {
	protected WebDriver driver;  // declaration..
	protected FileLib f = new FileLib();
	protected ScreenShotUtils  ss = new ScreenShotUtils();
	protected Helper hp = new Helper();
	
	
	@Parameters("browserName")
	@BeforeClass
	public void setup(@Optional("chrome") String browserName)
	{
		Reporter.log("Starting setup method", true);
		driver = WebDriverUtil.createWebDriver(browserName); // Initialization here using static method.
		System.out.println(driver);
		
		
		
	}
	
	@BeforeMethod
	public void openBrowser()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	//	String url = f.readDataFromPropertiesiFile("url");
	//	driver.get(url);
		Reporter.log("openbrowser() is started",true);
	}
	
	
	  @BeforeMethod 
	  public void login() 
	  { 
	    String url = f.readDataFromPropertiesiFile("url");
	    System.out.println(url);
	    //Caveats: Chosen amazon.in due to cart functionality differs in www.amazon.com site actually.
	    driver.get(url);
	   }
	 

}
