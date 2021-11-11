package org.ashish.pages;

import com.relevantcodes.extentreports.LogStatus;
import org.ashish.base.BaseTest;
import org.ashish.tests.ui.UICommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RahulShettyPractisePage extends BaseTest {

    WebDriver driver;
    UICommonFunctions uiCommonFunctions;


    public RahulShettyPractisePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        uiCommonFunctions=new UICommonFunctions(driver);
    }

    @FindBy(id = "opentab")
    WebElement openTab;

    @FindBy(id = "openwindow")
    WebElement openWindow;

    @FindBy(tagName = "a")
    List<WebElement> allTags;

    @FindBy(id = "hide-textbox")
    WebElement hideTextBox;

    @FindBy(id = "displayed-text")
    WebElement displayText;

    @FindBy(id = "mousehover")
    WebElement mouseOver;

    @FindBy(xpath = "//a[text()='Top']")
    WebElement mouseOverTopDropDown;

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    WebElement iFrameHomeText;

    public void clickTopDropDown()
    {
        uiCommonFunctions.highlightField(mouseOverTopDropDown);
        mouseOverTopDropDown.click();
    }

    public void mouseOverValidation() throws InterruptedException {
        uiCommonFunctions.scrollTillElement(mouseOver);
        Actions actions=new Actions(driver);
        actions.moveToElement(mouseOver).build().perform();
        Thread.sleep(2000);
        clickTopDropDown();
    }

    public void clickHideTextBox()
    {
        uiCommonFunctions.highlightField(hideTextBox);
        hideTextBox.click();
    }

    public boolean displayTextIsPresent()
    {

        return displayText.isDisplayed();
    }

    public boolean IFrameHomeTextIsPresent()
    {

        return iFrameHomeText.isDisplayed();
    }

    public void validateDisplayTextIsPresent()
    {
       if(displayTextIsPresent())
       {
           extentTest.log(LogStatus.PASS,"Display text is present");
       }
       else
       {
           extentTest.log(LogStatus.FAIL,"Display text is not present");
           Assert.fail();
       }
    }

    public void validateIFrameHomeTextIsPresent()
    {
        if(IFrameHomeTextIsPresent())
        {
            uiCommonFunctions.scrollTillElement(iFrameHomeText);
            uiCommonFunctions.highlightField(iFrameHomeText);
            extentTest.log(LogStatus.PASS,"IFrame Home text is present");
        }
        else
        {
            extentTest.log(LogStatus.FAIL,"IFrame Home text is not present");
            Assert.fail();
        }
    }

    public void clickNewTab()
    {
        uiCommonFunctions.highlightField(openTab);
        openTab.click();
    }

    public void clickNewWindow()
    {
        uiCommonFunctions.highlightField(openWindow);
        openWindow.click();
    }

    public List<String> getAllTags()
    {

        List<String> tags=new ArrayList<>();
        for(WebElement tag:allTags)
        {
            tags.add(tag.getText());
        }
        return tags;
    }

    public boolean tagIsPresent()
    {
        return allTags.size()>0;
    }

}
