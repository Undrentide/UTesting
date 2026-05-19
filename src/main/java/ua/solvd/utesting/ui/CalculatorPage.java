package ua.solvd.utesting.ui;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends AbstractPage {

    @FindBy(id = "com.sonymobile.exactcalculator:id/result")
    private ExtendedWebElement resultField;

    @FindBy(id = "com.sonymobile.exactcalculator:id/digit_0")
    private ExtendedWebElement btn0;

    @FindBy(id = "com.sonymobile.exactcalculator:id/digit_2")
    private ExtendedWebElement btn2;

    @FindBy(id = "com.sonymobile.exactcalculator:id/digit_3")
    private ExtendedWebElement btn3;

    @FindBy(id = "com.sonymobile.exactcalculator:id/digit_4")
    private ExtendedWebElement btn4;

    @FindBy(id = "com.sonymobile.exactcalculator:id/digit_5")
    private ExtendedWebElement btn5;

    @FindBy(id = "com.sonymobile.exactcalculator:id/digit_8")
    private ExtendedWebElement btn8;

    @FindBy(id = "com.sonymobile.exactcalculator:id/op_add")
    private ExtendedWebElement btnPlus;

    @FindBy(id = "com.sonymobile.exactcalculator:id/op_sub")
    private ExtendedWebElement btnMinus;

    @FindBy(id = "com.sonymobile.exactcalculator:id/op_mul")
    private ExtendedWebElement btnMultiply;

    @FindBy(id = "com.sonymobile.exactcalculator:id/op_div")
    private ExtendedWebElement btnDivide;

    @FindBy(id = "com.sonymobile.exactcalculator:id/eq")
    private ExtendedWebElement btnEquals;

    @FindBy(id = "com.sonymobile.exactcalculator:id/del")
    private ExtendedWebElement btnClear;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void clickZero() {
        btn0.click();
    }

    public void clickTwo() {
        btn2.click();
    }

    public void clickThree() {
        btn3.click();
    }

    public void clickFour() {
        btn4.click();
    }

    public void clickFive() {
        btn5.click();
    }

    public void clickEight() {
        btn8.click();
    }

    public void clickPlus() {
        btnPlus.click();
    }

    public void clickMinus() {
        btnMinus.click();
    }

    public void clickMultiply() {
        btnMultiply.click();
    }

    public void clickDivide() {
        btnDivide.click();
    }

    public void clickEquals() {
        btnEquals.click();
    }

    public void clickClear() {
        btnClear.click();
    }

    public String getResult() {
        return resultField.getText();
    }
}