package com.amazon.product.testclass;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.amazon.product.generic.BaseClass;
import com.amazon.product.pom.CartPage;
import com.amazon.product.pom.HomePage;
import com.amazon.product.pom.ProductDetailsPage;
import com.amazon.product.pom.SearchResultsPage;
import com.amazon.product.pom.SigninPage;

import utils.Helper;
import utils.WebDriverUtil;

public class TestSuite extends BaseClass {
	
	private static final Logger logger = LogManager.getLogger(TestSuite.class);
	
	@Test
	public void amazon_srch_add_to_cart() throws InterruptedException
	{
		// Action 1: Searching for a product.
		logger.info("Action 1 started:");
		logger.info("Navigated to amazon site which is: www.amazon.in");
		HomePage h  = new HomePage(driver);
		logger.info("Printing driver value for HomePage here:" + driver);
		h.enterSearchTxt("sam");
		logger.info("Search text sam is entered now");
		Thread.sleep(3000);
		//Taking Screenshot after logging into Amazon site.
		Helper.highlightElement(driver, h.getSrchtxtbx());
		ss.takeScreenShot(driver, "./data/screenshots/img_amzon_hm_pg.png");
		h.enterSearchTxt("samsung 5g");
		logger.info("Entered search text in textbox");
		ss.takeScreenShot(driver, "./data/screenshots/img_amzon_hm_samsung_mob.png");
		
		//Action 2:
		logger.info("Action 2 started:");
		SearchResultsPage s = new SearchResultsPage(driver);
		logger.info("Navigated to Search results page");
		Thread.sleep(2000);
		//First making use of sorting High to Low.
		s.sortHightoLow();
		String mob_actual = s.getMobText();
		s.selectHighValueMob();
		
		Thread.sleep(3000);
		
		logger.info("Selected high mob value of Samsung 5g mob:");
		ss.takeScreenShot(driver, "./data/screenshots/img_select_sam_mob_5g.png");
		
		//Action 3.
		logger.info("Action 3 started:");
		Set<String> wind = driver.getWindowHandles();
		for (String id : wind)
		{
			driver.switchTo().window(id);
		}
		
		ProductDetailsPage p = new ProductDetailsPage(driver);
		p.clickCartbtn();
	
		
		//Action 4.
		logger.info("Action 4 started:");
		CartPage cp = new CartPage(driver);
		cp.clkCartbtn();
		Helper.highlightElement(driver, cp.getMobTextWebEle());
		ss.takeScreenShot(driver,"./data/screenshots/cart_screenshot.png");
		logger.info("Comparing actual and expected values in the cart page using Assertion");
		Assert.assertEquals(mob_actual, cp.getMobText());
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("Starting tearDown() now");
		if(driver != null)
		WebDriverUtil.quitDriver();
		logger.info("Successfully closed driver instance");
	}

}
