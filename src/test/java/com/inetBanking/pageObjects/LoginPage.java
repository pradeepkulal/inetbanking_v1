package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver ldriver;
public LoginPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

//Locating the eelments
@FindBy(name="uid") WebElement userBox;
@FindBy(name="password") WebElement passwordBox;
@FindBy(name="btnLogin") WebElement loginBtn;
@FindBy(name="btnReset") WebElement resetBtn;
@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")WebElement logoutBtn;


public void setUserName(String uName) {
	userBox.sendKeys(uName);
}
public void setPassword(String password) {
	passwordBox.sendKeys(password);
}
public void clickSubmit() {
	loginBtn.click();
}
public void clickLogOut() {
	logoutBtn.click();
}
}
