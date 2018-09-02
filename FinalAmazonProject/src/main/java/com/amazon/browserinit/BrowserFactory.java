package com.amazon.browserinit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * 
 * @author sujay_nabar
 * This class is used for browser initializing and setting the browser
 */

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String BrowserName, String url)
	{
		if(BrowserName.equals("chrome"))
		{
			driver = new ChromeDriver();		
		}
		else if(BrowserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equals("IE"))
		{
			driver = new InternetExplorerDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
		
	}
}
