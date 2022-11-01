package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LambdaTestHomePage;
import pages.LambdaTestLoginPage;
import utils.ReadExcelData;
import utils.TestDataProvider;

import static constants.Constants.LOGINPAGE_ERRORMESSAGE;

public class LambdaTestLoginTestExcel extends BaseClass {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "incorrectCreds")
    public static void testLoginWithIncorrectCreds(String emailId, String password) throws InterruptedException {
        LambdaTestHomePage homePage = new LambdaTestHomePage(driver);
        LambdaTestLoginPage loginPage = new LambdaTestLoginPage(driver);

        homePage.clickLoginLinkText();

        loginPage.loginToLambdaTest(emailId, password);

        Assert.assertEquals(loginPage.getLoginErrorMessage(), LOGINPAGE_ERRORMESSAGE);

    }


}
