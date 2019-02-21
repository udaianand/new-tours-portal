package com.newtours.demo.qa.pages;

import com.newtours.demo.qa.base.TestBase;

public class FlightsPage extends TestBase {

	public String validateFlightsPageTitle() {
		return driver.getTitle();
	}

}
