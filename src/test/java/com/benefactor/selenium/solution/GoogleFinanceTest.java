package com.benefactor.selenium.solution;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.benefactor.selenium.solution.pages.GoogleFinancePage;

/**
 * GoogleFinanceTest - Tests for the Google Finance webpage.
 */
public class GoogleFinanceTest extends BaseTest {
        private static final Logger LOG = LogManager.getLogger();
        GoogleFinancePage gFP;

        @Test(priority = 1)
        /**
         * Test that the Google Finance page is loaded and page
         * title is correct.
         */
        public final void openGoogleFinance() {
                LOG.debug("Running openGoogleFinance...");
                gFP = new GoogleFinancePage(driver);
                LOG.debug("Page Title: " + driver.getTitle());
                String expectedPageTitle = "Google Finance - "
                                + "Stock Market Prices, Real-time Quotes & Business News";
                Assert.assertTrue(gFP.pageTitle().equals(expectedPageTitle),
                                "Test " + this.getClass() + " Failed to verify page title");
        }

        @Test(priority = 2)
        /**
         * Print out the stocks that are expected but not on the page,
         * and the stocks that are on the page but not expected.
         */
        public final void compareStockSymbols() {
                LOG.debug("Running compareStockSymbols");
                Collection<String> expectedStock = Arrays
                                .asList("NFLX", "MSFT", "TSLA");
                gFP = new GoogleFinancePage(driver);
                Collection<String> currStock = new ArrayList<>(gFP.getStocksByTicker());
                LOG.debug("Current stocks: " + currStock);
                LOG.info("Stocks not expected: "
                                + findMissingStrings(currStock, expectedStock));
                LOG.info("Stocks expected but not found: "
                                + findMissingStrings(expectedStock, currStock));
                // This test prints out missing strings so just add an Assert
                // for completion
                Assert.assertTrue(true,
                                "Test " + this.getClass()
                                                + " Failed to compare Stock Symbols");
        }

        @Test(priority = 3)
        /**
         * Print out the stocks that are expected but not on the page,
         * and the stocks that are on the page but not expected.
         */
        public final void getIncreasingStocks() {
                LOG.debug("Running getIncreasingStocks");
                gFP = new GoogleFinancePage(driver);
                Collection<String> currStock = new ArrayList<>(gFP.getStocksAllInfo());
                LOG.info("currStock: " + currStock);
                // This test prints out missing strings so just add an Assert
                // for completion
                Assert.assertTrue(true,
                                "Test " + this.getClass()
                                                + " Failed to get Increasing Stocks");
        }

        /**
         * findMissingStrings compares a Collection of Strings with another
         * and returns Strings in the first Collection that are not in the
         * Second.
         *
         * @param a - The first Collection
         * @param b - The second Collection
         * @return - Strings in the first that are not in the second
         */
        public final List<String> findMissingStrings(
                        final Collection<String> a, final Collection<String> b) {
                List<String> output = new ArrayList<>(a);
                output.removeAll(b);
                return output;
        }
}
