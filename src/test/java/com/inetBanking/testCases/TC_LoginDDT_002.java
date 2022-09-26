package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProvider ="LoginData" )
public void loginDDT(String user,String pasword) throws Exception {
		LoginPage lpage=new LoginPage(driver);
		lpage.setUserName(user);
		lpage.setPassword(pasword);
		lpage.clickSubmit();
		Thread.sleep(2000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();		
			logger.warn("login failed");
			Assert.assertTrue(false);
			
			
		}
		else {
			Assert.assertTrue(true);
			logger.warn("login passed");
			lpage.clickLogOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();	
			
		}
	
}
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/ManagerData.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	
		return logindata;
	}
	//User defined method to check alert is present or not
	public boolean isAlertPresent() {
		try {
			 driver.switchTo().alert();
			 return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
