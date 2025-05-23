package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//constructor
	public LoginPage(WebDriver lDriver)
	{
		this.driver=lDriver;
		
		PageFactory.initElements(driver,this);//this=java.lang.Class.pageObjectClass
	}
	@FindBy(xpath="//*[@id=\"loginlabel\"]") WebElement loginclick;
	
	@FindBy(name="log") WebElement uname;
	
	@FindBy(name="pwd") WebElement upwd;
	
	@FindBy(name="wp-submit") WebElement loginButton;

	@FindBy(xpath="//*[@id=\"gk-login-toggle\"]/i") WebElement logoutimage;
	
	@FindBy(xpath="//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a") WebElement logoutclick;
	
	public void loginPortal(String username,String password) {
		loginclick.click();
		uname.sendKeys(username);
		upwd.sendKeys(password);
		loginButton.click();
	}
	
	public void logout() {
		logoutimage.click();
		logoutclick.click();
	}
}
