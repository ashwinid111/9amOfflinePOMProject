package com.jbk.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageRepository {
	
	@FindBy(xpath = "//input[@id='name']")
	public WebElement sName;

	@FindBy(xpath = "//input[@id='mobile']")
	public WebElement sMobile;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement sEmail;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement spassword;

	@FindBy(xpath = "//button[text()='Sign In']")
	public WebElement signIn_Button;

	@FindBy(xpath = "//input")
	public WebElement text_Boxes;

}
