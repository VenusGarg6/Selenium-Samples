package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	public DashboardPage(WebDriver dDriver) {
		this.driver=dDriver;
		PageFactory.initElements(dDriver,this);
		
	}
	
	@FindBy(xpath="//*[@id=\"login-list\"]/li[1]/a") WebElement dashboard;
	@FindBy(xpath="//*[@id=\"learn-press-user-profile\"]/ul/li[3]/a") WebElement academics;
	@FindBy(xpath="//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button") WebElement subscribe;
	
	public void dashboardClick() {
		dashboard.click();
		academics.click();
		subscribe.click();
	}
	
}
