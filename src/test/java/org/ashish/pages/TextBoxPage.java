package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {


    WebDriver driver;
    UICommonFunctions uiCommonFunctions;

    public TextBoxPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    @FindBy(id = "userName")
    WebElement fullNameTextBox;

    @FindBy(id = "userEmail")
    WebElement emailTextBox;

    @FindBy(id = "currentAddress")
    WebElement currentAddressTextBox;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddressTextBox;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath="//div[@id='output']")
    WebElement outPutForm;

    public void setFullName(String userName)
    {
        fullNameTextBox.clear();
        uiCommonFunctions.highlightField(fullNameTextBox);
        fullNameTextBox.sendKeys(userName);
    }

    public void setEmail(String emailId)
    {
        emailTextBox.clear();
        uiCommonFunctions.highlightField(emailTextBox);
        emailTextBox.sendKeys(emailId);
    }

    public void setCurrentAddressTextBox(String currentAddress)
    {
        uiCommonFunctions.highlightField(currentAddressTextBox);
        currentAddressTextBox.clear();
        currentAddressTextBox.sendKeys(currentAddress);
    }
    public void setPermanentAddressTextBox(String permanentAddress)
    {
        uiCommonFunctions.highlightField(permanentAddressTextBox);
        permanentAddressTextBox.clear();
        permanentAddressTextBox.sendKeys(permanentAddress);
    }

    public void clickSubmitButton()
    {
        uiCommonFunctions.highlightField(submitButton);
        submitButton.click();
    }

    public void completeTextBoxValidation(String name, String emailId, String currentAddress,String permanentAddress)
    {
        this.setFullName(name);
        this.setEmail(emailId);
        this.setCurrentAddressTextBox(currentAddress);
        this.setPermanentAddressTextBox(permanentAddress);
        UICommonFunctions uiCommonFunctions=new UICommonFunctions(driver);
        uiCommonFunctions.scrollTillElement(permanentAddressTextBox);
        this.clickSubmitButton();
        uiCommonFunctions.highlightField(outPutForm);
        Assert.assertTrue(outPutForm.isDisplayed());

    }

}
