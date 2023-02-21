package com.htmPorject.testClass;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.hrmProject.pageObjectClass.BaseClass;
import com.hrmProject.pageObjectClass.loginPageClass;

public class TC_001_LoginTest extends BaseClass
{
	@Test
	public void loginVerify() throws InterruptedException
	{
		test = extent.createTest("Verification of application login");
		
		loginPageClass login = new loginPageClass(driver);
		
		Thread.sleep(2000);
		login.setUpUsername(username);
		test.log(Status.PASS,"Username successfully entered");
		
		Thread.sleep(2000);
		login.setUpPassword(password);
		test.log(Status.PASS,"Password successfully entered");
		
		Thread.sleep(2000);
		login.clickOnLoginButton();
		test.log(Status.PASS,"Login button pressed");
		
		String pageTitle = "OrangeHRM";
		
		if(driver.getTitle().equals(pageTitle))
		{
			System.out.println("User logged in successfully");
			test.log(Status.PASS,"Login verification successfully done");
		}
		else
		{
			System.out.println("User login failed");
		}
	}

}
