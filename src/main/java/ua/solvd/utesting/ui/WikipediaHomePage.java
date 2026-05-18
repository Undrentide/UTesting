package ua.solvd.utesting.ui;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class WikipediaHomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//form[@id='searchform']//input[@name='search']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//a[contains(@href, 'UserLogin')]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//a[contains(@href, 'CreateAccount')]")
    private ExtendedWebElement createAccountButton;

    @FindBy(id = "n-randompage")
    private ExtendedWebElement randomArticleButton;

    @FindBy(id = "vector-main-menu")
    private ExtendedWebElement leftMenu;

    @FindBy(id = "vector-main-menu-dropdown-label")
    private ExtendedWebElement hamburgerMenuButton;

    public WikipediaHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("wikipedia_url"));
    }

    @Override
    public boolean isPageOpened() {
        return searchInput.isElementPresent();
    }

    public WikipediaArticlePage searchFor(String text) {
        searchInput.click();
        searchInput.type(text);
        searchInput.sendKeys(Keys.ENTER);
        return new WikipediaArticlePage(getDriver());
    }

    public boolean isLoginButtonPresent() {
        return loginButton.isElementPresent();
    }

    public boolean isCreateAccountButtonPresent() {
        return createAccountButton.isElementPresent();
    }

    public boolean isLeftMenuPresent() {
        expandMenuIfHidden();
        return leftMenu.isElementPresent();
    }

    public WikipediaArticlePage clickRandomArticle() {
        expandMenuIfHidden();
        randomArticleButton.click();
        return new WikipediaArticlePage(getDriver());
    }

    private void expandMenuIfHidden() {
        if (hamburgerMenuButton.isElementPresent(2)) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].click();", hamburgerMenuButton.getElement());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                LOGGER.error("Thread was interrupted while waiting for menu animation", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}