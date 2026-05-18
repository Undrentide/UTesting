package ua.solvd.utesting.ui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WikipediaArticlePage extends AbstractPage {

    @FindBy(id = "firstHeading")
    private ExtendedWebElement articleTitle;

    public WikipediaArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return articleTitle.getText();
    }
}