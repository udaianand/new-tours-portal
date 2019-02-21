package com.newtours.demo.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newtours.demo.qa.base.TestBase;
import com.newtours.demo.qa.pages.FlightsPage;
import com.newtours.demo.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	FlightsPage flightsPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialization();
		Thread.sleep(7000);
	}

	@Test
	public void loginPageTitleTest() {
		loginPage = new LoginPage();
		String Title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(Title, "Welcome: Mercury Tours");

	}

	@Test(groups = "Login")
	public void loginTest() throws InterruptedException {
		loginPage = new LoginPage();
		Thread.sleep(6000);
		flightsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
