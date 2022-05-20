package utils;

import org.openqa.selenium.By;

import java.io.*;
import java.util.Properties;

public class ElementReader {
    private Properties properties;

    public ElementReader(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/test/resources/elements/" + fileName + ".properties"));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Properties file not found at " + fileName);
        }
    }

    public By getElementValue(String locatorName) {
        String locatorProperty = properties.getProperty(locatorName);
        String locatorType = locatorProperty.split(":")[0];
        String locatorValue = locatorProperty.split(":")[1];

        By locator = null;
        switch (locatorType) {
            case "id":
                locator = By.id(locatorValue);
                break;
            case "className":
                locator = By.name(locatorValue);
                break;
            case "cssSelector":
                locator = By.cssSelector(locatorValue);
                break;
            case "linkText":
                locator = By.linkText(locatorValue);
                break;
            case "tagName":
                locator = By.tagName(locatorValue);
                break;
            case "xpath":
                locator = By.xpath(locatorValue);
                break;
        }
        return locator;
    }
}
