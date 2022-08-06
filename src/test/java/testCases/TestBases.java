package testCases;

import factory.DriverFactory;
import listeners.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Constants;


public class TestBases {

    DriverFactory driverFactory = new DriverFactory();
    protected static WebDriver driver;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void launchBrowser(@Optional String browserName) {
        /**
         * Create a driver by selecting the browser.
         */
        if (browserName == null)
            browserName = "chrome";

        driver = driverFactory.getDriverManager(browserName);
        driver.get(Constants.BASE_URL);


    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {

        /**
         * Close the browser at the end of the test.
         */
        driver.quit();
    }
}
