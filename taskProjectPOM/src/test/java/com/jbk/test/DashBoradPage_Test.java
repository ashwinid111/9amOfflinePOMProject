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

import com.aventstack.extentreports.ExtentTest;
import com.jbk.pages.DashBoradPage;
import com.jbk.testClasses.TestBase;

public class DashBoradPage_Test extends TestBase {

	WebDriver driver;
	DashBoradPage dp;
	String pageName = "DashBoradPage TESTCASES";
	String extentReprtName = "DashBoradPageExtentReport";
	String hostName = "Offline Website";
	String environment = "DashBoradPage Testing";
	String uName = "Sunil";
	String docTitle = "DashBoradPageTesting";
	String reportName = "DashBoradPageExtentReport ";

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
		System.out.println("Sunil");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		// driver.findElement(By.xpath("//a[text()='Register a new
		// membership']")).click();
		dp = new DashBoradPage(driver);
	}

	@AfterSuite
	public void close_Browser() {
		driver.close();

	}

	@Test(priority = 1)
	public void test_DashBoardTitle() {
		testLogs().info("i am in dashboardpage_test......Hello");
		ExtentTest test1 = testPrePage.createNode("TestCase Name.....test_DashBoardTitle");
		Assert.assertTrue(dp.verifyTitleOfPage(test1));
	}

	@Test(priority = 2)
	public void test_LogoutText() {
		ExtentTest test2 = testPrePage.createNode("TestCase Name.....test_LogoutText");
		Assert.assertTrue(dp.verifyLogoutLabel(test2));
	}

	@Test(priority = 3)
	public void test_PageHeaderPageText() {
		ExtentTest test3 = testPrePage.createNode("TestCase Name.....test_PageHeaderPageText");
		Assert.assertTrue(dp.verifyHeader(test3));
	}

	@Test(priority = 4)
	public void test_CoursesHeaders() {
		ExtentTest test4 = testPrePage.createNode("TestCase Name.....test_CoursesHeaders");
		Assert.assertTrue(dp.verifyCourseHeaders(test4));
	}

	@Test(priority = 5)
	public void test_NumberOfCourses() {
		ExtentTest test5 = testPrePage.createNode("TestCase Name.....test_NumberOfCourses");
		Assert.assertTrue(dp.verifyNumberOfCourses(test5));
	}

	@Test(priority = 6)
	public void test_AllCoursesLinks() {
		ExtentTest test6 = testPrePage.createNode("TestCase Name.....test_AllCoursesLinks");
		Assert.assertTrue(dp.verifyAllCourseslinks(test6));
	}

	@Test(priority = 7)
	public void test_CoursesNames() {
		ExtentTest test7 = testPrePage.createNode("TestCase Name.....test_CoursesNames");
		Assert.assertTrue(dp.verifyCourseNames(test7));
	}
}
