package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	/*
	 * Data Driven 
	 * CacheLookup
	 * WebDriver Lookup
	 */
	
	

	@FindBy(xpath = "//td[contains(text(), 'User: Sandesh Maiya')]")
	@CacheLookup
	WebElement usernamelabel;

	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactlink;

	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealslink;

	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement taskslink;

	@FindBy(xpath = "//a[contains(text(), 'New Contact')]")
	WebElement newcontact;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyUserLabel() {
		return usernamelabel.isDisplayed();
	}

	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public void NewContact() {
		Actions actions = new Actions(driver);
		actions.moveToElement(contactlink).build().perform();
		boolean test= newcontact.isDisplayed();
		System.out.println(test);
		

	};

	public ContactsPage clickOnContactLink() {
		contactlink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealslink.click();
		return new DealsPage();
	}

	public TasksPage clickOntaskslink() {
		dealslink.click();
		return new TasksPage();
	}

}
