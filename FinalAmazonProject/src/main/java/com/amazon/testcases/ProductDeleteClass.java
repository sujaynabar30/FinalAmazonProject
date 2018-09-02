package com.amazon.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author sujay_nabar
 * This class is used for deleting the product from the class
 */
public class ProductDeleteClass {
	
	public void prodDelete(WebDriver driver)
	{
		driver.findElement(By.id("nav-cart")).click();	  					//click cart button
		driver.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]/div[2]/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input")).click();
		//*[@id="activeCartViewForm"]/div[2]/div[2]/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input
		System.out.println("product deleted");									//xpath of the delete button 
    
        driver.findElement(By.xpath("//*[@id=\"nav-logo\"]/a[1]/span[1]")).click();        //click amazon icon at uppper left
    
	}
}
