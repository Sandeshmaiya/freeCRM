package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.Xls_Reader;

public class HomepageTest extends TestBase {

	Loginpage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskpage;

	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {

		initilization();
		loginpage = new Loginpage();
		homepage = loginpage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		TestUtil.switchTo(prop.getProperty("homeframe"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void validatetitle() {
		
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Homepage title failed");

	}

	@Test(priority = 2)
	public void usernameTest() {

		boolean userlabel = homepage.verifyUserLabel();
		Assert.assertTrue(userlabel);
	}

	@Test(priority = 3)
	public void navigateToContacts() {
		contactspage = homepage.clickOnContactLink();
		if (contactspage.contactsBannerVerify()) {
			reader.setCellData("Output", "Contacts", 2, "Pass");

		} else {
			reader.setCellData("Output", "Deals", 2, "Fail");
		}

	}

	@Test(priority = 4)
	public void navigateToDeals() {

		dealspage = homepage.clickOnDealsLink();
		if (dealspage.dealsBannerVerify()) {
			reader.setCellData("Output", "Deals", 2, "Pass");
		} else {
			reader.setCellData("Output", "Deals", 2, "Fail");
		}

	}

	@Test(priority = 5)
	public void navigateToTasks() {

		taskpage = homepage.clickOntaskslink();
		taskpage.test();

	}

}
