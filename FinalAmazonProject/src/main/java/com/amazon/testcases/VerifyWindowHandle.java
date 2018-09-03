package com.amazon.testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductDeleteWinHandlePage;
/**
 * 
 * @author sujay_nabar
 * This page is used for Window Handling
 */

public class VerifyWindowHandle {

	public void windowHandle(WebDriver driver, String searchKey) {
		
		  /*String MainWindow=driver.getWindowHandle(); //windows handling
		  
		  //To handle all new opened window. 
		  Set<String> s1=driver.getWindowHandles();
		  Iterator<String> i1=s1.iterator();
		  
		  while(i1.hasNext()) //windows handling { String ChildWindow=i1.next();
		  
		  if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
		  
		  // Switching to Child window driver.switchTo().window(ChildWindow);
		  //switching to child window
		  
		  driver.findElement(By.id("add-to-cart-button")).click();
		  System.out.println("product added to cart");
		  driver.findElement(By.id("nav-cart")).click();
		  
		  driver.close(); }
		  
		  } driver.switchTo().window(MainWindow);*/
		
		String MainWindow = driver.getWindowHandle();								//get current id of window
		System.out.println("Mainwindow :"+MainWindow);
		
		driver.findElement(By.linkText(searchKey)).click();			//finding the product and clicking
		
		System.out.println("Title of main page :"+driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in: "+searchKey);
		
		Set<String> allWindowsHandle = driver.getWindowHandles();				//get the id's of all windows
		System.out.println("Allwindows :"+allWindowsHandle);
		
		for(String childWindow : allWindowsHandle) {							//iterating over the all windows 
																				//childwindow stores the starting id of the window from set
			if(!MainWindow.equalsIgnoreCase(childWindow)) {
				
				  driver.switchTo().window(childWindow);
				  
				  ProductDeleteWinHandlePage win_handle = PageFactory.initElements(driver, ProductDeleteWinHandlePage.class);
				  win_handle.testCart(searchKey);
				  
				 /* System.out.println("Title of current page :"+driver.getTitle());
				
				  driver.findElement(By.id("add-to-cart-button")).click();					//add to cart button
				  System.out.println("product added to cart");
				  driver.findElement(By.id("nav-cart")).click();							//main cart button 
				  
				  driver.close();	*/

			}
		}
			driver.switchTo().window(MainWindow);
	}

}
