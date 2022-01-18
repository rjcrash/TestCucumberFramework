package com.automation.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtils {

    static WebDriverWait wait = DriverUtils.getDriverWait();

    public static void waitForVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static  void selectValueFromDropDownByVisibleTxt(WebElement element, String value) {
        Select option = new Select(element);
        option.selectByVisibleText(value);
    }

    public static  WebElement getSelectedOptionFromDropDown(WebElement element) {
        Select option = new Select(element);
        WebElement firstOption =option.getFirstSelectedOption();
        return firstOption;
    }
}