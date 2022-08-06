package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Constants;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = ".river--homepage article")
    List<WebElement> latestNewsList;

    @FindBy(css = ".river-byline__authors")
    List<WebElement> authorListForLatestNews;

    @FindBy(css = ".river--homepage article footer figure")
    List<WebElement> imageListForLatestNews;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("User opens the selecting website (\"https://techcrunch.com\")")
    public void verifyPageIsOpen() {
        waitForLoad();
        waitUntilUrlContains(Constants.BASE_URL);
    }

    @Step("User should see the latest news are present")
    public void verifyLatestNewsListArePresent() {
        for (WebElement element : latestNewsList) {
            scrollInTheMiddleOfElement(element);
            isElementPresent(element);
        }
    }

    @Step("User should see that each news has an author")
    public void verifyThatEachNewsHasAnAuthor() {

        Assert.assertEquals(getLatestNewsAuthorsCount(), getLatestNewsCount(),
                "The author names list and latest news list can not be matched!");


    }

    @Step("User should see that each news has an image")
    public void verifyThatEachNewsHasAnImage() {
        Assert.assertEquals(getLatestNewsAuthorsCount(), getLatestNewsImagesCount(),
                "The latest news image list and latest news list can not be matched!");
    }

    @Step("User clicks the one of the latest news")
    public void clickTheLatestNews(int count) {
        WebElement news = latestNewsList.get(count - 1);
        findAndScrollElement(news, 10);
        waitUntilClickableAndClick(news);
    }

    private int getLatestNewsCount() {

        waitUntilVisibilityOfAllElements(latestNewsList);

        return latestNewsList.size();
    }

    private int getLatestNewsAuthorsCount() {

        waitUntilVisibilityOfAllElements(authorListForLatestNews);

        return authorListForLatestNews.size();
    }

    private int getLatestNewsImagesCount() {

        waitUntilVisibilityOfAllElements(imageListForLatestNews);

        return imageListForLatestNews.size();
    }

}
