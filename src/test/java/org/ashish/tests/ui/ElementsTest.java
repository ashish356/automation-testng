package org.ashish.tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.ashish.base.BaseTest;
import org.ashish.pages.ElementsPage;
import org.ashish.pages.HomePage;
import org.ashish.pages.RadioButtonPage;
import org.ashish.pages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ElementsTest extends BaseTest {


    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.demoqa.com");

    }

    @Test
    public void textBoxTest() {
        extentTest = extentReports.startTest("Text Box Test");
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickElementLink();
        ElementsPage elementsPage=new ElementsPage(driver);
        elementsPage.explicitWaitForTextBoxLink();
        elementsPage.clickTextBoxLink();
        TextBoxPage textBoxPage=new TextBoxPage(driver);
        textBoxPage.completeTextBoxValidation("Ashish", "abc@gmail.com","Brighton","Belfast");
    }

    @Test
    public void radioButtonTest() {
        extentTest = extentReports.startTest("Radio Button Test");
        HomePage homePage=new HomePage(driver);
        homePage.explicitWaitForElementLink();
        homePage.clickElementLink();
        ElementsPage elementsPage=new ElementsPage(driver);
        elementsPage.explicitWaitForRadioButtonLink();
        elementsPage.clickRadioButtonLink();
        RadioButtonPage radioButtonPage=new RadioButtonPage(driver);
        radioButtonPage.validateYesRadioButton();


    }


}
