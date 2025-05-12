package com.selenium.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.BaseTest;
import com.selenium.pages.LoginPage;
import com.selenium.utility.ReadExcelFile;

public class LoginTestDataDrivenTesting extends BaseTest{
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestPortalData.xlsx";
	
	@Test(priority=1, dataProvider="LoginDataProvider")
	void verifyLogin(String userName, String userPwd) throws IOException {
		LoginPage lp=new LoginPage(driver);
		lp.loginPortal(userName, userPwd);
		
		if(userName.equals("Demo12") && userPwd.equals("Test123456$"))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
			lp.logout();
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}

	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		int ttlRows= ReadExcelFile.getRowCount(fileName, "LoginData");
		int ttlColumns= ReadExcelFile.getColCount(fileName, "LoginData");
		
		String data[][]= new String[ttlRows-1][ttlColumns];
		
		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginData", i, j);
			}
		}
		return data;
	}
}
