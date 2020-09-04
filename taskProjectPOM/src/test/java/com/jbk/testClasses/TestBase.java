package com.jbk.testClasses;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jbk.pages.LoginPage;
public class TestBase {
	public static WebDriver driver;
	Properties prop = null;
	FileInputStream fis = null;
	LoginPage lp=null;
	
//extent report variables
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentTest testPrePage;
	
	String readAnyProperty( String propName) {
		String val = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/" + "/Config.properties");
			prop = new Properties();
			prop.load(fis);

			val = prop.getProperty(propName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}
	public WebDriver launchApplication() throws Throwable {
		String URL = readAnyProperty("url");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
		return driver;
	}
	public LoginPage loadLoginpage(){
		
		LoginPage lp=new LoginPage(driver);
		return lp;
	}
	public void CloseLaunchApplication() {
		driver.close();
	}

	//Extent Report Code
	
	public ExtentReports setReport(String pageName, String extentReprtName, String hostName, String environment, String uName,
			String docTitle, String reportName) {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + extentReprtName + ".html");
		htmlReporter.config().setDocumentTitle(docTitle);
		htmlReporter.config().setReportName(reportName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", hostName);
		extent.setSystemInfo("Environment", environment);
		extent.setSystemInfo("User Name", uName);
		test=extent.createTest("All TestCases pages", "TestCases");
		return extent;
	}
	public void endReport() {
		extent.flush();
	}
	public void extenttestNode() {
		testPrePage=test.createNode("OperatorPage");
	}
	
}
