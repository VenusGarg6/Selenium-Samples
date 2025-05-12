package com.selenium.testcases;

import org.testng.annotations.Test;

import com.selenium.pages.BaseTest;
import com.selenium.pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	void verifyLogin() throws InterruptedException{
		LoginPage lp=new LoginPage(driver);
		lp.loginPortal("Demo12", "Test123456$");
		driver.wait(300);
	}

}
