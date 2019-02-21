package com.newtours.demo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.demo.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Locators
	@FindBy(name = "userName")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "login")
	WebElement SignButton;

	// Initialize

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Methods

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public FlightsPage login(String user, String pwd) throws InterruptedException {
		userName.sendKeys(user);
		password.sendKeys(pwd);
		SignButton.click();
		return new FlightsPage();
	}

}
