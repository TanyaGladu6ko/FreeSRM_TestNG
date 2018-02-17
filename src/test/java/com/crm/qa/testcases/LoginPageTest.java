package com.crm.qa.testcases;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void validateLoginPageTitle() {
        String title = loginPage.getTitlePage();
        Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
    }

    @Test(priority = 2)
    public void crmLogoImageTest() {
        boolean flag = loginPage.validateCRMImage();
        Assert.assertEquals(flag, true);
    }

    @Test(priority = 3)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
