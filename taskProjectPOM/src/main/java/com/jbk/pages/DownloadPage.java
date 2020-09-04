package com.jbk.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.jbk.repository.DownloadPageRepo;

public class DownloadPage extends DownloadPageRepo 	 {
	public static WebDriver driver;
	public static Properties prop;
	
	
	//	Dashboardpage dashboardPage = null;
		String url="\\src\\test\\resources\\com\\jbk\\testdata\\testData.xlsx";
		public boolean Homemenu(WebDriver driver) {
		String actualtitle=driver.getTitle();
			Homemenu.click();
			String expectedtitle= driver.getTitle();
			if(actualtitle.equals(expectedtitle)) {
				return false;
			}else
			{
				return true;
			}
			
		}
	
	/*****************************************************************	*/
	
	public void NavigatetoDashboard(String user,String pass) {
	  emails.sendKeys(user); 
	  password.sendKeys(pass);
	  signIn.click();
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,40); WebElement downloadmen =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//span[text()='Downloads']")));
		 */
	  downloadmenu.click();
	 	
	}

	/************************************************************************/ 
	public DownloadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver= this.driver;
	}
	/*****************************************************************	*/
		
	 public  Boolean NoofsetupsinTable() {		
	 List<WebElement> rows= driver.findElements(By.tagName("tr"));
			int noofsetups = rows.size()-1;
			if(noofsetups==7)
			{
				return true;
			}
			else {
			return false;
			}
	}

	 /*****************************************************************	*/
	 
	 public boolean vendorsList(WebDriver driver){
		 List vendorslist= new ArrayList();
		 List<WebElement> cols= driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr/th"));
		 List<WebElement> rows= driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr"));
		 	
		 for(int i=1;i<rows.size();i++){
			WebElement Vendor=driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[" +(i+1)+ "]/td[3]"));
			vendorslist.add(Vendor.getText());
		 }
		 System.out.println(vendorslist);
		 List<String> Expectedvendorslist= new ArrayList();
		 //	Expectedvendorslist.addAll(ExcelUtility.getTestDatafrmExel(url,"VendorList"));
		 
		 
		  Expectedvendorslist.add("Java Development Kit (JDK)");
		  Expectedvendorslist.add("Selenium Server Standalon Jar");
		  Expectedvendorslist.add("Selenium Server Source Jar");
		  Expectedvendorslist.add("Google Chrome");
		  Expectedvendorslist.add("Google Chrome Driver");
		  Expectedvendorslist.add("Mozilla Firefox");
		  Expectedvendorslist.add("Gecko Driver for Latest firefox");
		 
		 if(vendorslist.equals(Expectedvendorslist))
		 {
			 return true;
		 }else
		 {
			 return false;
		 }
		 
		 
	 }
	 /*****************************************************************	*/
	 
	 
	 public boolean validateHeaders() {
		 List<String> actualheaderslist= new ArrayList<String>();
		 List<WebElement> col= driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr[1]/th"));
		 for(WebElement headers: col)	{ 	
		 		actualheaderslist.add(headers.getText());
		 		//System.out.println(headers.getText());
		 }
		 System.out.println("Actual column Header" +actualheaderslist);
		 List<String> ExpectedcolumnHeader= new ArrayList<String>();
		 	ExpectedcolumnHeader.add("Sr");
		 	ExpectedcolumnHeader.add("Name");
		 	ExpectedcolumnHeader.add("vendor");
		 	ExpectedcolumnHeader.add("Version");
		 	ExpectedcolumnHeader.add("32bit");
		 	ExpectedcolumnHeader.add("64bit");
		 	ExpectedcolumnHeader.add("Common");
		 	ExpectedcolumnHeader.add("Official Source \n*For prevoius and latest releases");
		 	
		 	System.out.println("Expect column Header" +ExpectedcolumnHeader);
		 
		 	if(actualheaderslist.equals(ExpectedcolumnHeader)) {
		 		
		 		System.out.println("Lists are equal");
		 		return true;
		 	}
		 	else
		 	{
		 	return false;
		 	}
	 }
	 /*****************************************************************	*/
	 
	 
	public boolean isLogout(WebDriver driver) {
		String beforetitle=driver.getTitle();			
		Logout.click();
		String aftertitle=driver.getTitle();		
		if  (beforetitle!=aftertitle)
		{
		return true;
		}
		else {
		return false;
			}
	}
	/*****************************************************************	*/
	
	public boolean avabilityOf32BitSetup(WebDriver driver) {
		List<Boolean> setuplist= new ArrayList<Boolean>();
		
		setuplist.add(googlecromedriver.isDisplayed());
		setuplist.add(mozeladriversetup.isDisplayed());
		setuplist.add(Geokodriversetup.isDisplayed());
		
		if(setuplist.contains(false)) {
			return false;
		}
		
		else { 
		 System.out.println(setuplist);
		return true;
		}
	}
	/*****************************************************************	*/
}
