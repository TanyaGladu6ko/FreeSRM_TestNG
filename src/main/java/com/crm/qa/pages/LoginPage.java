package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //PageFactory - OR:
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//button[contains(text(),'Sing Up)']")
    WebElement singUpBtn;

    @FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
    WebElement crmLogo;

    //initializing the Page Objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String getTitlePage() {
        return driver.getTitle();
    }

    //validation of image
    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }

    public HomePage login(String iUserName, String iPassword) {
        username.sendKeys(iUserName);
        password.sendKeys(iPassword);
    //    loginBtn.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginBtn);

        return new HomePage();
    }

}
