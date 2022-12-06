package com.Actitime.Testscript;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.Base;
import com.Actitime.pom.Homepage;
@Listeners(com.Actitime.GenericLibrary.ListenerImplementation.class)
public class Createcustomer extends Base{

	
	@Test
	public void createcustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		Homepage hp = new Homepage(driver);
		hp.task();
		
		com.Actitime.pom.Taskpage tp = new com.Actitime.pom.Taskpage(driver);
		tp.addnew();
		Thread.sleep(5000);
	}
		

}
