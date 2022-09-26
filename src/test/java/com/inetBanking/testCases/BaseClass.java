package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;
public class BaseClass {
	ReadConfig rConfig=new ReadConfig();
	public String baseURL=rConfig.getWebURL();
	public String userName=rConfig.getUserName();
	public String password=rConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	public String browser="chrome";
	@BeforeClass
	public void setUp() {
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", rConfig.getChromePath());
		driver=new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", rConfig.getEdgePath());
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL); logger.info("URL is Opend");
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
public String getTitle() {
	String aTitle=driver.getTitle();
	return aTitle;
}

//user defined method to accept the alert
public void acceptAlert() {
	driver.switchTo().alert().accept();
	
}

//user defined method to get back from the alert the alert
public void getBackToDefaultContent() {
	driver.switchTo().defaultContent();
}
public void captureScreen(WebDriver driver, String tname) throws IOException   {
TakesScreenshot ts = (TakesScreenshot)driver;
File source = ts.getScreenshotAs(OutputType.FILE);
File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
FileUtils.copyFile(source, target);
System.out.println("Screenshot taken");
}
public String randomString() {
	String genertedString =RandomStringUtils.randomAlphabetic(8);
	return genertedString;
}
public String randomNumber(int num) {
	String genertedString =RandomStringUtils.randomNumeric(num);
	return genertedString;
}
public boolean checkContains(String text) {
	logger.info("Checking for contains");
	 return driver.getPageSource().contains(text);
}
public void closeIframe() {
	 WebElement iframe=driver.findElement(By.xpath("//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']"));
	driver.switchTo().frame(iframe);
	 driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		  driver.switchTo().defaultContent();	
}

}
