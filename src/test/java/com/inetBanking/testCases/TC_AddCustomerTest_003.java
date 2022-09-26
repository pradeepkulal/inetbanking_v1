package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
  @Test
  public void addNewCustomer() throws InterruptedException, IOException {
	  LoginPage lpage = new LoginPage(driver);
	  lpage.setUserName(userName); logger.info("user name done");
	  lpage.setPassword(password);logger.info("password is added");
	  lpage.clickSubmit();  logger.info("submit clicked");
	  Thread.sleep(2000);
	  AddCustomerPage addCust=new AddCustomerPage(driver);
	  addCust.clickNewCtustomerBtn();logger.info("New customer is clicked");
	  //closeIframe(); logger.info("iframe closed");
	  addCust.enterCustName("pradeep"); logger.info("cust name added");
	  addCust.clickCustGender("Male"); logger.info("gender selected");
	  addCust.enterDOB("02", "12", "1996");logger.info("DOB done");
	  Thread.sleep(1000);
	  addCust.enterAddress("INDIA");logger.info("Address added");
	  addCust.enterCity("udupi");logger.info("City added");
	  addCust.enterState("KA");logger.info("state added");
	  addCust.enterPIN("576332");logger.info("PIN added");
	  addCust.enterMnumbe("9900990909"); logger.info("number added");
	 String email= randomString()+"@gmail.com";
	 addCust.enterEmail(email); logger.info("mail added");
	 addCust.enterpassword("675478243jfd");logger.info("password cust added");
	 addCust.clickSubmitBtn(); logger.info("submit clicked");
	 Thread.sleep(2000);
	 boolean res=checkContains("Customer Registered Successfully!!!");
	 if(res==true) { 
		 logger.info("Test case passed");
		Assert.assertTrue(true);
	 }
	 else {
		 captureScreen(driver, "addNewCustomer");
		 logger.info("Test case failed");
		 Assert.assertTrue(false);
	 }
	 
	  
  }
  
}
