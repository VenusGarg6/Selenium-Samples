package com.selenium.testcases;

import org.testng.annotations.Test;

import com.selenium.pages.BaseTest;
import com.selenium.pages.LoginPage;
import com.selenium.pages.SearchPage;
import com.selenium.utility.ReadExcelFile;

public class SearchTest extends BaseTest {
String fileName=System.getProperty("user.dir")+"\\TestData\\TestPortalData.xlsx";
	
	@Test(priority =1)
	void searchCourseTest()
	{
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		lp.loginPortal(username, password);
		
		SearchPage sp= new SearchPage(driver);
		String course=ReadExcelFile.getCellValue(fileName, "SearchCourse", 0, 0);
		sp.searchCourse(course);
	}
}
