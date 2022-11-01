package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LambdaTestHomePage {

    WebDriver driver;

    By loginLinkText = By.linkText("Login");

    public LambdaTestHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLinkText() {
        driver.findElement(loginLinkText).click();
    }
}
