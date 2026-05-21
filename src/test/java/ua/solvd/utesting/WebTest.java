package ua.solvd.utesting;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.solvd.utesting.ui.WikipediaArticlePage;
import ua.solvd.utesting.ui.WikipediaHomePage;

public class WebTest implements IAbstractTest {

    @BeforeMethod
    public void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    @Test(description = "Test 11: verify Home Page is opened...")
    public void testOpenHomePage() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Wikipedia Home Page did not open.");
    }

    @Test(description = "Test 12: search for article: Neverwinter Nights...")
    public void testSearchNeverwinterNights() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        WikipediaArticlePage articlePage = homePage.searchFor("Neverwinter Nights");
        Assert.assertTrue(articlePage.getTitle().contains("Neverwinter Nights"), "Article title does not match.");
    }

    @Test(description = "Test 13: search for article: The Elder Scrolls III: Morrowind...")
    public void testSearchMorrowind() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        WikipediaArticlePage articlePage = homePage.searchFor("Morrowind");
        Assert.assertTrue(articlePage.getTitle().contains("Morrowind"), "Article title does not match.");
    }

    @Test(description = "Test 14: search for article: Lineage II...")
    public void testSearchLineage2() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        WikipediaArticlePage articlePage = homePage.searchFor("Lineage II");
        Assert.assertTrue(articlePage.getTitle().contains("Lineage II"), "Article title does not match.");
    }

    @Test(description = "Test 15: search for tabletop game: Dungeons & Dragons...")
    public void testSearchDungeonsAndDragons() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        WikipediaArticlePage articlePage = homePage.searchFor("Dungeons & Dragons");
        Assert.assertTrue(articlePage.getTitle().contains("Dungeons & Dragons"), "Article title does not match.");
    }

    @Test(description = "Test 16: verify 'Log in' button presence...")
    public void testLoginButtonPresence() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isLoginButtonPresent(), "Login button is missing on the Home Page.");
    }

    @Test(description = "Test 17: verify 'Create account' button presence...")
    public void testCreateAccountButtonPresence() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isCreateAccountButtonPresent(), "Create account button is missing.");
    }

    @Test(description = "Test 18: verify left navigation menu presence...")
    public void testLeftMenuPresence() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isLeftMenuPresent(), "Left navigation menu is not found.");
    }

    @Test(description = "Test 19: navigate to a random article...")
    public void testRandomArticle() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        WikipediaArticlePage articlePage = homePage.clickRandomArticle();
        Assert.assertFalse(articlePage.getTitle().isEmpty(), "Random article title is empty.");
    }

    @Test(description = "Test 20: verify page Title contains 'Wikipedia'...")
    public void testPageTitle() {
        WikipediaHomePage homePage = new WikipediaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(getDriver().getTitle().contains("Wikipedia"), "Page title does not contain the word 'Wikipedia'.");
    }
}