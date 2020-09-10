package com.jbk.pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.jbk.repository.RegistrationPageRepository;

public class Registration_Page extends RegistrationPageRepository{
	WebDriver driver;

	/*
	 * @FindBy(xpath="//a[text()='Register a new membership']") public WebElement
	 * resister;
	 */

	

	public Registration_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enter_Sname(String Name) {
		sName.sendKeys(Name);

	}

	public void enter_Smobile(String mobile) {
		sMobile.sendKeys(mobile);

	}

	public void enter_Semail(String email) {
		sEmail.sendKeys(email);

	}

	public void enter_Spassword(String password) {
		spassword.sendKeys(password);

	}

	public void click_On_SignInButton() {
		signIn_Button.click();

	}

	public boolean validate_Alert_Message() {

		enter_Sname("Sunil");
		enter_Smobile("8798654322");
		enter_Semail("himgire@gmail.com");
		enter_Spassword("Punam@2020");

		try {
			click_On_SignInButton();
			Alert al = driver.switchTo().alert();
			String actual = al.getText();
			String expected = "User registered successfully.";
			al.accept();
			System.out.println(actual);
			Assert.assertEquals(actual, expected);
			return true;
		} catch (Throwable e) {
			return false;
		}
	}
	
	public boolean validateNoOf_textboxes() {
		try {
		List<WebElement> textboxeslist = driver.findElements(By.xpath("//input"));
		if(textboxeslist.size() == 4) {
			return true;
		}
		
		else {
			return false;
			
		}
		
		
		}catch(Throwable t) {
			System.out.println("Count of text boxes is not match");
			return false;
			
		}
		
		
		
		
	}

}
	


