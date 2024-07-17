package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotUtils {
	
	public void takeScreenShot(WebDriver driver, String filepath)
	{
		TakesScreenshot scsht = (TakesScreenshot) driver;
		 File src = scsht.getScreenshotAs(OutputType.FILE);
		 try {
			 FileUtils.copyFile(src, new File(filepath));
		 }
		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }
	}

}
