package com.jbk.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageRepository {

	@FindBy(xpath = "//img")
	public WebElement logo;

	@FindBy(xpath = "/html/body/div/div[1]/a/h4")
	public WebElement subTitle;

	
	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//button")
	public WebElement loginButton;

	@FindBy(xpath = "//div[contains(text(),'Please enter')]")
	public WebElement userNameErrorMessage;
	
	@FindBy(xpath = "//div[@id='password_error']")
	public WebElement passWordErrorMessage;
		
	@FindBy(xpath = "//a[text()='I already have a membership']")
	public WebElement alreadymember;

	@FindBy(xpath = "//a[text()='Register a new membership']")
	public WebElement regLink;

	@FindBy(tagName = "b")
	public WebElement websiteName;

	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	public WebElement LoginMsg;

	@FindBy(xpath = "//a[text()='LOGOUT']")
	public WebElement logout;

	@FindBy(xpath = "//p[text()='Logout successfully']")
	public WebElement logoutMsg;

	@FindBy(xpath = "//div[text()='Please enter email.']")
	public WebElement ErrorMsgForInvalidMail;

}
