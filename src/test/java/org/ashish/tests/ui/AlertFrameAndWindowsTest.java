package org.ashish.tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.ashish.base.BaseTest;
import org.ashish.pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertFrameAndWindowsTest extends BaseTest {


    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.demoqa.com");

    }

    @Test
    public void smallModalDialogTest() {
        extentTest = extentReports.startTest("Small Modal Dialog Test");
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickAlertFormAndWindowsLink();
        AlertFormAndWindowsPage alertFormAndWindowsPage=new AlertFormAndWindowsPage(driver);
        alertFormAndWindowsPage.clickModalDialogsLink();
        ModalDialogsPage modalDialogsPage=new ModalDialogsPage(driver);
        modalDialogsPage.validateSmallModalDialogButton();
    }

    @Test
    public void largeModalDialogTest() {
        extentTest = extentReports.startTest("Large Modal Dialog Test");
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickAlertFormAndWindowsLink();
        AlertFormAndWindowsPage alertFormAndWindowsPage=new AlertFormAndWindowsPage(driver);
        alertFormAndWindowsPage.clickModalDialogsLink();
        ModalDialogsPage modalDialogsPage=new ModalDialogsPage(driver);
        modalDialogsPage.validateLargeModalDialogButton();
    }

    @Test
    public void alertTest() throws Exception {
        extentTest = extentReports.startTest("Alert Test");
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickAlertFormAndWindowsLink();
        AlertFormAndWindowsPage alertFormAndWindowsPage=new AlertFormAndWindowsPage(driver);
        alertFormAndWindowsPage.clickAlertLink();
        AlertPage alertPage=new AlertPage(driver);
        alertPage.validateAlert();


    }

    @Test
    public void timerAlertTest() throws Exception {
        extentTest = extentReports.startTest("Timer Alert Test");
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickAlertFormAndWindowsLink();
        AlertFormAndWindowsPage alertFormAndWindowsPage=new AlertFormAndWindowsPage(driver);
        alertFormAndWindowsPage.clickAlertLink();
        AlertPage alertPage=new AlertPage(driver);
        alertPage.validateTimerAlert();


    }

    @Test
    public void confirmAcceptAlertTest() throws Exception {
        extentTest = extentReports.startTest("Confirm Accept Alert Test");
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickAlertFormAndWindowsLink();
        AlertFormAndWindowsPage alertFormAndWindowsPage=new AlertFormAndWindowsPage(driver);
        alertFormAndWindowsPage.clickAlertLink();
        AlertPage alertPage=new AlertPage(driver);
        alertPage.validateConfirmAcceptAlert();

    }

    @Test
    public void confirmDismissAlertTest() throws Exception {
        extentTest = extentReports.startTest("Confirm Accept Dismiss Test");
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickAlertFormAndWindowsLink();
        AlertFormAndWindowsPage alertFormAndWindowsPage=new AlertFormAndWindowsPage(driver);
        alertFormAndWindowsPage.clickAlertLink();
        AlertPage alertPage=new AlertPage(driver);
        alertPage.validateConfirmCancelAlert();

    }

    @Test
    public void promptAlertTest() throws Exception {
        extentTest = extentReports.startTest("Prompt Alert Test");
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickAlertFormAndWindowsLink();
        AlertFormAndWindowsPage alertFormAndWindowsPage=new AlertFormAndWindowsPage(driver);
        alertFormAndWindowsPage.clickAlertLink();
        AlertPage alertPage=new AlertPage(driver);
        alertPage.validatePromptAlert();

    }
}
