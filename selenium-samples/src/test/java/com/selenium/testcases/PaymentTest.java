package com.selenium.testcases;

import org.testng.annotations.Test;

import com.selenium.pages.BaseTest;
import com.selenium.pages.DashboardPage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.PaymentPage;
import com.selenium.utility.ReadExcelFile;

public class PaymentTest extends BaseTest{

String fileName=System.getProperty("user.dir")+"\\TestData\\TestPortalData.xlsx";
	
	@Test(priority=1)
	public void paymentTestCase() {
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
		lp.loginPortal(username, password);
		
		DashboardPage dp=new DashboardPage(driver);
		dp.dashboardClick();
		
		PaymentPage pp=new PaymentPage(driver);
		String cardNum=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 0);
		String expDate=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 1);
		String cvv=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 2);
		pp.paymentDone(cardNum,expDate,cvv);
		
	}
}
