package testCases;


import io.qameta.allure.*;
import listeners.Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsDetailsPage;

@Epic("Smoke Tests")
@Feature("General Test Case")
@Listeners({Listener.class})
public class TestCase extends TestBases {


    @Test(priority = 1, description = "Homepage and News Details Page general control")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Homepage and News Details Page general control")
    public void testCase() {
        /*
         * Test Case:
         * User opens the selecting website ("https://techcrunch.com")
         * User should see the latest news are present
         * User should see that each news has an author
         * User should see that each news has an image
         * User clicks the one of the latest news
         * User should see the news details page
         * User should see that the browser title same with the news title
         * User should see that the links within the news content
         */

        //********PAGE INSTANTIATIONS********
        HomePage homePage = new HomePage(driver);
        NewsDetailsPage newsDetailsPage = new NewsDetailsPage(driver);

        System.out.println("User opens the selecting website (\"https://techcrunch.com\")");
        homePage.verifyPageIsOpen();

        System.out.println("User should see the latest news are present");
        homePage.verifyLatestNewsListArePresent();

        System.out.println("User should see that each news has an author");
        homePage.verifyThatEachNewsHasAnAuthor();

        System.out.println("User should see that each news has an image");
        homePage.verifyThatEachNewsHasAnImage();

        System.out.println("User clicks the one of the latest news");
        homePage.clickTheLatestNews(1);

        System.out.println("User should see the news details page");
        newsDetailsPage.verifyPageIsOpen();

        System.out.println("User should see that the browser title same with the news title");
        newsDetailsPage.verifyBrowserTitleAndNewsTitleAreSame();

        System.out.println("User should see that the links within the news content");
        newsDetailsPage.verifyTheLinksWithinTheNewsContent();

    }

}
