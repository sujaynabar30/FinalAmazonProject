package com.amazon.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.amazon.browserinit.BrowserFactory;

/**
 * 
 * @author sujay_nabar
 * This class is used to search the product and call the window handling class
 */
public class ProductPage {

    
	//WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");
	
	public void testMethod(String searchKey,WebDriver driver) {
		
			System.out.println("dataprovided key is :"+searchKey);
			WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")); // find searchbox
			searchbar.clear();
			searchbar.sendKeys(searchKey);														//send keys
			driver.findElement(By.className("nav-input")).click(); // click search
			
			WindowHandleClass window = new WindowHandleClass();								//go to windowhandling class
			window.windowHandle(driver,searchKey);
	}
}
