package com.e2eTests.exercice.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Setup {
	private static WebDriver driver;
	private static final Logger LOGGER = (Logger) LogManager.getLogger(Setup.class.getName());

	@Before
	public void setWebDriver(Scenario scenario) {
		LOGGER.info("Scenario: " + scenario.getName() + "- started");

		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}

		switch (browser) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("start-maximized");
			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("plateform", Platform.WIN10);
			driver = new FirefoxDriver(firefoxOptions);
			break;

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setCapability("plateform", Platform.WIN10);
			driver = new EdgeDriver(edgeOptions);
			break;

		default:
			throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
		}

	}

	@After
	public void tearDown(Scenario scenario) {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) Setup.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}

		driver.quit();
		LOGGER.info("Scenario : " + scenario.getName() + "- finished.Status" + scenario.getStatus());
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Logger getLogger() {
		return LOGGER;
	}
}
