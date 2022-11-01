package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LambdaTestLoginPage {

    WebDriver driver;

    By emailId = By.id("email");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    By loginErrorMessage = By.xpath("//input[@id='email']/following-sibling::p");
    public LambdaTestLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setEmailId(String strEmailId) {
        WebElement emailIdElement = driver.findElement((By) emailId);
        emailIdElement.clear();
        emailIdElement.sendKeys(strEmailId);
    }

    public void setPassword(String strPassword){
        WebElement passwordElement = driver.findElement((By) password);
        passwordElement.clear();
        passwordElement.sendKeys(strPassword);
    }

    public void clickLoginButton() {
        driver.findElement((By) loginButton).click();
    }

    public String getLoginErrorMessage() {
        return driver.findElement((By) loginErrorMessage).getText();
    }
    public void loginToLambdaTest(String strEmailId, String strPassword) throws InterruptedException {
        this.setEmailId(strEmailId);
        this.setPassword(strPassword);
        this.clickLoginButton();
        Thread.sleep(5000);
    }

}
