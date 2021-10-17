package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {


    WebDriver driver;
    UICommonFunctions uiCommonFunctions;

    public RadioButtonPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    @FindBy(xpath="//label[text()='Yes']")
    WebElement yesRadioButton;

    @FindBy(xpath = "//span[text()='Yes']")
    WebElement yesText;

    public void clickYesRadioButton()
    {
        uiCommonFunctions.highlightField(yesRadioButton);
        yesRadioButton.click();
    }

    public void validateYesRadioButton()
    {
        clickYesRadioButton();
        Assert.assertTrue(uiCommonFunctions.isElementDisplayed(yesText));
        uiCommonFunctions.highlightField(yesText);
    }
}
