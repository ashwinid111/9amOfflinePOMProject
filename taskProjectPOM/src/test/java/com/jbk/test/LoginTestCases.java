package com.jbk.test;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.jbk.pages.LoginPage;
import com.jbk.testClasses.TestBase;

public class LoginTestCases extends TestBase{
	
	LoginPage lp = null;
	
	String pageName = "LOGIN PAGE TESTCASES";
	String extentReprtName = "LoginPageExtentReport";
	String hostName = "Offline Website";
	String environment = "Login Page Testing";
	String uName = "Vaibhav";
	String docTitle = "LoginPage";
	String reportName = "LoginPageExtentReport ";
	
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
	public void loadUrl() throws Throwable {
		driver=super.launchApplication();
		lp = new LoginPage(driver);
	}
	

	// 1.Test url of page
		@Test(priority = 1)
		public void urlTest() {
			ExtentTest test1=testPrePage.createNode("TestCase Name.....urlTest");
			Assert.assertTrue(lp.validateURL(driver,test1));
		}

		// 2.Test Title of page
		@Test(priority = 2)
		public void checkTitle() {
			ExtentTest test2=testPrePage.createNode("TestCase Name.....checkTitle");
			Assert.assertTrue(lp.checkTitle(driver, test2));
		}

		// 3.Test Logo of page
		@Test(priority = 3)
		public void logoTest() {
			ExtentTest test3=testPrePage.createNode("TestCase Name.....logoTest");
			Assert.assertTrue(lp.validateLogo(test3));
		}

		// 4.Test Heading
		@Test(priority = 4)
		public void checkHeading() {
			ExtentTest test4=testPrePage.createNode("TestCase Name.....checkHeading");
			Assert.assertTrue(lp.checkHeading(test4));
		}

		// 5.Test Sub-title
		@Test(priority = 5)
		public void subTitleTest() {
			ExtentTest test5=testPrePage.createNode("TestCase Name.....subTitleTest");
			Assert.assertTrue(lp.validateSubTitle(test5));
		}

		// 6.Test Login Box header message
		@Test(priority = 6)
		public void checkLoginBoxMsg() {
			ExtentTest test6=testPrePage.createNode("TestCase Name.....checkLoginBoxMsg");
			Assert.assertTrue(lp.checkLoginMsg(test6));
		}

		// 7.Test Username is enabled or not
		@Test(priority = 7)
		public void userNameBoxTest() {
			ExtentTest test7=testPrePage.createNode("TestCase Name.....userNameBoxTest");
			Assert.assertTrue(lp.validateUseNameTextBox(test7));
		}

		// 8.Test Password is Enable or not?
		@Test(priority = 8)
		public void passWordBoxTest() {
			ExtentTest test8=testPrePage.createNode("TestCase Name.....passWordBoxTest");
			Assert.assertTrue(lp.validatePassWordTextBox(test8));
		}

		// 9.Test Login Button is Enabled or not?
		@Test(priority = 9)
		public void loginButtonTest() {
			ExtentTest test9=testPrePage.createNode("TestCase Name.....loginButtonTest");
			Assert.assertTrue(lp.validateLoginButton(test9));
		}

		// 10.Test Login scenario
		@Test(priority = 10)
		public void loginTest() {
			ExtentTest test10=testPrePage.createNode("TestCase Name.....loginTest");
			Assert.assertTrue(lp.validateLogin(driver, test10));
		}

		// 11.Test wrong Username Error Message
		@Test(priority = 11)
		public void userNameMessageTest() {
			ExtentTest test11=testPrePage.createNode("TestCase Name.....userNameMessageTest");
			Assert.assertTrue(lp.validateUserNameMessage(driver, test11));
		}

		// 12.Test wrong password Error Message
		@Test(priority = 12)
		public void passwordMessageTest() {
			ExtentTest test12=testPrePage.createNode("TestCase Name.....passwordMessageTest");
			Assert.assertTrue(lp.validatePasswordMessage(test12));
		}

		// 13.Test Navigation to login page from Registration page.
		@Test(priority = 13)
		public void checkNavigationBetRegPageAndLogin() {
			ExtentTest test13=testPrePage.createNode("TestCase Name.....checkNavigationBetRegPageAndLogin");

			Assert.assertTrue(lp.navigateToLoginFromReg(driver, test13));
		}

		@AfterMethod
		public void closeApplication() {
			super.CloseLaunchApplication();
		}

}
