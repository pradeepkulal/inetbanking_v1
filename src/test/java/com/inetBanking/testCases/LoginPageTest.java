package com.inetBanking.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class LoginPageTest extends BaseClass {
	
  @Test
  public void loginTest() throws IOException {
	  LoginPage lPage=new LoginPage(driver);
	  lPage.setUserName(userName); logger.info("User name enter");
	  lPage.setPassword(password); logger.info("password is enterd");
	  lPage.clickSubmit(); logger.info("Submit clicked");
	  String text=getTitle();
	  System.out.println(getTitle());
	  if(text.equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
		  logger.info("Test case with valid data passed");	  Assert.assertTrue(true);
		  
	  }
	  else {
		  captureScreen(driver,"loginTest");
		  logger.info("Test case with invalid data failed");  Assert.assertTrue(false);
		  
	  }
  }
}
