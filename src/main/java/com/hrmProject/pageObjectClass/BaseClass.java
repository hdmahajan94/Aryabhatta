package com.hrmProject.pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.hrmProject.utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	
	public static ExtentSparkReporter sparkreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setReport()
	{
	    sparkreporter = new ExtentSparkReporter("C:\\Users\\hp\\eclipse-workspace\\Admin_Project_1\\reports/newreport"+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Operating system","Windows 10" );
		extent.setSystemInfo("Environment","SIT");
		sparkreporter.config().setDocumentTitle("QA Automation Testing Report");
		sparkreporter.config().setReportName("Integration Test Execution");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
	}
	
	@org.testng.annotations.Parameters("browser")
	@BeforeMethod
	public void setUp(String str)
	{
		if(str.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\Software\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseURL);
		}
		else if(str.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\hp\\Desktop\\Software\\Firefox Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(baseURL);
		}
		else if(str.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\hp\\Desktop\\Software\\IE Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(baseURL);
		}
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}

}
//Changes made
