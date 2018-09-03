package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * 
 * @author sujay_nabar
 * This class will store all the locators and methods of Product Delete page
 *
 */

public class ProductDeleteWinHandlePage {
	
	WebDriver driver;
	
	public ProductDeleteWinHandlePage(WebDriver localdriver) {
		this.driver = localdriver;
	}
	
	@FindBy(id="nav-cart")
	@CacheLookup
	WebElement cartbutton;
	
	@FindBy(xpath="//*[@id=\"activeCartViewForm\"]/div[2]/div[2]/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input")
	@CacheLookup
	WebElement deletebutton;
	
	@FindBy(xpath="//*[@id=\"nav-logo\"]/a[1]/span[1]")
	@CacheLookup
	WebElement icon;
	
	@FindBy(id="add-to-cart-button")
	@CacheLookup
	WebElement addtocartbutton;
	
	public void productdelete()
	{
		cartbutton.click();
		deletebutton.click();
		System.out.println("product deleted");
		icon.click();
	}
	
	public void testCart(String searchKey){
		
		 System.out.println("Title of current page :"+driver.getTitle());
		 addtocartbutton.click();
		 System.out.println("product added to cart");
		 cartbutton.click();
		 
		 Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
		 
		//System.out.println("search key reached here is :"+searchKey);
		
		String statement = driver.findElement(By.linkText(searchKey)).getText(); 
		
		Assert.assertEquals(statement, searchKey);    //asserting for cart if prod is not there in cart it will fail 
		
		if(statement.equals(searchKey)) {
		System.out.println("Assert is successful");}
		
		 driver.close();
		 
	}
	
}
