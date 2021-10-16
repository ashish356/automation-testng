package org.ashish.tests.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UICommonFunctions {

    private final WebDriver driver;

    public UICommonFunctions(WebDriver driver)
    {
        this.driver=driver;
    }

    public void click(By object)
    {
        highlightField(object);
        explicitWait(object);
        driver.findElement(object).click();

    }

    public void enterValue(By object,String value)
    {
        highlightField(object);
        clearTextBox(object);
        driver.findElement(object).sendKeys(value);

    }
    public void clearTextBox(By object)
    {
        driver.findElement(object).clear();
    }

    public void explicitWait(By object)
    {
        WebDriverWait webDriverWait=new WebDriverWait(driver,20);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(object));
    }

    public String getText(By object)
    {
        highlightField(object);
        return driver.findElement(object).getText();
    }


    public  boolean isElementPresent(By object)
    {
        try
        {

            return driver.findElements(object).size()>0;

        }
        catch(Exception e)
        {
            return  false;
        }
    }

    public  void highlightField(By object)
    {

        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        WebElement element=driver.findElement(object);
        javascriptExecutor.executeScript("arguments[0].style.border='4px groove green'",element );
        try
        {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        javascriptExecutor.executeScript("arguments[0].style.border=''",element);
    }


    public  void highlightField(WebElement element)
    {

        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].style.border='4px groove green'",element );
        try
        {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        javascriptExecutor.executeScript("arguments[0].style.border=''",element);
    }

    public void mouseover(By object)
    {

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(object)).build().perform();
        try
        {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void selectDropDownByValue(By object, String value)
    {

        new Select(driver.findElement(object)).selectByValue(value);
    }

    public void selectDropDownByIndex(By object, int index)
    {

        new Select(driver.findElement(object)).selectByIndex(index);
    }
    public List<WebElement> getAllDropDownValues(By object)
    {

        return  new Select(driver.findElement(object)).getOptions();
    }

    public String selectedFirstDropDown(By object)
    {
        return new Select(driver.findElement(object)).getFirstSelectedOption().getText();
    }

    public void scrollTillElement(By object)
    {

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(object));
        try
        {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void scrollTillElement(WebElement element)
    {

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try
        {
            Thread.sleep(1000);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void scrollUpTillTopOfThePage() {

        driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void scrollPageTillEndOfThePage()
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try
        {
            Thread.sleep(5000);
        }catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void selectRadioButton(By object)
    {
        highlightField(object);
        if(!driver.findElement(object).isSelected())
        {
            driver.findElement(object).click();
        }
    }

    public boolean isElementSelected(By object)
    {
        return driver.findElement(object).isSelected();
    }

    public boolean isElementDisplayed(By object)
    {
        return driver.findElement(object).isDisplayed();
    }

}
