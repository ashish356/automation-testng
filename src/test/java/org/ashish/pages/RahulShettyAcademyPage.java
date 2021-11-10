package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RahulShettyAcademyPage {

    WebDriver driver;
    UICommonFunctions uiCommonFunctions;

    @FindBy(xpath = "//*[text()='Courses']")
    WebElement courses;

    public RahulShettyAcademyPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    public void validateCourseTabIsPresent()
    {
        uiCommonFunctions.highlightField(courses);
        Assert.assertTrue(courses.isDisplayed());
    }




}
