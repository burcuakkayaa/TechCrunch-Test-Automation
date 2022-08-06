package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NewsDetailsPage extends BasePage {

    @FindBy(css = ".article-container")
    WebElement article;

    @FindBy(className = "article__title")
    WebElement articleTitle;

    public NewsDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("User should see the news details page")
    public void verifyPageIsOpen() {
        waitForJQueryLoad();
        Assert.assertTrue(isElementPresent(article));
    }

    @Step("User should see that the browser title same with the news title")
    public void verifyBrowserTitleAndNewsTitleAreSame() {

        Assert.assertEquals(getBrowserTitle(), getNewsTitle() + " | TechCrunch",
                "The news title and browser title can not be matched!");
    }

    @Step("User should see that the links within the news content")
    public void verifyTheLinksWithinTheNewsContent() {
        String newsTitle = getNewsTitle().replaceAll("\\p{Punct}", "").toLowerCase();

        Assert.assertTrue(newsTitle.contains(getUrlContent())
                , "The url content and the news title can not be matched!\n" + "Expected: " + newsTitle
                        + "\nActual: " + getUrlContent());

    }

    private String getBrowserTitle() {
        /*
         * Get the browser title.
         */
        return driver.getTitle();
    }

    private String getNewsTitle() {
        /*
         * Get the news title.
         */
        waitUntilVisible(articleTitle);
        return articleTitle.getText();

    }

    private String getUrlContent() {
        /*
         * The method purpose that get the news content from page url.
         */

        String url = driver.getCurrentUrl();
        String[] urlList = url.split("/");
        String newsContent = urlList[urlList.length - 1].replaceAll("-", " ");

        return newsContent.toLowerCase();

    }
}
