package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Loginpage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactspageTest extends TestBase {

	Loginpage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskpage;

	public ContactspageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {

		initilization();
		loginpage = new Loginpage();
		homepage = loginpage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		TestUtil.switchTo(prop.getProperty("homeframe"));
		contactspage = homepage.clickOnContactLink();
	

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verrifyContactsPagelabel() {
		Assert.assertTrue(contactspage.contactsBannerVerify(),
				"Contacts Label missing from page");

	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactspage.selectContactsByName("test test");
		contactspage.selectContactsByName("test 2");

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData("ContactsData");
		return data;
	}

	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName,
			String lastName, String company) {		
		homepage.NewContact();
		contactspage.createNewContact(title, firstName, lastName, company);
		
		
		
		

	}

}
