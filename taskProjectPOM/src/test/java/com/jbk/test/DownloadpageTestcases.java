package com.jbk.test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.pages.DownloadPage;
import com.jbk.testClasses.TestBase;

public class DownloadpageTestcases extends TestBase{
	WebDriver driver = null;
	Properties prop;
	DownloadPage downloadPage = null;
	// Dashboardpage dashboardPage;
	

	Logger log = Logger.getLogger(DownloadpageTestcases.class);

	@BeforeMethod
	public void Openbroser() throws Throwable {
		/*	new code	*/	
		
		
		driver=super.launchApplication();
		/*
		 * log.info("its a chrome lounching");
		 * System.setProperty("webdriver.chrome.driver",
		 * "drivers/chromedriver.exe");//kiran1 driver = new ChromeDriver();
		 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		 * log.warn("this is page timeout");
		 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 * log.warn("this is implicitewait time");
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * driver.get(prop.getProperty("url"));
		 */
		downloadPage = new DownloadPage(driver);
		String a =prop.getProperty("username");
		String ab=prop.getProperty("password");
		downloadPage.NavigatetoDashboard(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
		public void HomemenuTest() {
		log.info("this is Home Menu test case");
			Assert.assertFalse(downloadPage.Homemenu(driver));
			
		
	}
	
	@Test(priority = 2)
	  public void bitset32clickabelornotTest() {
		  log.info("***********************bitset32clickabelornotTest Started******************* "
	  );
	  
	  Assert.assertTrue(downloadPage.avabilityOf32BitSetup(driver)); }
	  
	 	
	
	@Test(priority = 3) 
	  public void NoofsetupsinTableTest() {
	  
	  Assert.assertTrue(downloadPage.NoofsetupsinTable());
	  
	  }
	  
	@Test(priority = 4)
	  public void HeadersTest() {
	  Assert.assertTrue(downloadPage.validateHeaders());
	  
	  }
	 

	
	
	@Test(priority = 5)
	  public void vendorsListTest() {
	  
	  Assert.assertTrue(downloadPage.vendorsList(driver));
	  
	  }
	 	 

	
	@Test(priority = 6)
	  public void islogouttest() {
	  Assert.assertTrue(downloadPage.isLogout(driver)); }
	 
	/*
	 * public DownloadpageTestcases() { try {
	 * 
	 * prop = new Properties(); FileInputStream fis = new FileInputStream(
	 * System.getProperty("user.dir") + "/src/main" +
	 * "/java/com/jbk/config/configuration.properties"); prop.load(fis); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
