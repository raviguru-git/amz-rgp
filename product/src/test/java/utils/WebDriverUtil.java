package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtil {
	private static WebDriver driver;
	
	public static WebDriver createWebDriver(String browserName)
	{
	
		if (driver == null) {
			if (browserName.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if (browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		}
		return driver;
	}
	
	public static void quitDriver()
	{
		if ( driver!= null)
		{
			driver.quit();
			driver = null;
		}
	}

}
