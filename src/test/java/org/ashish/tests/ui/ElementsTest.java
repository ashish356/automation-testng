package org.ashish.tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.ashish.base.BaseTest;
import org.ashish.pages.HomePage;
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
    public void textBoxTest() throws InterruptedException {
        extentTest = extentReports.startTest("Text Box Test");
        HomePage homePage=new HomePage(driver);
        Thread.sleep(2000);
        homePage.clickElementLink();
        Thread.sleep(2000);
        homePage.clickTextBoxLink();
        Thread.sleep(2000);
        TextBoxPage textBoxPage=new TextBoxPage(driver);
        textBoxPage.completeTextBoxValidation("Ashish", "abc@gmail.com","Brighton","Belfast");
    }

    @Test
    public void checkBoxTest()
    {
        extentTest = extentReports.startTest("Check Box Test");


    }


}
