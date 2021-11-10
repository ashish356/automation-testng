package org.ashish.pages;

import org.ashish.tests.ui.UICommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class RahulShettyPractisePage {

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
