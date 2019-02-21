package com.newtours.demo.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.newtours.demo.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICITLY_WAIT = 30;

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void waitFor(WebDriver driver, WebElement locator, int timeOut) {
		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeSelected(locator));
	}

	public static void clickOn(WebDriver driver, WebElement locator, int timeOut) {
		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

	public static void switchToMainFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static void switchToLeftFrame() {
		driver.switchTo().frame("leftpanel");
	}

}
