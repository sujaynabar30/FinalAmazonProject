package com.amazon.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazon.browserinit.BrowserFactory;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductPage;

/**
 * 
 * @author sujay_nabar
 * This class is used to search the product and call the window handling class
 */
public class VerifyProductPage {

    
	//WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");
	
	public void testProductPage(String searchKey,WebDriver driver) {
		
			/*System.out.println("dataprovided key is :"+searchKey);
			WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")); // find searchbox
			searchbar.clear();
			searchbar.sendKeys(searchKey);														//send keys
			driver.findElement(By.className("nav-input")).click(); 			// click search
*/			
			ProductPage product_page = PageFactory.initElements(driver, ProductPage.class); 
			product_page.searchproduct(searchKey);
		
			VerifyWindowHandle window = new VerifyWindowHandle();				//go to windowhandling class
			window.windowHandle(driver,searchKey);
	}
}
