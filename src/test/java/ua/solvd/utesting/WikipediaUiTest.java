package ua.solvd.utesting;

import org.testng.annotations.BeforeMethod;
import ua.solvd.utesting.ui.WikipediaPage;
import com.zebrunner.carina.core.IAbstractTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WikipediaUiTest implements IAbstractTest {
    private WebDriver localDriver;
    private WikipediaPage page;

    @BeforeClass
    public void setupLocalBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-blink-features=AutomationControlled");
        localDriver = new ChromeDriver(options);
        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        page = new WikipediaPage(localDriver);
        page.open();
    }

    @BeforeMethod
    public void returnToMainPage() {
        localDriver.navigate().to("https://wikipedia.org");
    }

    @AfterClass
    public void tearDownLocalBrowser() {
        if (localDriver != null) {
            localDriver.quit();
        }
    }

    @Test(priority = 1)
    public void testHomepageTitle() {
        Assert.assertTrue(localDriver.getTitle().contains("Wikipedia"));
    }

    @Test(priority = 2)
    public void testFooterVisibility() {
        Assert.assertTrue(page.isFooterVisible());
    }

    @Test(priority = 3)
    public void testTopicSearch() {
        page.searchForTopic("Automation");
        Assert.assertTrue(localDriver.getCurrentUrl().contains("Automation"));
    }

    @Test(priority = 4)
    public void testDeutschRedirect() {
        page.clickDeutsch();
        Assert.assertTrue(localDriver.getCurrentUrl().contains("de.wikipedia.org"));
    }

    @Test(priority = 5)
    public void testEnglishRedirect() {
        page.clickEnglish();
        Assert.assertTrue(localDriver.getCurrentUrl().contains("en.wikipedia.org"));
    }

    @Test(priority = 6)
    public void testTermsNavigation() {
        page.clickTerms();
        Assert.assertTrue(localDriver.getCurrentUrl().contains("Terms_of_Use"));
    }

    @Test(priority = 7)
    public void testPrivacyNavigation() {
        page.clickPrivacy();
        Assert.assertTrue(localDriver.getCurrentUrl().contains("Privacy_policy"));
    }

    @Test(priority = 8)
    public void testCookieNavigation() {
        page.clickCookie();
        Assert.assertTrue(localDriver.getCurrentUrl().contains("Cookie_statement"));
    }

    @Test(priority = 9)
    public void testCommonsRedirect() {
        page.clickCommons();
        Assert.assertTrue(localDriver.getCurrentUrl().contains("commons.wikimedia.org"));
    }

    @Test(priority = 10)
    public void testMultiWordSearch() {
        page.searchForTopic("Software engineering");
        Assert.assertTrue(localDriver.getCurrentUrl().contains("Software"));
    }
}