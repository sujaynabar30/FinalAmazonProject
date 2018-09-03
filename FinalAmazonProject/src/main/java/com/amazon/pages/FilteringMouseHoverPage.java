package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FilteringMouseHoverPage {
	
	WebDriver driver;

	public FilteringMouseHoverPage(WebDriver localdriver) {
		this.driver = localdriver;
	}
	
	@FindBy(id="twotabsearchtextbox")
	@CacheLookup
	WebElement searchbox;
	
	@FindBy(className="nav-input")
	@CacheLookup
	WebElement searchbutton;
	
	@FindBy(name="s-ref-checkbox-10440599031")
	@CacheLookup
	WebElement checkbox1;
	
	@FindBy(name="s-ref-checkbox-4931671031")
	@CacheLookup
	WebElement checkbox2;
	
	@FindBy(name="s-ref-checkbox-1898707031")
	@CacheLookup
	WebElement checkbox3;
	
	@FindBy(name="s-ref-checkbox-Motorola")
	@CacheLookup
	WebElement checkbox4;
	
	@FindBy(id="low-price")
	@CacheLookup
	WebElement minprice;
	
	@FindBy(id="high-price")
	@CacheLookup
	WebElement maxprice;
	
	@FindBy(xpath="//*[@id=\"a-autoid-4\"]/span/input")
	@CacheLookup
	WebElement gobutton;
	
	@FindBy(tagName="h2")
	@CacheLookup
	WebElement link;
	
	@FindBy(id="nav-link-shopall")
	@CacheLookup
	WebElement hoverTabs;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[6]/span")
	@CacheLookup
	WebElement hoverTabslink;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-shopAll\"]/div[3]/div[6]/div[1]/div/a[2]/span")
	@CacheLookup
	WebElement clickele;
	
	public void sortMouseHover() {
		
		searchbox.sendKeys("mobiles");
		searchbutton.click();
		
		checkbox1.click();
		System.out.println("checkbox 1 checked");
		driver.navigate().refresh();
		
		checkbox2.click();
		System.out.println("checkbox 2 checked");
		driver.navigate().refresh();
		
		checkbox3.click();
		System.out.println("checkbox 3 checked");
		driver.navigate().refresh();
		
		checkbox4.click();
		System.out.println("checkbox 4 checked");
		driver.navigate().refresh();
		
		minprice.sendKeys("10000");
		maxprice.sendKeys("20000");
		
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.click(gobutton).build();
		mouseOverHome.perform();
		
		List<WebElement> links = driver.findElements(By.tagName("h2"));
		
		System.out.println("\nTotal number of product found are :"+links.size()+"\n");					//get the count
		
		for (int i = 1; i<links.size(); i=i+1)		 
		{
			System.out.println(links.get(i).getText());													//get the product link names till the count
		}
		
		builder.moveToElement(hoverTabs).build().perform();
		
		builder.moveToElement(hoverTabslink).build().perform();
		
		clickele.click();
		System.out.println("\nHover overtabs is successful");	

	}
}
