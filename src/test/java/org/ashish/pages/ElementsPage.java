package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {


    WebDriver driver;
    UICommonFunctions uiCommonFunctions;

    public ElementsPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    @FindBy(xpath = "//div[text()='Elements']")
    WebElement elementsLink;

    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement textBoxLink;

    @FindBy(xpath = "//span[text()='Check Box']")
    WebElement checkBoxLink;

    @FindBy(xpath = "//span[text()='Radio Button']")
    WebElement radioButtonLink;

    public void clickTextBoxLink()
    {
        uiCommonFunctions.highlightField(textBoxLink);
        textBoxLink.click();
    }
    public void clickCheckBoxLink()
    {
        uiCommonFunctions.highlightField(checkBoxLink);
        checkBoxLink.click();
    }

    public void clickRadioButtonLink()
    {
        uiCommonFunctions.highlightField(radioButtonLink);
        radioButtonLink.click();
    }

    public void explicitWaitForTextBoxLink()
    {
        uiCommonFunctions.explicitWait(textBoxLink);
    }
    public void explicitWaitForRadioButtonLink()
    {
        uiCommonFunctions.explicitWait(radioButtonLink);
    }
}
