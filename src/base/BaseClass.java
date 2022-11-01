package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass  {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;

    @BeforeMethod
    public void setup() throws Exception {
        String projectPath = System.getProperty("user.dir");

        if(driver == null) {
            FileReader fr = new FileReader(projectPath+"/src/config.properties");
            prop.load(fr);
        }

        if(prop.getProperty("browserName").equalsIgnoreCase("chrome")){
            System.out.println("Chrome it is!!");
            System.out.println(prop.getProperty("testurl"));
            System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver");
            driver = new ChromeDriver();

            // Launch website
            driver.manage().window().maximize();
            driver.get(prop.getProperty("testurl"));
        }
        else {
            throw new Exception("Driver not set!");
        }

    }

    @AfterMethod
    public void teardown() {
        driver.close();
        driver.quit();
        System.out.println("Closing the Browser");

    }
}
