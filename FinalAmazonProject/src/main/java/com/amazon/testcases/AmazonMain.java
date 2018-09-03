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
 * @author sujay_nabar This is a test case Class where all test cases are
 *         executed from this class
 */

public class AmazonMain extends VerifyProductPage {

	public WebDriver driver;

	@BeforeTest
	public void beforeTest()
			throws InitializationFailedException, WinAPICallFailedException, IOException, InterruptedException {
		Filesmethods credel = new Filesmethods();
		credel.createFile();
		MainClass.security();
		ReadConfigfile r = new ReadConfigfile();
		driver = BrowserFactory.startBrowser(r.getBrowser(), r.getUrl());
	}

	@Test
	public void verifylogin() {
		VerifyAmazonLogin login = new VerifyAmazonLogin(driver);
		ReadConfigfile r = new ReadConfigfile();
		login.verifyValidLogin(r.getEmailId(), r.getPassword());
	}

	// @Test(dataProvider = "SearchProvider", dataProviderClass = DataproviderClass.class)
	@Test(dependsOnMethods = { "login" }, dataProvider = "SearchProvider", dataProviderClass = DataproviderClass.class)
	public void proudctPage(String key) throws InterruptedException {
		testProductPage(key, driver);
	}
	
	  @Test(dependsOnMethods= {"proudctPage"}) public void productDelete() {
	  VerifyProductDelete proddelcart = new VerifyProductDelete();
	  proddelcart.prodDelete(driver); 
	  }
	  
	  @Test(dependsOnMethods= {"productDelete"}) public void mousehover() {
	  FilteringMouseHover mouse = new FilteringMouseHover(driver);
	  mouse.filterMouseHover(); 
	  }
	 

	@AfterTest()
	public void afterTest() {
		Filesmethods credel = new Filesmethods();
		credel.deleteFile();
		driver.quit();
	}

}
