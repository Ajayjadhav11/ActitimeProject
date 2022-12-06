package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Actitime.pom.Homepage;
import com.Actitime.pom.Loginpage;

public class Base {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected successfully",true);
	}
	
	@AfterSuite
	public void databaseisconnected() {
		Reporter.log("database disconnected successfully",true);
	}
    
	
		@BeforeTest
	public void launchBrowser() throws IOException {
	    driver = new ChromeDriver();
	    readDataFromPropertyFile R = new readDataFromPropertyFile();
	    String URL = R.readDataFromProperty("url");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		Reporter.log("launch the browser",true);
	}
	@AfterTest
	public void closebrowser() {
		driver.close();
		
		
		
	}
	@BeforeMethod
	public void login()throws IOException {
		readDataFromPropertyFile DATA = new readDataFromPropertyFile();
		String Un = DATA.readDataFromProperty("username");
		String Pw = DATA.readDataFromProperty("password");
		Loginpage lp = new Loginpage(driver);
		lp.logintoActitime(Un, Pw);
		
	}
	
	@AfterMethod
	public void Taskpage() throws InterruptedException, EncryptedDocumentException, IOException {
		Thread.sleep(5000);
		com.Actitime.pom.Taskpage tp = new com.Actitime.pom.Taskpage(driver);
		tp.addnew();
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		Homepage hp = new Homepage(driver);
		hp.logout();
	}
}

