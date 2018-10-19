package com.crm.qa.pages;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class Loginpage extends TestBase {
	Actions a;
	// Page OR
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit' and @value ='Login' and @class ='btn btn-small']")
	WebElement lognBtn;

	@FindBy(xpath = "//button[contains(text(), 'Sign Up')]")
	WebElement signupBtn;

	@FindBy(xpath = "html/body/div[2]/div/div[1]/a/img")
	WebElement crmlogo;

	@FindBy(xpath = "//div[@class='intercom-borderless-dismiss-button']/span")
	WebElement chatclose;

	@FindBy(xpath = "//a[text()= 'Help Center']")
	WebElement moveover;

	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();

	}

	public HomePage login(String un, String pwd) throws InterruptedException {

		username.sendKeys(un);
		password.sendKeys(pwd);

//		Thread.sleep(3000);

//		try {
//			TestUtil.switchTo(prop.getProperty("chatframe"));
//
//			a = new Actions(driver);
//			// TestUtil.explicitWait(moveover);
//
//			Thread.sleep(3000);
//			a.moveToElement(moveover).build().perform();
//			chatclose.click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchFrameException e) {
//			e.printStackTrace();
//
//		}

		lognBtn.click();
		return new HomePage();

	}

}
