package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test(priority = 1)
    public void verifyHomePageTitle() {
        String homePageTitle = homePage.getHomePageTitle();
        Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title is not matched");

    }

    @Test(priority = 2)
    public void verifyUserNameOnHomePage() {
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyUserName(), "UserName is not displayd");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
