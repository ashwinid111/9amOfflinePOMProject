package com.jbk.repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPageRepository {
	WebDriver driver;
	@FindBy(id = "email")
	public WebElement Email;
	@FindBy(id = "password")
	public WebElement Password;
	@FindBy(xpath = "//button")
	public WebElement LoginButton;
	@FindBy(xpath = "//a[contains(@href,'users.html')]")
	public WebElement Users;
	@FindBy(xpath = "//table[@class='table table-hover']//child::tr//td[1]")
	public List<WebElement> SRSortList;
	@FindBy(xpath = "//tr//th")
	public List<WebElement> Headers;
	@FindBy(xpath = "//td[8]")
	public List<WebElement> DeleteButton;
	@FindBy(xpath = "td[3]")
	public List<WebElement> Domain;
	@FindBy(xpath = "//button[text()=\"Add User\"]")
	public WebElement AddUser;
	@FindBy(xpath = "//li[@class=\"dropdown user user-menu\"]")
	public WebElement LogOut;
	@FindBy(xpath = "//td[6]")
	public List<WebElement> Gender;
}
