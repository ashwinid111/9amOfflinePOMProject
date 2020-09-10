package com.jbk.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.jbk.pages.PageBase;

public class DashBoardPageRepository extends PageBase {
	
	@FindBy(linkText = "LOGOUT")
	public WebElement logoutLable;

	@FindBy(xpath = "//div//child::h1//small[contains(text(),'Courses Offered')]")
	public WebElement dashboardHeader;

	@FindBy(xpath = "//section[@class='content']//a")
	public List<WebElement> courselinks;

	@FindBy(xpath = "//div//h3")
	public List<WebElement> courseHeaders; 

	@FindBy(xpath ="//div//h3//following::p")
	public List<WebElement> coursenames;
	

}
