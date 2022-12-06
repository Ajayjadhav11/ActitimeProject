package com.Actitime.pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Actitime.GenericLibrary.readDataFromExcel;

public class Taskpage {

	@FindBy(xpath = "//div[.='Add New']")
	private WebElement Addnewbtn;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newcustomer;
	
	@FindBy(xpath= "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement description;
	
	@FindBy(xpath="(//div[@class='dropdownButton'])[15]")
	private WebElement dropdown;
	
	@FindBy(xpath="(//div[.='Big Bang Company'])[6]")
	private WebElement bbccompany;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createcustomer;
	
	public WebElement getCreatecustomer() {
		return createcustomer;
	}



	public WebElement getbbccompany() {
		return bbccompany;
	}



	public WebElement getDescription() {
		return description;
	}



	public WebElement getDropdown() {
		return dropdown;
	}



	public Taskpage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	
	}
	
	
	
	public WebElement getCustname() {
		return custname;
	}



	public WebElement getAddnewbtn() {
		return Addnewbtn;
		
	}

	public WebElement getNewcustomer() {
		return newcustomer;
	}
	
	public void addnew() throws EncryptedDocumentException, IOException {
		
		readDataFromExcel r = new readDataFromExcel();
	String custname1 = r.readDataFromExcelFile("Sheet1", 1, 1);
		Addnewbtn.click();
		newcustomer.click();
		custname.sendKeys(custname1);
		description.sendKeys("Banking");
		dropdown.click();
		bbccompany.click();
		createcustomer.click();
		
		
}
	

	

}
