package com.benefactor.selenium.solution;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * BaseTest - Parent class of current tests. Currently
 * provides hooks.
 */
public class BaseTest {
    private static final Logger LOG = LogManager.getLogger();
    protected static WebDriver driver;

    @BeforeSuite
    /**
     * testSetup - Starts the ChromeDriver.
     */
    public final void testSetup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins*");
        chromeOptions.setBrowserVersion("129");
        LOG.debug("Starting Tests...");
        driver = new ChromeDriver(chromeOptions);
    }

    /**
     * tearDown - Stops the ChromeDriver.
     */
    @AfterSuite
    public final void tearDown() {
        LOG.info("Quitting...");
        driver.quit();
    }
}
