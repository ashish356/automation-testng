package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;
    UICommonFunctions uiCommonFunctions;

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[1]")
    WebElement elementsLink;

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    WebElement alertFormAndWindowsLink;



    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    public void clickAlertFormAndWindowsLink() {

        uiCommonFunctions.highlightField(alertFormAndWindowsLink);
        alertFormAndWindowsLink.click();
    }

    public void clickElementLink() {

        uiCommonFunctions.highlightField(elementsLink);
        elementsLink.click();
    }


    public void explicitWaitForElementLink()
    {

        uiCommonFunctions.explicitWait(elementsLink);
    }


}
