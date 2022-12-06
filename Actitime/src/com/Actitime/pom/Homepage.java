package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	@FindBy(id = "logoutLink")
	private WebElement lgoutlnk;
	
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement tasklnk;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportlnk;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement userlnk;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver,this);// TODO Auto-generated constructor stub
	}

	public WebElement getTasklnk() {
		return tasklnk;
	}

	public WebElement getReportlnk() {
		return reportlnk;
	}

	public WebElement getUserlnk() {
		return userlnk;
	}
	
	public WebElement getLgoutlnk() {
		return lgoutlnk;
	}
	
	public void task() {
		tasklnk.click();
	}
	
	public void report() {
		reportlnk.click();
	}
	
	public void user() {
		userlnk.click();
	}
	
	public void logout() {
		lgoutlnk.click();
	}
}
