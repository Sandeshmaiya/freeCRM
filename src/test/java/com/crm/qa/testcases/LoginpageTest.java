package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.util.Xls_Reader;

public class LoginpageTest extends TestBase {

	Loginpage loginpage;
	HomePage homepage;
	

	public LoginpageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initilization();
		loginpage = new Loginpage();
		

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginpageTitleTest() {
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,
				"#1 Free CRM software in the cloud for sales and service");

	}

//	@Test(priority = 2)
//	public void crmlogoTest() {
//		boolean flag = loginpage.validateCRMImage();
//		Assert.assertTrue(flag);
//
//		if (flag) {
//			reader.setCellData("output1", "logocheck", 2, "pass");
//		} else {
//			reader.setCellData("output1", "logocheck", 2, "Fail");
//
//		}
//	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {

		homepage = loginpage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		
		if(homepage.validateHomePageTitle().equals("CRMPRO")){
		reader.setCellData("output1", "login title", 2, "pass");
		}
		 else {	reader.setCellData("output1", "login title", 2, "Fail");}
		
	}

}
