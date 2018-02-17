package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public static Properties prop;
    public static WebDriver driver;

    public TestBase() {
        getProperties();
    }

    private void getProperties() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/crm"
                    + "/qa/config/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialization() {
        getDriver();
        setDriverSettings();
    }

    private void getDriver() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chromedriver", "/Users/Tanya/Downloads/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "/Users/Tanya/Downloads/geckodriver-v0.19.1-win32");
            driver = new FirefoxDriver();
        }
    }

    private void setDriverSettings() {
        //        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }


}
