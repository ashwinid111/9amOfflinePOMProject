package com.jbk.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.jbk.repository.OperatorPageRepository;

public class operator extends OperatorPageRepository {

	public operator(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void NavigateToAddUserPage() {
		email.clear();
		email.sendKeys("kiran@gmail.com");
		password.clear();
		password.sendKeys("123456");
		loginButton.click();
		operators.click();
	}

	public boolean onecell(ExtentTest test1) {
		test1.info("My First Test Case");
		String actPerson = tableCell.getText();
		String expPerson = "Enquiry(Course Details, Fees, Enquiry)";
		if (actPerson.equals(expPerson)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateHeader(ExtentTest test2) {
		test2.info("My Second Test Case");
		List<WebElement> listOfHeader = headers;
		if (listOfHeader.size() == 6) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateColumn(ExtentTest test3) {
		test3.info("My Third Test Case");
		List<WebElement> listOfColumn = tableRow;
		if (listOfColumn.size() == 5) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkPersonListIsSort(ExtentTest test4) {
		test4.info("My Fourth Test Case");
		ArrayList<String> actualWebList = new ArrayList<>();
		List<WebElement> elementList = tablePersonList;
		for (WebElement we : elementList) {
			actualWebList.add(we.getText());
		}
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : actualWebList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		if (sortedList.equals(actualWebList)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateContact (ExtentTest test5) {
			test5.info("My Fifth Test Case");
			List<WebElement> numbers = mobilenos;
			if (numbers.isEmpty()) {
			return false;
			}
			else {
			return true;
}}
}
