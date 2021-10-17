package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogsPage {


    WebDriver driver;
    UICommonFunctions uiCommonFunctions;

    public ModalDialogsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    @FindBy(id = "showSmallModal")
    WebElement smallModalButton;

    @FindBy(id = "showLargeModal")
    WebElement largeModalButton;

    @FindBy(id = "closeSmallModal")
    WebElement closeSmallModalButton;

    @FindBy(id = "closeLargeModal")
    WebElement closeLargeModalButton;

    public void clickSmallModalButton()
    {
        uiCommonFunctions.highlightField(smallModalButton);
        smallModalButton.click();
    }
    public void clickLargeModalButton()
    {
        uiCommonFunctions.highlightField(largeModalButton);
        largeModalButton.click();
    }
    public void clickCloseSmallModalButton()
    {

        uiCommonFunctions.highlightField(closeSmallModalButton);
        closeSmallModalButton.click();
    }
    public void clickCloseLargeModalButton()
    {

        uiCommonFunctions.highlightField(closeLargeModalButton);
        closeLargeModalButton.click();
    }

    public void validateSmallModalDialogButton()
    {
        uiCommonFunctions.scrollUpTillTopOfThePage();
        clickSmallModalButton();
        Assert.assertTrue(closeSmallModalButton.isDisplayed());
        clickCloseSmallModalButton();

    }

    public void validateLargeModalDialogButton()
    {
        uiCommonFunctions.scrollUpTillTopOfThePage();
        clickLargeModalButton();
        Assert.assertTrue(closeLargeModalButton.isDisplayed());
        clickCloseLargeModalButton();

    }

}
