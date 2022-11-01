package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LambdaTestHomePage;
import pages.LambdaTestLoginPage;

import static constants.Constants.LOGINPAGE_ERRORMESSAGE;

public class LambdaTestLoginTest extends BaseClass {

    @Test(dataProvider = "incorrectCreds")
    public static void testLoginWithIncorrectCreds(String emailId, String password) throws InterruptedException {
        LambdaTestHomePage homePage = new LambdaTestHomePage(driver);
        LambdaTestLoginPage loginPage = new LambdaTestLoginPage(driver);

        homePage.clickLoginLinkText();

        loginPage.loginToLambdaTest(emailId, password);

        Assert.assertEquals(loginPage.getLoginErrorMessage(), LOGINPAGE_ERRORMESSAGE);

    }

    @DataProvider(name="incorrectCreds")
    public Object[][] incorrectCreds(){
        {
            return new Object[][] {
                    {"seleniumtestng@selenium.com","Selenium@2022"},
                    {"teleniumtestng@selenium.com","Telenium@2022"}
            };
        }
    }

}
