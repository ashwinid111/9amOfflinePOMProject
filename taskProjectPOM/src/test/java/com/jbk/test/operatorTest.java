package com.jbk.test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.jbk.pages.operator;
import com.jbk.testClasses.TestBase;
public class operatorTest extends TestBase {
	WebDriver driver;
	operator OP;
	String pageName = "OPERATOR PAGE TESTCASES";
	String extentReprtName = "OperatorPageExtentReport";
	String hostName = "Offline Website";
	String environment = "Operators Page Testing";
	String uName = "Shailesh";
	String docTitle = "OperatorPage";
	String reportName = "OperatorPageExtentReport ";

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
	@BeforeMethod
	public void OpenBrowser() throws Throwable {
		driver=launchApplication();
		OP = new operator(driver);
		OP.NavigateToAddUserPage();
	}
	@AfterMethod
	public void closeBrowser() {
		CloseLaunchApplication();
	}
	@Test(priority = 1)
	public void onecell() {
		ExtentTest test1=testPrePage.createNode("TestCase Name.....onecell");
		Assert.assertTrue((OP.onecell(test1)));
	}
	@Test(priority = 2)
	public void validateHeader() {
		ExtentTest test2=testPrePage.createNode("TestCase Name.....validateHeader");
		Assert.assertTrue(OP.validateHeader(test2));
	}
	@Test(priority = 3)
	public void validateColumn() {
		ExtentTest test3=testPrePage.createNode("TestCase Name.....validateColumn");
		Assert.assertTrue(OP.validateColumn(test3));
	}
	@Test(priority = 4)
	public void validateStartWithVendorName() {
		ExtentTest test4=testPrePage.createNode("TestCase Name.....validateStartWithVendorName");
		Assert.assertTrue(OP.checkPersonListIsSort(test4));
	}
	@Test(priority = 5)
	public void validateMobileNumbers() {
		ExtentTest test5=testPrePage.createNode("TestCase Name.....validateMobileNumbers");
		Assert.assertTrue(OP.validateContact(test5));
	}
}
