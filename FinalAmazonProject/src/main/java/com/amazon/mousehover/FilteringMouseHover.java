package com.amazon.mousehover;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * @author sujay_nabar
 * This class is used for filtering the products and using mouseHover using action builder
 */

public class FilteringMouseHover {
	

	 WebDriver driver; 
	
	public FilteringMouseHover(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void filterMouseHover() {
		// TODO Auto-generated method stub
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));           //find search box and send keys mobiles
		search.sendKeys("mobiles");
		driver.findElement(By.className("nav-input")).click();
		
		//WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"leftNavContainer\"]/ul[2]/div/li/span/span/div/label/input"));			//check prime checkbox
		WebElement checkbox1 = driver.findElement(By.name("s-ref-checkbox-10440599031"));
		checkbox1.click();
		System.out.println("checkbox 1 checked");
		driver.navigate().refresh();
		
		//WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"leftNavContainer\"]/ul[3]/div/li/span/span/div/label/input"));		    //check cod
		WebElement checkbox2 = driver.findElement(By.name("s-ref-checkbox-4931671031"));
		checkbox2.click();
		System.out.println("checkbox 2 checked");
		driver.navigate().refresh();
		
		//WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"leftNavContainer\"]/ul[6]/div/li[5]/span/span/div/label/input"));			//check camera MP
		WebElement checkbox3 = driver.findElement(By.name("s-ref-checkbox-1898707031"));
		checkbox3.click();
		System.out.println("checkbox 3 checked");
		driver.navigate().refresh();
		
		//WebElement checkbox4 = driver.findElement(By.xpath("//*[@id=\"leftNavContainer\"]/ul[11]/div/li[2]/span/span/div/label/input"));		//check brand name=moto
		WebElement checkbox4 = driver.findElement(By.name("s-ref-checkbox-Motorola"));
		//WebElement checkbox4 = driver.findElement(By.name("s-ref-checkbox-Samsung"));
		checkbox4.click();
		System.out.println("checkbox 4 checked");
		driver.navigate().refresh();
		
		/*Actions builder = new Actions(driver);
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"leftNavContainer\"]/ul[2]/div/li/span/span/div/label/input"));
		Action mouseOverHome = builder.click(checkbox1).build();
		mouseOverHome.perform();
		
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"leftNavContainer\"]/ul[3]/div/li/span/span/div/label/input"));
		Action mouseOverHome2 = builder.click(checkbox2).build();
		mouseOverHome2.perform();*/
		
		WebElement min = driver.findElement(By.id("low-price"));								//price sorting
		min.sendKeys("10000");
		
		WebElement max = driver.findElement(By.id("high-price"));
		max.sendKeys("20000");
		
		Actions builder = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//*[@id=\"a-autoid-4\"]/span/input"));				//click on go button 
		Action mouseOverHome = builder.click(button).build();
		mouseOverHome.perform();
		
		List<WebElement> links = driver.findElements(By.tagName("h2"));
		
		System.out.println("\nTotal number of product found are :"+links.size()+"\n");					//get the count
		
		for (int i = 1; i<links.size(); i=i+1)		 
		{
			System.out.println(links.get(i).getText());													//get the product link names till the count
		}

		WebElement hoverTabs = driver.findElement(By.id("nav-link-shopall"));							//hover over the categories
		builder.moveToElement(hoverTabs).build().perform();
		WebElement hoverTabslink = driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[2]/span[6]/span"));
		builder.moveToElement(hoverTabslink).build().perform();
		WebElement clickele = driver.findElement(By.xpath("//*[@id=\"nav-flyout-shopAll\"]/div[3]/div[6]/div[1]/div/a[2]/span"));
		clickele.click();
		//builder.moveToElement(hoverTabs).moveToElement(hoverTabslink).moveToElement(driver.findElement(By.linkText("All Mobile Accessories"))).click().build().perform();
		//System.out.println("mouse on the shopbycategory");
		System.out.println("\nHover overtabs is successful");
	}
}
