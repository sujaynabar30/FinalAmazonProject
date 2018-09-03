package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	
	WebDriver driver;

	public ProductPage(WebDriver localdriver) {
		this.driver = localdriver;
	}
	
	@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
	@CacheLookup
	WebElement searchbar;
	
	@FindBy(className="nav-input")
	@CacheLookup
	WebElement searchbutton;
	
	public void searchproduct(String searchKey) {
		
		System.out.println("dataprovided key is :"+searchKey);
		searchbar.clear();
		searchbar.sendKeys(searchKey);
		searchbutton.click();
		
	}
	
	
}
