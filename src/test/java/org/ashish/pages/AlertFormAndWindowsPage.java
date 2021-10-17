package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFormAndWindowsPage {


    WebDriver driver;
    UICommonFunctions uiCommonFunctions;


    public AlertFormAndWindowsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    @FindBy(xpath = "//span[text()='Modal Dialogs']")
    WebElement modalDialogLink;

    @FindBy(xpath = "//span[text()='Alerts']")
    WebElement alertLink;

    public void clickModalDialogsLink()
    {
        uiCommonFunctions.scrollTillElement(new ElementsPage(driver).elementsLink);
        uiCommonFunctions.highlightField(modalDialogLink);
        modalDialogLink.click();
    }
    public void clickAlertLink()
    {

        uiCommonFunctions.highlightField(alertLink);
        alertLink.click();
    }
}
