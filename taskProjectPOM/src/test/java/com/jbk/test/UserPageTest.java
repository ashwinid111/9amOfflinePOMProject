package com.jbk.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.jbk.pages.UserPage;
import com.aventstack.extentreports.ExtentTest;
import com.jbk.testClasses.TestBase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class UserPageTest extends TestBase {

	WebDriver driver;
	UserPage UP;
	String pageName = "USER PAGE TESTCASES";
	String extentReprtName = "UserPageExtentReport";
	String hostName = "Offline Website";
	String environment = "User Page Testing";
	String uName = "Atul";
	String docTitle = "UserPage";
	String reportName = "UserPageExtentReport ";

	@BeforeTest
	public void BeforeTest() {
		super.setReport(pageName, extentReprtName, hostName, environment, uName, docTitle, reportName);
	}

	@AfterTest
	public void AfterTest() {
		super.endReport();
	}

	@BeforeClass
	public void BeforeClass() {
		super.extenttestNode();
	}

	@BeforeMethod

	public void OpenBrowser() throws Throwable {
		driver = super.launchApplication();
		UP = new UserPage(driver);
		UP.NavigateToUserPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test
	public void validateSRSort() {
		ExtentTest test1 = testPrePage.createNode("TestCase Name.....validateSRSort");
		Assert.assertTrue(UP.validateSrNumberListInSort(test1));

	}

	@Test
	public void validateHeaderCount() {
		ExtentTest test2 = testPrePage.createNode("TestCase Name.....validateHeaderCount");
		Assert.assertTrue(UP.validateHeader(test2));

	}

	@Test
	public void validateDeleteButtonClick() {
		ExtentTest test3 = testPrePage.createNode("TestCase Name.....validateDeleteButtonClick");
		Assert.assertTrue(UP.validateDeleteButton(test3));
	}

	@Test
	public void validateDomain() {
		ExtentTest test4 = testPrePage.createNode("TestCase Name.....validateDeleteButtonClick");
		Assert.assertTrue(UP.validatedoamain(test4));
	}

	@Test
	public void validateAddUserclickable() {
		ExtentTest test5 = testPrePage.createNode("TestCase Name.....validateAddUserclickable");
		Assert.assertTrue(UP.clickAdduser(test5));
	}

	@Test
	public void validateLogout() {
		ExtentTest test6 = testPrePage.createNode("TestCase Name.....validateLogout");
		Assert.assertTrue(UP.validatelogout(test6));
	}

	@Test
	public void validateGender() {
		ExtentTest test7 = testPrePage.createNode("TestCase Name.....validateGender");
		Assert.assertTrue(UP.checkcGender(test7));
	}
}
