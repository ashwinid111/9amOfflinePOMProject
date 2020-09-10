package com.jbk.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.jbk.pages.DashBoradPage;
import com.jbk.testClasses.TestBase;

public class DashBoradPage_Test extends TestBase{
	
	WebDriver driver ;
	DashBoradPage dp;
	
	
	@BeforeSuite
	public void run_First() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe ");
		 driver = new ChromeDriver();
		
		driver.get("file:///D:/JbkSoft/New%20folder/Offline%20Website/index.html");
		System.out.println("Sunil");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kiran@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//driver.findElement(By.xpath("//a[text()='Register a new membership']")).click();
		dp = new DashBoradPage(driver);
	}
	
	@AfterSuite
	public void close_Browser() {
		driver.close();
		
	}
	
	@Test(priority=0)
	public void test_DashBoardTitle() {
		testLogs().info("i am in dashboardpage_test......Hello");
		Assert.assertTrue(dp.verifyTitleOfPage());	
	}
	
	/*@Test(priority=1)
	public void test_LogoutText() {
		Assert.assertTrue(dp.verifyLogoutLabel());	
	}
	
	@Test(priority=2)
	public void test_PageHeaderPageText() {
		Assert.assertTrue(dp.verifyHeader());	
	}
	
	@Test(priority=3)
	public void test_CoursesHeaders() {
		Assert.assertTrue(dp.verifyCourseHeaders());	
	}
	
	@Test(priority=4)
	public void test_NumberOfCourses() {
		Assert.assertTrue(dp.verifyNumberOfCourses());	
	}
	
	@Test(priority=5)
	public void test_AllCoursesLinks() {
		Assert.assertTrue(dp.verifyAllCourseslinks());	
	}
	
	@Test(priority=6)
	public void test_CoursesNames() {
		Assert.assertTrue(dp.verifyCourseNames());	
	}*/
}
