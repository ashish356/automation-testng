package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    UICommonFunctions uiCommonFunctions;

    @FindBy(xpath = "//div[@class='card-up']")
    WebElement elementLink;

    @FindBy(xpath = "//span[text()='Text Box']")
    WebElement textBoxLink;

    @FindBy(xpath = "//span[text()='Check Box']")
    WebElement checkBoxLink;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    public void clickElementLink()
    {
        uiCommonFunctions.highlightField(elementLink);
        elementLink.click();
    }

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

}
