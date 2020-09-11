package com.jbk.pages;

import java.io.File;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.jbk.repository.DashBoardPageRepository;
import jxl.Sheet;
import jxl.Workbook;

public class DashBoradPage extends DashBoardPageRepository{

WebDriver driver;
	
	public DashBoradPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public String getTitleofPage() {
		PageLogs().info("this is getTitleMethod");
		
		return driver.getTitle();
		
	}

	public boolean verifyTitleOfPage(ExtentTest test1) {
		test1.info("My First Test Case");
		try {
			if (getTitleofPage().equals("JavaByKiran | Dashboard")) {
				return true;
				
			} else {
				return false;
			}
		} catch (Throwable t) 
		
		{
			return false;
	
		}
		
		 
	}

	public String getLabelLogout() {
		PageLogs().info("this is getLabelLogout method ");
		return logoutLable.getText();
	}

	public boolean verifyLogoutLabel(ExtentTest test2) {
		test2.info("My Two Test Case");
		PageLogs().info("this is verifyLogoutLabel method ");
		//---
		try {
			if (getLabelLogout().equals("LOGOUT")) {
				return true;
			} else {
				return false;
			}
		} catch (Throwable t) {
			return false;
		}
	}

	public String getPageHeader() {
		return dashboardHeader.getText();

	}

	public boolean verifyHeader(ExtentTest test3) {
		test3.info("My Three Test Case");
		PageLogs().info("this is verifyHeader method");
		//---
		try {
			if (getPageHeader().equals("Courses Offered")) {
				return true;
			}
			
			else {
				return false;
			}
			
		} catch (Throwable t) {
			return false;
		}
	}

	public boolean verifyCourseHeaders(ExtentTest test4) {
		test4.info("My Four Test Case");
		PageLogs().info("this is verifyCourseHeaders method");
		//---
		boolean flag = true;
		// excel sheet
		try {
			ArrayList<String> expected = new ArrayList<String>();
			File file = new File(System.getProperty("user.dir")+"/src/main/resources/ExpectedData.xls");
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			int rows=sheet.getRows();
			if (sheet.getCell(0, 0).getContents().equals("ExpectedHeaders")) {
				for (int i = 1; i < rows; i++) {
					expected.add((sheet.getCell(0, i).getContents()));
				}
				System.out.println(expected);
				
				ArrayList<Boolean> flagList = new ArrayList<Boolean>();

				

				if (expected.size() == 0 && courseHeaders.size() > 0) {
					System.out.println("nothing is expected but seen some menu items");
					return false;
				}

				if (courseHeaders.size() != expected.size()) {
					System.out.println("count not matching..");
				}

				for (int i = 0; i < expected.size(); i++) {
					try {
						flag = courseHeaders.get(i).getText().equals(expected.get(i));/// false//false///false///true
						flagList.add(flag);
						if (!flag) {
							System.out.println("THis menu is wrong .. " + expected.get(i)
									+ " > instead of this it is showing " + courseHeaders.get(i).getText());// Selenium111
						} else {
							System.out.println("matching >> " + courseHeaders.get(i).getText());
						}
					} catch (Throwable t) {
						System.out.println("THis is missing from website .. " + expected.get(i));
					}
				}
				if (flagList.contains(false)) {
					return false;
				}
			}
		} catch (Throwable t) {
			return false;
		}
		return flag;
	}
	// return flag;

	public boolean verifyNumberOfCourses(ExtentTest test5) {
		test5.info("My Five Test Case");
		PageLogs().info("this is verifyNumberOfCourses method");
		//---
		try {
			//List<WebElement> list = driver.findElements(By.xpath("//div//h3"));
			System.out.println(courseHeaders.size());
			if (courseHeaders.size() == 4) {
				return true;
			} else {
				return false;

			}
		} catch (Throwable t) {
			return false;
		}
	}

	public boolean verifyAllCourseslinks(ExtentTest test6) {
		test6.info("My Six Test Case");
		PageLogs().info("this is verifyAllCourseslinks method");
		boolean flag = false;
		try {
			
			for (int i = 0; i < courselinks.size(); i++) {
				courselinks.get(i).click();
				flag = true;
			}
		} catch (Throwable t) {
			return false;
		}
		return flag;

	}

	public boolean verifyCourseNames(ExtentTest test7) {
		test7.info("My Sevan Test Case");
		PageLogs().info("this is verifyCourseNames Method ");
		
		boolean flag = true;
		try {
			ArrayList<String> expected = new ArrayList<String>();
			File file = new File(System.getProperty("user.dir")+"/src/main/resources/ExpectedData.xls");
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);
			int rows=sheet.getRows();
			if (sheet.getCell(1, 0).getContents().equals("ExpectedCourseNames")) {
				for (int i = 1; i < rows; i++) {
					expected.add((sheet.getCell(1, i).getContents()));
				}
				ArrayList<Boolean> flagList = new ArrayList<Boolean>();

				if (expected.size() == 0 && coursenames.size() > 0) {
					System.out.println("nothing is expected but seen some menu items");
					return false;
				}

				if (coursenames.size()!=expected.size()) {
					System.out.println("count not matching..");
				}

				for (int i = 0; i < expected.size(); i++) {
					try {
						flag = coursenames.get(i).getText().equals(expected.get(i));/// f//false///false///true
						flagList.add(flag);
						if (!flag) {
							System.out.println("THis menu is wrong ..expected is " + expected.get(i)
									+ " > instead of this Actual is.. " + coursenames.get(i).getText());// Selenium111
						} else {
							System.out.println("matching >> " + coursenames.get(i).getText());
						}
					} catch (Throwable t) {
						System.out.println("THis is missing from website .. " + expected.get(i));
					}
				}
				if (flagList.contains(false)) {
					return false;
				}
			
		}
			}catch (Throwable t) {
			return false;
		}
		return flag;

	}

	 
	 
}