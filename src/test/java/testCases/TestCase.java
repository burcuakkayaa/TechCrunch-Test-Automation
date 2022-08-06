package testCases;


import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.NewsDetailsPage;

@Epic("Smoke Tests")
@Feature("General Test Case")
public class TestCase extends TestBases {


    @Test(priority = 0, description = "Homepage and News Details Page general control")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Homepage and News Details Page general control")
    public void testCase() {
        /**
         * Test Case:
         * User opens the selecting website ("https://techcrunch.com")
         * User should see the news
         * User should see that each news has an author
         * User should see that each news has an image
         * User clicks the one of the latest news
         * User should see the news details page
         * User should see that the browser title same with the news title
         * User should see that the news within the content
         */

        //********PAGE INSTANTIATIONS********
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);
        NewsDetailsPage newsDetailsPage = new NewsDetailsPage(driver);


    }

}
