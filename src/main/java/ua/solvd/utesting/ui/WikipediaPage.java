package ua.solvd.utesting.ui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WikipediaPage extends AbstractPage {

    @FindBy(id = "searchInput")
    private ExtendedWebElement searchInput;

    @FindBy(linkText = "English")
    private ExtendedWebElement englishLink;

    @FindBy(linkText = "Deutsch")
    private ExtendedWebElement deutschLink;

    @FindBy(linkText = "Commons")
    private ExtendedWebElement commonsLink;

    @FindBy(linkText = "Wikivoyage")
    private ExtendedWebElement voyageLink;

    @FindBy(linkText = "Wiktionary")
    private ExtendedWebElement dictionaryLink;

    @FindBy(css = "a[href*='terms']")
    private ExtendedWebElement termsLink;

    @FindBy(css = "a[href*='privacy']")
    private ExtendedWebElement privacyLink;

    @FindBy(css = "a[href*='cookie']")
    private ExtendedWebElement cookieLink;

    @FindBy(css = ".footer-sidebar-text")
    private ExtendedWebElement footerText;

    public WikipediaPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://wikipedia.org");
    }

    public void searchForTopic(String query) {
        if (searchInput.isElementPresent(5)) {
            searchInput.click();
            searchInput.type(query + Keys.ENTER);
        }
    }

    public void clickEnglish() {
        englishLink.click();
    }

    public void clickDeutsch() {
        deutschLink.click();
    }

    public void clickCommons() {
        commonsLink.click();
    }

    public void clickVoyage() {
        voyageLink.click();
    }

    public void clickDictionary() {
        dictionaryLink.click();
    }

    public void clickTerms() {
        termsLink.click();
    }

    public void clickPrivacy() {
        privacyLink.click();
    }

    public void clickCookie() {
        cookieLink.click();
    }

    public boolean isFooterVisible() {
        return footerText.isElementPresent(5);
    }
}