package com.automation.utils;


import java.io.*;
import java.util.Properties;

public class ConfigUtils {

    static Properties properties = new Properties();
    static String propertyFilePath = "config\\config.properties";

    public static Properties loadProperties() {
        try {
            InputStream propertiesInputStream = Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream(propertyFilePath);
            properties.load(propertiesInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getURL() {
        String url = loadProperties().getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("Application url not specified in " + propertyFilePath);
    }

    public static String getBrowser() {
        String browser = loadProperties().getProperty("browser");
        if (browser != null) return browser;
        else throw new RuntimeException("browser is not specified in " + propertyFilePath);
    }

    public static String getDriverPath() {
        String driverPath = loadProperties().getProperty("driver.path");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driver path is not specified in " + propertyFilePath);
    }

    public static String getImplicitWait() {
        String implicitWait = loadProperties().getProperty("implicit.wait");
        if (implicitWait != null) return implicitWait;
        else throw new RuntimeException("implicit wait is not specified in " + propertyFilePath);
    }
}
