package org.ashish.tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.ashish.base.BaseTest;
import org.ashish.pages.ElementsPage;
import org.ashish.pages.HomePage;
import org.ashish.pages.RadioButtonPage;
import org.ashish.pages.TextBoxPage;
import org.ashish.utils.SaveDocument;
import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ElementsTest extends BaseTest {


    @BeforeMethod
    public void setUp() {

        createDirectoryIfDoesNotExist("testResultsDocFile");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.demoqa.com");

    }

    @Test
    public void textBoxTest() throws Exception {
        extentTest = extentReports.startTest("Text Box Test");
        String testCaseName="Text Box Test Validation";
        HomePage homePage=new HomePage(driver);
        UICommonFunctions uiCommonFunctions=new UICommonFunctions(driver);
        homePage.explicitWaitForElementLink();
        uiCommonFunctions.capture("HomePage");
        uiCommonFunctions.takeScreenShot("Home Page");
        homePage.clickElementLink();
        ElementsPage elementsPage=new ElementsPage(driver);
        elementsPage.explicitWaitForTextBoxLink();
        elementsPage.clickTextBoxLink();
        uiCommonFunctions.capture("ElementPage");
        uiCommonFunctions.takeScreenShot("Element Page");
        TextBoxPage textBoxPage=new TextBoxPage(driver);
        textBoxPage.completeTextBoxValidation("Ashish", "abc@gmail.com","Brighton","Belfast");
        SaveDocument.createDoc(testCaseName,new String[]{"HomePage", "ElementPage","TextBoxPage"});
    }

    @Test
    public void radioButtonTest() throws Exception {
        extentTest = extentReports.startTest("Radio Button Test");
        String testCaseName="Radio Button Test Validation";
        UICommonFunctions uiCommonFunctions=new UICommonFunctions(driver);
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickElementLink();
        ElementsPage elementsPage=new ElementsPage(driver);
        elementsPage.explicitWaitForRadioButtonLink();
        elementsPage.clickRadioButtonLink();
        uiCommonFunctions.capture("RadioButton Page");
        uiCommonFunctions.takeScreenShot("RadioButton Page");
        RadioButtonPage radioButtonPage=new RadioButtonPage(driver);
        radioButtonPage.validateYesRadioButton();
        SaveDocument.createDoc(testCaseName,new String[]{"RadioButton Page"});
    }


}
