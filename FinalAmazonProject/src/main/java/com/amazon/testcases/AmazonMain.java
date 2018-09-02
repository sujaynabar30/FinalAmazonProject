package com.amazon.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.browserinit.BrowserFactory;
import com.amazon.mousehover.FilteringMouseHover;
import com.github.windpapi4j.InitializationFailedException;
import com.github.windpapi4j.WinAPICallFailedException;
import com.psl.createfile.Filesmethods;
import com.psl.main.MainClass;
import com.psl.read.ReadConfigfile;

/**
 * 
 * @author sujay_nabar
 * This is a test case Class where all test cases are executed from this class
 */

public class AmazonMain extends ProductPage {
	
	public WebDriver driver;
	Filesmethods credel = new Filesmethods();
	 	
	@BeforeTest
	public void beforeTest() throws InitializationFailedException, WinAPICallFailedException, IOException
	{
    	 credel.createFile();
		 MainClass.security();		
		 driver = BrowserFactory.startBrowser(ReadConfigfile.getBrowser(),ReadConfigfile.getUrl());
	}
	
	@Test
	public void login()
	{
		VerifyAmazonLogin login = new VerifyAmazonLogin(driver);
		login.verifyValidLogin(ReadConfigfile.getEmailId(),ReadConfigfile.getPassword());
	}
	
	/*@Test(dependsOnMethods={"login"},dataProvider = "SearchProvider", dataProviderClass = DataproviderClass.class)
	public void proudctPage(String key) throws InterruptedException {
		//Thread.sleep(3000);
		testMethod(key,driver);			
	}
	
	@Test(dependsOnMethods= {"proudctPage"})
	public void productDelete()
	{
		ProductDeleteClass proddelcart = new ProductDeleteClass();
		proddelcart.prodDelete(driver);
	}
	
	@Test(dependsOnMethods= {"productDelete"})
	public void mousehover()
	{
		FilteringMouseHover mouse = new FilteringMouseHover(driver);
		mouse.filterMouseHover();		
	}*/
	
	@AfterTest()
	public void afterTest()
	{
		credel.deleteFile();
		driver.quit();
	}
		
}
