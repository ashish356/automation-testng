package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {



    WebDriver driver;
    UICommonFunctions uiCommonFunctions;


    public AlertPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    @FindBy(id = "alertButton")
    WebElement alertButton;

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "promtButton")
    WebElement promptButton;

    public void clickAlertButton()
    {
        uiCommonFunctions.highlightField(alertButton);
        alertButton.click();
    }
    public void clickTimerAlertButton()
    {
        uiCommonFunctions.highlightField(timerAlertButton);
        timerAlertButton.click();
    }
    public void clickConfirmButton()
    {
        uiCommonFunctions.highlightField(confirmButton);
        confirmButton.click();
    }
    public void clickPromptButton()
    {
        uiCommonFunctions.highlightField(promptButton);
        promptButton.click();
    }

    public void validateAlert() throws InterruptedException {
        clickAlertButton();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }

    public void validateTimerAlert() throws InterruptedException {
        clickTimerAlertButton();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }
    public void validateConfirmAcceptAlert() throws InterruptedException {
        clickConfirmButton();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
    public void validateConfirmCancelAlert() throws InterruptedException {
        clickConfirmButton();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
    }


    public void validatePromptAlert() throws InterruptedException {
        clickPromptButton();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("Ashish");
        driver.switchTo().alert().accept();
        Thread.sleep(4000);
    }

}
