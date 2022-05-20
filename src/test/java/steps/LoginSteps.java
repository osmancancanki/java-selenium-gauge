package steps;

import base.BaseTest;
import com.thoughtworks.gauge.Step;
import utils.ConfigReader;
import utils.ElementReader;

public class LoginSteps extends BaseTest {
    ElementReader loginElements = new ElementReader("login");
    ConfigReader configReader = new ConfigReader();

    @Step("Wait for element <login_button> then click")
    public void implementation1(String key) {
        driver.findElement(loginElements.getElementValue("login_button")).click();
    }

    @Step("Enter <testuser> value to <login_email_input> input")
    public void implementation2(String text, String key) {
        driver.findElement(loginElements.getElementValue("login_email_input")).sendKeys(configReader.getProperty("user_email"));
        driver.findElement(loginElements.getElementValue("login_password_input")).sendKeys("test123");
        driver.findElement(loginElements.getElementValue("login_submit_button")).click();
    }

    @Step("Enter wrong username and password info")
    public void implementation3() {
        driver.findElement(loginElements.getElementValue("login_email_input")).sendKeys(configReader.getProperty("user_email"));
        driver.findElement(loginElements.getElementValue("login_password_input")).sendKeys(configReader.getProperty("test"));
        driver.findElement(loginElements.getElementValue("login_submit_button")).click();
    }
}
