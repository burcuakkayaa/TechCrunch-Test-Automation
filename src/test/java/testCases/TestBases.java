package testCases;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Constants;

import java.net.MalformedURLException;


public class TestBases {

    DriverFactory driverFactory = new DriverFactory();
    protected static WebDriver driver;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void launchBrowser(@Optional String browserName) throws MalformedURLException {
        /*
         * Create a driver by selecting the browser.
         */
        if (browserName == null)
            browserName = "grid";

        driver = driverFactory.getDriverManager(browserName);
        driver.get(Constants.BASE_URL);


    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {

        /*
         * Close the browser at the end of the test.
         */
        driver.quit();
    }
}
