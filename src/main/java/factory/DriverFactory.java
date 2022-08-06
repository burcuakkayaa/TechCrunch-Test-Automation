package factory;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver getDriverManager(String browser) {
        /**
         * The method returns Webdriver
         */

        if (browser.equalsIgnoreCase("firefox")) {
            CreateFirefoxDriver firefox = new CreateFirefoxDriver();
            tlDriver = firefox.createFirefoxDriver();
        } else {
            CreateChromeDriver chrome = new CreateChromeDriver();
            tlDriver = chrome.createChromeDriver();
        }

        WebDriver driver = tlDriver.get();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong("1")));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong("180000")));

        return driver;

    }

}
