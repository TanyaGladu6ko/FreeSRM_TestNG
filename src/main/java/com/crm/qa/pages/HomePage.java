package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Tanya on 1/26/2018.
 */
public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'User: TestQA TestQA')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(), 'Contacts')]")
    WebElement getLinkToContactsPage;

    @FindBy(xpath = "//a[contains(text(), 'Deals')]")
    WebElement getLinkToDealsPage;

    @FindBy(xpath = "//a[contains(text(), 'Tasks')]")
    WebElement getLinkToTasksPage;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public boolean verifyUserName() {
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink() {
        getLinkToDealsPage.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsPage() {
        getLinkToDealsPage.click();
        return new DealsPage();
    }

    public TaskPage clickOnTaskPAge() {
        getLinkToTasksPage.click();
        return new TaskPage();
    }


}
