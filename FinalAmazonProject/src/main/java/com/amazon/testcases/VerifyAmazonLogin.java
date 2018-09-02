package com.amazon.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.browserinit.BrowserFactory;
import com.amazon.pages.LoginPage;

/**
 * 
 * @author sujay_nabar
 * 
 * This is a class used for the logging-in of the user
 */

public class VerifyAmazonLogin {
	
	 WebDriver driver; 
	
	public VerifyAmazonLogin(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void verifyValidLogin(String username, String pass)
	{
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.get("https://www.amazon.in/");
																								//page object model
		LoginPage login = new LoginPage(driver);
		
		login.clickCart();
		login.typeEmail();
		driver.findElement(By.id("continue")).click();				
		login.typePassword();
		login.clickLogin();*/
		

		//WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.amazon.in/");   //this will launch the browser and specific url
		
		/*File file = new File("C:\\Users\\Sujay\\git\\AssignmentModified\\AmazonProject\\Configs\\Configuation.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);        //created page object using page factory
		
		login_page.loginToAmazon(username,pass);				//call the method
		
		WebElement verify = driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[1]"));
		String check = verify.getText();
		//System.out.println(check);
		
		Assert.assertEquals(driver.getTitle(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
		if(check.equals("Hello, NABAR")) {
			System.out.println("Logged in Sucessfully");
		}
		else {
			System.out.println("Login failed.....Closing Browser");
			driver.close();
		}
	}

}
