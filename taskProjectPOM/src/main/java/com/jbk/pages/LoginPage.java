package com.jbk.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.jbk.repository.LoginPageRepository;
import com.jbk.testClasses.TestBase;

public class LoginPage extends LoginPageRepository {

	public static WebDriver driver;
	TestBase tb = new TestBase();

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 1.Validate url of Page
	public boolean validateURL(WebDriver driver) {

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
	public boolean checkTitle(WebDriver driver) {
		if (driver.getTitle().equals("JavaByKiran | Log in")) {
			System.out.println("We are on Login Page!!");
			return true;
		} else {
			System.out.println("We should be on Login Page!!");
			return false;
		}
	}

	// 3.Validate Logo of a page
	public boolean validateLogo() {

		boolean flag = logo.isDisplayed();

		if (flag == true) {
			System.out.println("Logo is Displayed");
			return true;

		} else {
			System.out.println("Logo is not Displayed");
			return false;
		}
	}

	// 4.Validate Heading
	public boolean checkHeading() {
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
	public boolean validateSubTitle() {

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
	public boolean checkLoginMsg() {
		String loginmsg = LoginMsg.getText();
		if (loginmsg.equals("Sign in to start your session")) {
			System.out.println("Login msg- Sign in to start your session is displayed correctly.");
			return true;
		}
		System.out.println("Loginmsg should display as- 'Sign in to start your session'");
		return false;
	}

	// 7.validate username text box is enabled
	public boolean validateUseNameTextBox() {

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
	public boolean validatePassWordTextBox() {

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
	public boolean validateLoginButton() {

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
	public boolean validateLogin(WebDriver driver) {

		username.sendKeys(tb.readAnyProperty("uName"));
		password.sendKeys(tb.readAnyProperty("passW"));
		loginButton.click();

		String actHomePageTitle = driver.getTitle();
		System.out.println(actHomePageTitle);
		String expHomePageTitle = "JavaByKiran | Dashboard";

		if (expHomePageTitle.equals(actHomePageTitle)) {
			System.out.println("Login into application is successful");
			return true;

		} else {
			System.out.println("Login into application is un-successful");
			return false;
		}
	}

	// 11.Validate wrong Username Error Message
	public boolean validateUserNameMessage(WebDriver driver) {

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

	// 11.Validate wrong password Error Message
	public boolean validatePasswordMessage() {

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

	// 12.Validate login-logout Scenario
	public boolean validateLoginLogout() {

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

	// 13.Validate Navigation to login page from Registration page.
	public boolean navigateToLoginFromReg(WebDriver driver) {
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
