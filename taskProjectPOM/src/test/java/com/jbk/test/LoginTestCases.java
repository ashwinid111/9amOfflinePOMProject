package com.jbk.test;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.pages.LoginPage;
import com.jbk.testClasses.TestBase;

public class LoginTestCases extends TestBase{
	
	LoginPage lp = null;

	@BeforeMethod
	public void loadUrl() throws Throwable {
		driver=super.launchApplication();
		lp = new LoginPage(driver);
	}
	

	// 1.Test url of page
		@Test(priority = 1)
		public void urlTest() {
			Assert.assertTrue(lp.validateURL(driver));
		}

		// 2.Test Title of page
		@Test(priority = 2)
		public void checkTitle() {
			Assert.assertTrue(lp.checkTitle(driver));
		}

		// 3.Test Logo of page
		@Test(priority = 3)
		public void logoTest() {
			Assert.assertTrue(lp.validateLogo());
		}

		// 4.Test Heading
		@Test(priority = 4)
		public void checkHeading() {
			Assert.assertTrue(lp.checkHeading());
		}

		// 5.Test Sub-title
		@Test(priority = 5)
		public void subTitleTest() {
			Assert.assertTrue(lp.validateSubTitle());
		}

		// 6.Test Login Box header message
		@Test(priority = 6)
		public void checkLoginBoxMsg() {
			Assert.assertTrue(lp.checkLoginMsg());
		}

		// 7.Test Username is enabled or not
		@Test(priority = 7)
		public void userNameBoxTest() {
			Assert.assertTrue(lp.validateUseNameTextBox());
		}

		// 8.Test Password is Enable or not?
		@Test(priority = 8)
		public void passWordBoxTest() {
			Assert.assertTrue(lp.validatePassWordTextBox());
		}

		// 9.Test Login Button is Enabled or not?
		@Test(priority = 9)
		public void loginButtonTest() {
			Assert.assertTrue(lp.validateLoginButton());
		}

		// 10.Test Login scenario
		@Test(priority = 10)
		public void loginTest() {
			Assert.assertTrue(lp.validateLogin(driver));
		}

		// 11.Test wrong Username Error Message
		@Test(priority = 11)
		public void userNameMessageTest() {
			Assert.assertTrue(lp.validateUserNameMessage(driver));
		}

		// 12.Test wrong password Error Message
		@Test(priority = 12)
		public void passwordMessageTest() {
			Assert.assertTrue(lp.validatePasswordMessage());
		}

		// 13.Test Navigation to login page from Registration page.
		@Test(priority = 13)
		public void checkNavigationBetRegPageAndLogin() {
			Assert.assertTrue(lp.navigateToLoginFromReg(driver));
		}

		@AfterMethod
		public void closeApplication() {
			super.CloseLaunchApplication();
		}

}
