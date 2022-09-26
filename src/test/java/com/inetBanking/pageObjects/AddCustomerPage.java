package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
WebDriver ldriver;
 public AddCustomerPage(WebDriver rdriver) {
ldriver=rdriver;
PageFactory.initElements(rdriver, this);
 }
 //Locating the page elements
 @FindBy(xpath = "//a[text()='New Customer']") WebElement newCustomerBtn;
 @FindBy(name = "name") WebElement customerNameInput;
 @FindBy(xpath = "(//input[@name='rad1'])[1]") WebElement maleBtn;
 @FindBy(xpath = "(//input[@name='rad1'])[2]") WebElement femaleBtn;
 @FindBy(xpath = "//input[@name='dob']") WebElement dobInput;
 @FindBy(xpath = "//textarea[@name='addr']") WebElement addressInput;
 @FindBy(xpath = "//input[@name='city']") WebElement cityInput;
 @FindBy(xpath = "//input[@name='state']") WebElement stateInput;
 @FindBy(xpath = "//input[@name='pinno']") WebElement pinInput;
 @FindBy(xpath = "//input[@name='telephoneno']") WebElement phoneInput;
 @FindBy(xpath = "//input[@name='emailid']") WebElement emailInput;
 @FindBy(xpath = "//input[@name='password']") WebElement passwordInput;
 @FindBy(xpath = "//input[@name='res']") WebElement resetBtn;
 @FindBy(xpath = "//input[@name='sub']") WebElement submitBtn;
 //Page Action Methods
 public void clickNewCtustomerBtn() {
	 newCustomerBtn.click();
 }
 public void enterCustName(String name) {
	 customerNameInput.sendKeys(name);
}
 public void clickCustGender(String gender) {
	 if(gender.equalsIgnoreCase("Male")) {
		System.out.println("Male is selected");
		 maleBtn.click();
	 }
	 else if(gender.equalsIgnoreCase("Female")) {
		 System.out.println("Female is selected");
		 femaleBtn.click();
	 }
	 else {
		 System.out.println("Enter correct gender");
	 }
 }
public void enterDOB(String dd,String mm,String yy) {
	dobInput.sendKeys(mm);
	dobInput.sendKeys(dd);
	dobInput.sendKeys(yy);
} 
public void enterAddress(String address) {
	addressInput.sendKeys(address);
}
public void enterCity(String city) {
	cityInput.sendKeys(city);
}
public void enterState(String State) {
	stateInput.sendKeys(State);
}
public void enterPIN(String PIN) {
	pinInput.sendKeys(PIN);
}
public void enterMnumbe(String Mnumber) {
	phoneInput.sendKeys(Mnumber);
}
public void enterEmail(String Email) {
	emailInput.sendKeys(Email);
}

public void enterpassword(String password) {
	passwordInput.sendKeys(password);
}
public void clickSubmitBtn() {
	 submitBtn.click();
}

public void clickResetBtn() {
	 resetBtn.click();
}



}