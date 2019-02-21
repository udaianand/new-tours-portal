package com.newtours.demo.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.newtours.demo.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {

			prop = new Properties();
			FileInputStream ip;

			ip = new FileInputStream(
					"D:\\Aanand\\Project\\Selenium_Workspace_Tutorial\\NewToursPortal\\src\\main\\java\\com\\newtours\\demo\\qa\\config\\config.properties");

			prop.load(ip);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void intialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Aanand\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Aanand\\Driver\\geckodriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
