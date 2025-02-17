package com.benefactor.selenium.solution.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * GoogleFinancePage - This class represents the Google Finance webpage.
 */
public class GoogleFinancePage {
    private static final Logger LOG = LogManager.getLogger();
    WebDriver driver;

    /**
     * Constructor for Google Finance webpage
     *
     * @param driver - Selenium WebDriver for tests
     */
    public GoogleFinancePage(final WebDriver driver) {
        this.driver = driver;
        LOG.info("Going to Testing site...");
        driver.get("http://www.google.com/finance/");
        PageFactory.initElements(driver, this);
    }

    /**
     * pageTitle - returns the title of the current webpage.
     *
     * @return
     */
    public final String pageTitle() {
        return driver.getTitle();
    }

    /**
     * getStocks - Gets the stocks from the section of the
     * page specified and returns them as a List of Strings.
     *
     * @return - List of Strings.
     */
    public final List<String> getStocks() {
        List<String> output = new ArrayList<>();
        // Grab stockList by className
        WebElement stockList = driver.findElement(
                By.className("sbnBtf"));
        // Inside stockList, get the stocks by className
        List<WebElement> stocks = stockList.findElements(
                By.className("COaKTb"));
        for (int i = 0; i < stocks.size(); i++) {
            output.add(stocks.get(i).getText());
        }
        return output;
    }
}
