package org.braheem.website.functest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Suite.class)
@SuiteClasses({
	LinkTest.class
})
public class SeleniumTestSuite {

	private static WebDriver driver;
	private static WebDriverWait wait;
	@BeforeClass
	public static void setUp() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver,10);
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			setUp();
		}
		return driver;
	}
	
	public static WebDriverWait getWait() {
		if (wait == null) {
			setUp();
		}
		return wait;
	}
	
	public static void setDriver(WebDriver driver) {
		SeleniumTestSuite.driver = driver;
	}
	
	@AfterClass
	public static void tearDown(){
		driver.quit();
	}
	
}
