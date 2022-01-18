package com.automation.utils;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import static com.automation.utils.DriverUtils.getDriver;

public class AssertionUtils {

    public static void assertPresent(WebElement element) {
        WebElementUtils.waitForVisible(element);
        Assert.assertTrue(String.format("Element %s should be displayed !!!", element.getText()), element.isDisplayed());
    }

    public static void assertEquals(WebElement element, String expected) {
        WebElementUtils.waitForVisible(element);
        Assert.assertTrue(String.format("Actual text is %s and expected text is %s", element.getText(), expected), element.getText().equals(expected));
    }

    public static void assertEquals(WebElement element, int expected) {
        WebElementUtils.waitForVisible(element);
        Assert.assertTrue(String.format("Actual text is %s and expected text is %s", element.getText(), expected),  Integer.parseInt(element.getText())==expected);
    }

    public static void assertContains(WebElement element, String expected) {
        WebElementUtils.waitForVisible(element);
        Assert.assertTrue(String.format("Actual text is %s and expected text is %s", element.getText(), expected), element.getText().contains(expected));
    }

    public static void assertPageTitle(String expected) {
        String actualTitle = getDriver().getTitle();
        Assert.assertTrue(String.format("Actual text is %s and expected text is %s", actualTitle  , expected), actualTitle.contains(expected));
    }

    public static void assertNotEquals(WebElement element, String expected) {
        WebElementUtils.waitForVisible(element);
        Assert.assertTrue(String.format("Actual text is %s and it the same as expected text %s", element.getText(), expected), !element.getText().equals(expected));
    }

}