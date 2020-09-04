package com.jbk.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jbk.repository.UserPageRepository;
import com.aventstack.extentreports.ExtentTest;

public class UserPage extends UserPageRepository {
	WebDriver driver;

	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void NavigateToUserPage() {
		Email.sendKeys("kiran@gmail.com");
		Password.sendKeys("123456");
		LoginButton.click();
		Users.click();
	}
	public boolean validateSrNumberListInSort(ExtentTest test1) {
		test1.info("My First Test Case");
		ArrayList<String> actualSrNumberList = new ArrayList<String>();
		List<WebElement> elementList = SRSortList;
		for (WebElement we : elementList) {
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : actualSrNumberList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		if (sortedList.equals(actualSrNumberList)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateHeader(ExtentTest test2) {
		test2.info("My 2nd Test Case");
		List<WebElement> listHeader = Headers;
		if (listHeader.size() == 8) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateDeleteButton(ExtentTest test3) {
		test3.info("My 3rd Test Case");
		List<WebElement> delete = DeleteButton;
		for (int i = 1; i < delete.size(); i++) {
			delete.get(i).isEnabled();

		}
		return true;

	}

	public boolean validatedoamain(ExtentTest test4) {
		test4.info("My 4th Test Case");
		String exp = "@gmail.com";
		List<WebElement> expList = Domain;
		for (int i = 1; i < expList.size(); i++) {
			expList.get(i).getText().contains(exp);

		}
		return true;

	}

	public boolean clickAdduser(ExtentTest test5) {
		test5.info("My 5th Test Case");
		try {
			AddUser.click();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean validatelogout(ExtentTest test6) {
		test6.info("My 6th Test Case");
		try {
			LogOut.click();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean checkcGender(ExtentTest test7) {
		test7.info("My 7th Test Case");
		String exp = "Male";
		List<WebElement> Actual = Gender;
		for (int i = 1; i < Actual.size(); i++) {
			Actual.get(i).getText().contains(exp);

		}
		return true;

	}
}