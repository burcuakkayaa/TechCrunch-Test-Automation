package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridDriver extends DriverFactory {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

    public static String remote_url = "http://localhost:4444/wd/hub";

    public WebDriver getDriver() throws MalformedURLException {
        //FirefoxOptions options = new FirefoxOptions();
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "108");
        driver.set(new RemoteWebDriver(new URL(remote_url), options));
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return driver.get();
    }
}
