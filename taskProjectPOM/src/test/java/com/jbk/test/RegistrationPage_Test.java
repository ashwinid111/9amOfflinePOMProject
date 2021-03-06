package com.jbk.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.jbk.pages.Registration_Page;
import com.jbk.testClasses.TestBase;

public class RegistrationPage_Test extends TestBase {

	WebDriver driver;
	Registration_Page rp;
	String pageName = "RegistrationPage TESTCASES";
	String extentReprtName = "RegistrationPageExtentReport";
	String hostName = "Offline Website";
	String environment = "RegistrationPage Testing";
	String uName = "Sunil";
	String docTitle = "RegistrationPageTesting";
	String reportName = "RegistrationPage_TestExtentReport ";

	@BeforeTest
	public void BeforeTest() {
		setReport(pageName, extentReprtName, hostName, environment, uName, docTitle, reportName);
	}

	@AfterTest
	public void AfterTest() {
		endReport();
	}

	@BeforeClass
	public void BeforeClass() {
		extenttestNode();
	}

	@BeforeSuite
	public void run_First() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe ");
		driver = new ChromeDriver();
		driver.get("file:///D:/JbkSoft/New%20folder/Offline%20Website/index.html");
		driver.findElement(By.xpath("//a[text()='Register a new membership']")).click();
		rp = new Registration_Page(driver);
	}

	@AfterSuite
	public void close_Browser() {
		driver.close();

	}

	@Test(priority = 1)
	public void testNoOf__TextBoxes() {
		testLogs().info("print Msg......Hello");
		Assert.assertTrue(rp.validateNoOf_textboxes());
	}

	@Test(priority = 2)
	public void test_Register_SuccefullyOr_Not() {
		Assert.assertTrue(rp.validate_Alert_Message());
	}

}
