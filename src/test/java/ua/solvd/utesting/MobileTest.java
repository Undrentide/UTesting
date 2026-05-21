package ua.solvd.utesting;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.solvd.utesting.ui.CalculatorPage;

public class MobileTest implements IAbstractTest {

    @Test(description = "Test 21: Verify addition: 2 + 3 = 5...")
    public void testAddition() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickTwo();
        calcPage.clickPlus();
        calcPage.clickThree();
        calcPage.clickEquals();
        Assert.assertEquals(calcPage.getResult(), "5", "Addition logic is broken.");
    }

    @Test(description = "Test 22: Verify subtraction: 5 - 2 = 3...")
    public void testSubtraction() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickFive();
        calcPage.clickMinus();
        calcPage.clickTwo();
        calcPage.clickEquals();
        Assert.assertEquals(calcPage.getResult(), "3", "Subtraction logic is broken.");
    }

    @Test(description = "Test 23: Verify multiplication: 4 * 2 = 8...")
    public void testMultiplication() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickFour();
        calcPage.clickMultiply();
        calcPage.clickTwo();
        calcPage.clickEquals();
        Assert.assertEquals(calcPage.getResult(), "8", "Multiplication logic is broken.");
    }

    @Test(description = "Test 24: Verify division: 8 / 4 = 2...")
    public void testDivision() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickEight();
        calcPage.clickDivide();
        calcPage.clickFour();
        calcPage.clickEquals();
        Assert.assertEquals(calcPage.getResult(), "2", "Division logic is broken.");
    }

    @Test(description = "Test 25: Verify clear button (C/AC)...")
    public void testClearButton() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickEight();
        calcPage.clickClear();
        String result = calcPage.getResult();
        Assert.assertTrue(result.isEmpty() || result.equals("0"), "Clear button did not reset the output.");
    }

    @Test(description = "Test 26: Verify division by zero behavior...")
    public void testDivisionByZero() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickFive();
        calcPage.clickDivide();
        calcPage.clickZero();
        calcPage.clickEquals();
        String result = calcPage.getResult();
        Assert.assertNotEquals(result, "0", "Dividing by zero should not return 0.");
    }

    @Test(description = "Test 27: Verify multiple operations order: 2 + 3 * 4 = 14...")
    public void testMultipleOperations() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickTwo();
        calcPage.clickPlus();
        calcPage.clickThree();
        calcPage.clickMultiply();
        calcPage.clickFour();
        calcPage.clickEquals();
        Assert.assertEquals(calcPage.getResult(), "14", "Order of operations (BODMAS) is broken.");
    }

    @Test(description = "Test 28: Verify double-digit addition: 20 + 30 = 50...")
    public void testDoubleDigitAddition() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickTwo();
        calcPage.clickZero();
        calcPage.clickPlus();
        calcPage.clickThree();
        calcPage.clickZero();
        calcPage.clickEquals();
        Assert.assertEquals(calcPage.getResult(), "50", "Double digit addition failed.");
    }

    @Test(description = "Test 29: Verify negative results: 2 - 5 = -3...")
    public void testNegativeResult() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickTwo();
        calcPage.clickMinus();
        calcPage.clickFive();
        calcPage.clickEquals();
        String actualResult = calcPage.getResult();
        Assert.assertEquals(actualResult, "−3", "Negative result calculation failed");
    }

    @Test(description = "Test 30: Verify multiplying by zero: 8 * 0 = 0")
    public void testMultiplyByZero() {
        CalculatorPage calcPage = new CalculatorPage(getDriver());
        calcPage.clickClear();
        calcPage.clickEight();
        calcPage.clickMultiply();
        calcPage.clickZero();
        calcPage.clickEquals();
        Assert.assertEquals(calcPage.getResult(), "0", "Multiplying by zero failed");
    }
}