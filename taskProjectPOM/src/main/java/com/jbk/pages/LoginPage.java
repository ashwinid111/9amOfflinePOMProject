package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.jbk.repository.LoginPageRepository;
import com.jbk.testClasses.TestBase;

public class LoginPage extends LoginPageRepository {

	public static WebDriver driver;
	TestBase tb = new TestBase();

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 1.Validate url of Page
	public boolean validateURL(WebDriver driver,ExtentTest test1) {
		test1.info("First Test Case Validate url of Page");

		String actUrl = driver.getCurrentUrl();
		// System.out.println(actUrl);
		String expUrl = "file:///C:/Offline%20Website/index.html";

		if (expUrl.equals(actUrl)) {
			System.out.println("URL Matched");
			return true;

		} else {
			System.out.println("URL not Matched");
			return false;
		}
	}

	// 2.Validate Title of a Page
	public boolean checkTitle(WebDriver driver,ExtentTest test2) {
		test2.info("Second Test Case Validate Title of Page");

		if (driver.getTitle().equals("JavaByKiran | Log in")) {
			System.out.println("We are on Login Page!!");
			return true;
		} else {
			System.out.println("We should be on Login Page!!");
			return false;
		}
	}

	// 3.Validate Logo of a page
	public boolean validateLogo(ExtentTest test3) {
		test3.info("Third Test Case Validate Logo of Page");
		test3.info("Validatelogo is display or not..");
		boolean flag = logo.isDisplayed();

		if (flag == true) {
			test3.info("Logo is Displayed");
			System.out.println("Logo is Displayed");
			return true;

		} else {
			test3.info("Logo is not Displayed");
			System.out.println("Logo is not Displayed");
			return false;
		}
	}

	// 4.Validate Heading
	public boolean checkHeading(ExtentTest test4) {
		test4.info("Fourth Test Case Validate Heading of Page");
		String actHeading = websiteName.getText();
		if (actHeading.equals("Java By Kiran")) {

			System.out.println("Heading is -Java By Kiran ");
			return true;
		} else {

			System.out.println("Heading is invalid. It should be- Java By Kiran");
			return false;
		}

	}

	// 5.Validate Sub-Title
	public boolean validateSubTitle(ExtentTest test5) {
		test5.info("Fifth Test Case Validate Sub-Title of Page");

		String actSubTitle = subTitle.getText();
		String expSubTitle = "JAVA | SELENIUM | PYTHON";

		if (expSubTitle.equals(actSubTitle)) {
			System.out.println("Login Button is Displayed");
			return true;

		} else {
			System.out.println("Login Button is Displayed");
			return false;
		}
	}

	// 6.Validate Login Box header
	public boolean checkLoginMsg(ExtentTest test6) {
		test6.info("Sixth Test Case Validate Login Box Header of Page");
		String loginmsg = LoginMsg.getText();
		if (loginmsg.equals("Sign in to start your session")) {
			System.out.println("Login msg- Sign in to start your session is displayed correctly.");
			return true;
		}
		System.out.println("Loginmsg should display as- 'Sign in to start your session'");
		return false;
	}

	// 7.validate username text box is enabled
	public boolean validateUseNameTextBox(ExtentTest test7) {
		test7.info("Seventh Test Case Validate username text box is enabled");

		boolean flag = username.isEnabled();

		if (flag == true) {
			System.out.println("UserName Box is Displayed");
			return true;

		} else {
			System.out.println("UserName Box is not Displayed");
			return false;
		}
	}

	// 8.validate password text box is enabled
	public boolean validatePassWordTextBox(ExtentTest test8) {
		test8.info("Eight Test Case Validate Password text box is enabled");

		boolean flag = password.isEnabled();

		if (flag == true) {
			System.out.println("Pssword Box is Displayed");
			return true;

		} else {
			System.out.println("Pssword Box is not Displayed");
			return false;
		}
	}

	// 9.validate login button is enabled
	public boolean validateLoginButton(ExtentTest test9) {
		test9.info("Nineth Test Case Validate Login Button is enabled");

		boolean flag = loginButton.isEnabled();

		if (flag == true) {
			System.out.println("Login Button is Displayed");
			return true;

		} else {
			System.out.println("Login Button is not Displayed");
			return false;
		}
	}

	// 10.Validate login Scenario
	public boolean validateLogin(WebDriver driver,ExtentTest test10) {
		test10.info("Tenth Test Case Validate Login Scenario of a Page");
		test10.info("Please Enter value of id and pswd..");
		username.sendKeys(tb.readAnyProperty("uName"));
		password.sendKeys(tb.readAnyProperty("passW"));
		loginButton.click();
		test10.info("After click login button");
		String actHomePageTitle = driver.getTitle();
		test10.info("Check title.."+actHomePageTitle);
		String expHomePageTitle = "JavaByKiran | Dashboard";

		if (expHomePageTitle.equals(actHomePageTitle)) {
			test10.info("Login into application is successful");
			return true;

		} else {
			test10.info("Login into application is un-successful");
			return false;
		}
	}

	// 11.Validate wrong Username Error Message
	public boolean validateUserNameMessage(WebDriver driver,ExtentTest test11) {
		test11.info("Eleventh Test Case Validate Wrong username Error message");
		username.sendKeys("jbk@gmail.com");
		password.sendKeys("123456");
		loginButton.click();

		String actErrorMessage = userNameErrorMessage.getText();
		System.out.println(actErrorMessage);
		String expErrorMessage = "Please enter email as kiran@gmail.com";

		if (expErrorMessage.equals(actErrorMessage)) {
			System.out.println("Correct UserName-error message");
			return true;

		} else {
			System.out.println("Wrong UserName-error message");
			return false;
		}
	}

	// 12.Validate wrong password Error Message
	public boolean validatePasswordMessage(ExtentTest test12) {
		test12.info("Twelth Test Case Validate Wrong Password Message");

		username.sendKeys("jbk@gmail.com");
		password.sendKeys("   ");
		loginButton.click();

		String actErrorMessage = passWordErrorMessage.getText();
		System.out.println(actErrorMessage);
		String expErrorMessage = "Please enter password 123456";

		if (expErrorMessage.equals(actErrorMessage)) {
			System.out.println("Correct Password-error message");
			return true;

		} else {
			System.out.println("Wrong Password-error message");
			return false;
		}
	}

	// 13.Validate login-logout Scenario
	public boolean validateLoginLogout(ExtentTest test13) {
		test13.info("Thirteenth Test Case Validate Login-Logout Scenario");

		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		loginButton.click();
		logout.click();

		String actLogOutMessage = logoutMsg.getText();
		System.out.println(actLogOutMessage);
		String expLogOutMessage = "Logout successfully";

		if (expLogOutMessage.equals(actLogOutMessage)) {
			System.out.println("Correct LogOut message");
			return true;

		} else {
			System.out.println("Wrong LogOut message");
			return false;
		}
	}

	// 14.Validate Navigation to login page from Registration page.
	public boolean navigateToLoginFromReg(WebDriver driver,ExtentTest test14) {
		test14.info("fourteeenth Test Case Validate Navigation to login page from Registration page");
		regLink.click();
		alreadymember.click();

		if (driver.getTitle().equals("JavaByKiran | Log in")) {

			System.out.println("Navigated to login page from registration page successful");
			return true;
		} else

			System.out.println("navigate to login page from registration page un-successful.");
		return false;
	}

}
