package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DriverUtils {
    static WebDriver driver;
    static WebDriverWait webDriverWait;

    public static void initDriver() {

        System.setProperty("webdriver.chrome.driver", ConfigUtils.getDriverPath());
        if (ConfigUtils.getBrowser().equals("chrome")){
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(ConfigUtils.getURL());
    }


    public static WebDriver getDriver() {

        if (driver == null) {
            initDriver();
        }
        return driver;
    }
    public static WebDriverWait getDriverWait() {
        Long timeout = Long.parseLong(ConfigUtils.getImplicitWait());
        webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return webDriverWait;
    }

    public static void tearDown() {
        driver.quit();
        driver = null;
    }
}
