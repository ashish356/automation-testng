package org.ashish.tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.ashish.base.BaseTest;
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
    public void textBoxTest()
    {
        extentTest = extentReports.startTest("Text Box Test");



    }

    @Test
    public void checkBoxTest()
    {
        extentTest = extentReports.startTest("Check Box Test");


    }


}
