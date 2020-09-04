package com.jbk.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadPageRepo {
	@FindBy(xpath = "//input[@id='email']")
	public WebElement emails;
	@FindBy(xpath ="//input[@id='password']")
	public WebElement password;
	@FindBy(xpath="//*[@type='submit']")
	public WebElement signIn;
	@FindBy(xpath="//span[text()='Downloads']")
	public WebElement downloadmenu;
	@FindBy(xpath="//table[@class='table table-hover']")	
	WebElement webtable;
	@FindBy(xpath ="//a[contains(text(),'LOGOUT')]")
	public WebElement Logout;
	@FindBy(xpath="//tr[2]/td[5]/a")
	public WebElement jdksetup;
	@FindBy(xpath="//tr[5]/td[5]/a")
	public WebElement googlecromedriver;
	@FindBy(xpath="//tr[7]/td[5]/a")
	public WebElement mozeladriversetup;
	@FindBy(xpath="//tr[8]/td[5]/a")
	public WebElement Geokodriversetup;
	@FindBy(xpath="//ol/li[1]/a")
	public WebElement Homemenu;
	
}
