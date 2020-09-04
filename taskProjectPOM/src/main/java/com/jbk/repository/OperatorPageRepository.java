package com.jbk.repository;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class OperatorPageRepository {
//xpath
	WebDriver driver;
	@FindBy(id = "email")
	public WebElement email;
	@FindBy(id = "password")
	public WebElement password;
	@FindBy(xpath = "//button")
	public WebElement loginButton;
	@FindBy (xpath = "//span[text()='Operators']")
	public WebElement operators;
	@FindBy(xpath = "//td[text()='Enquiry(Course Details, Fees, Enquiry)']")
	public WebElement tableCell;
	@FindBy(xpath = "//td[2]")
	public List<WebElement> tablePersonList;
	@FindBy(xpath = "//tr//th")
	public List<WebElement> headers;
	@FindBy(xpath = "//table[@class='table table-hover']//child::tr//td[1]")
	public List<WebElement> tableRow;
	/*@FindBy(xpath = "//h3[text()='Operator List']")
	private WebElement operatorlist;
	@FindBy(xpath = "//tr[1]")
	WebElement header;*/
}
