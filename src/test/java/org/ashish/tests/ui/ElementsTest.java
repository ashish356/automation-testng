package org.ashish.tests.ui;

import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.ashish.base.BaseTest;
import org.ashish.pages.*;
import org.ashish.utils.SaveDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Set;


public class ElementsTest extends BaseTest {


    @BeforeMethod
    public void setUp() {

        createDirectoryIfDoesNotExist("testResultsDocFile");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        //driver.get("https://www.demoqa.com");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        //driver.get("https://rahulshettyacademy.com/angularpractice/");

    }

    @Test
    public void newTabValidation() throws InterruptedException {
        extentTest = extentReports.startTest("New Tab validation");
        RahulShettyPractisePage rahulShettyPractisePage=new RahulShettyPractisePage(driver);
        String parentWindowName=driver.getWindowHandle();
        extentTest.log(LogStatus.INFO, "Parent Tab name is " +parentWindowName);
        rahulShettyPractisePage.clickNewTab();
        Thread.sleep(5000);
        Set<String> windows=driver.getWindowHandles();
        for(String window: windows)
        {
            if(!window.equals(parentWindowName))
            {
                driver.switchTo().window(window);
                extentTest.log(LogStatus.INFO, "New Tab name is " +window);
                RahulShettyAcademyPage rahulShettyAcademyPage=new RahulShettyAcademyPage(driver);
                rahulShettyAcademyPage.validateCourseTabIsPresent();
                driver.close();
                Thread.sleep(2000);
            }
        }

    }

    @Test
    public void newWindowValidation() throws InterruptedException {
        extentTest = extentReports.startTest("New Tab validation");
        RahulShettyPractisePage rahulShettyPractisePage=new RahulShettyPractisePage(driver);
        String parentWindowName=driver.getWindowHandle();
        extentTest.log(LogStatus.INFO, "Parent Tab name is " +parentWindowName);
        rahulShettyPractisePage.clickNewWindow();
        Thread.sleep(5000);
        Set<String> windows=driver.getWindowHandles();
        for(String window: windows)
        {
            if(!window.equals(parentWindowName))
            {
                driver.switchTo().window(window);
                extentTest.log(LogStatus.INFO, "New Tab name is " +window);
                RahulShettyAcademyPage rahulShettyAcademyPage=new RahulShettyAcademyPage(driver);
                rahulShettyAcademyPage.validateCourseTabIsPresent();
                driver.close();
                Thread.sleep(2000);
            }
        }

    }


    @Test
    public void tagsValidation()  {
        extentTest = extentReports.startTest("Tags validation");
        RahulShettyPractisePage rahulShettyPractisePage=new RahulShettyPractisePage(driver);
        List<String> tags=rahulShettyPractisePage.getAllTags();
        if(rahulShettyPractisePage.tagIsPresent())
        {
            extentTest.log(LogStatus.INFO, "Tag is present. Tag size is :" +tags.size());
        }
        for(int i=0;i<tags.size();i++)
        {
            extentTest.log(LogStatus.INFO,"Tag name is :" +tags.get(i));
        }

    }

    @Test
    public void elementDisplayedValidation()  {

        extentTest = extentReports.startTest("Element Displayed validation");
        RahulShettyPractisePage rahulShettyPractisePage=new RahulShettyPractisePage(driver);
        rahulShettyPractisePage.clickHideTextBox();
        extentTest.log(LogStatus.INFO, "Hide Text Box is clicked");
        rahulShettyPractisePage.validateDisplayTextIsPresent();

    }

    @Test
    public void iFrameHomeTextValidation()  {

        extentTest = extentReports.startTest("IFrame Course Text  validation");
        RahulShettyPractisePage rahulShettyPractisePage=new RahulShettyPractisePage(driver);
        driver.switchTo().frame("courses-iframe");
        rahulShettyPractisePage.validateIFrameHomeTextIsPresent();

    }

    @Test
    public void mouseOverValidation() throws InterruptedException {

        extentTest = extentReports.startTest("Mouse Over validation");
        RahulShettyPractisePage rahulShettyPractisePage=new RahulShettyPractisePage(driver);

        rahulShettyPractisePage.mouseOverValidation();
        Thread.sleep(1000);


    }


    @Test
    public void dropDownValidation() throws InterruptedException {

        extentTest = extentReports.startTest("Drop Down Validation");
        RahulShettyPractisePage rahulShettyPractisePage=new RahulShettyPractisePage(driver);
        rahulShettyPractisePage.selectOption1DropDown();
        Thread.sleep(1000);


    }

    @Test
    public void autoSuggestionValidation() throws InterruptedException {

        extentTest = extentReports.startTest("Auto Suggestion Validation");
        RahulShettyPractisePage rahulShettyPractisePage=new RahulShettyPractisePage(driver);
        rahulShettyPractisePage.enterValueOnAutoSuggestion();
        Thread.sleep(1000);


    }


    @Test
    public void printAllWebTableContent()
    {

        String xpath1="//*[@id='product']//following::tr[";
        String xpath2="]//td[";
        String xpath3="]";
        int cost=0;
        extentTest = extentReports.startTest("Print Web table Content");
        WebElement webTable=driver.findElement(By.xpath("//*[@id='product']//following::tbody"));
        List<WebElement> totalNumberOfRows=webTable.findElements(By.tagName("tr"));
        WebElement webTableColumns=driver.findElement(By.xpath("//*[@id='product']//following::tbody//tr[2]"));
        List<WebElement> totalNumberOfColumns=webTableColumns.findElements(By.tagName("td"));
        extentTest.log(LogStatus.INFO, "Total number of Rows are :" +totalNumberOfRows.size());
        extentTest.log(LogStatus.INFO, "Total number of Columns are : " +totalNumberOfColumns.size());
        int totalRows=totalNumberOfRows.size();
        for(int i=2;i<=totalRows;i++)
        {
            for(int j=1;j<=totalNumberOfColumns.size();j++) {
                String textValue=driver.findElement(By.xpath(xpath1 + i + xpath2 + j + xpath3)).getText();
                extentTest.log(LogStatus.INFO, "Value is " +textValue);

                if(j==3)
                {
                    cost+=Integer.parseInt(textValue);
                }

            }
        }
        extentTest.log(LogStatus.INFO, "Total cost are : " +cost);
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
