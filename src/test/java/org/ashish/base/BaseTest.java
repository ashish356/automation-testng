package org.ashish.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.ashish.constants.Constants;
import org.ashish.tests.api.UserServiceTest;
import org.ashish.utils.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.Date;


public class BaseTest {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public WebDriver driver;
    public static String file;

    @BeforeTest
    public void initialSetUp() {

        createDirectoryIfDoesNotExist("reports");
        createDirectoryIfDoesNotExist("testResultsDocFile");
        file=createTimeStampForFileName(new Date());
        extentReports=ExtentManager.getInstance();
    }

    protected void createDirectoryIfDoesNotExist(final String directoryName) {
        final File directory = new File(Constants.PROJECT_DIRECTORY + "/" + directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

        @AfterMethod
        public void tearDown () {

            if (driver != null) {
                driver.quit();
            }

            if (extentReports != null) {
                try {
                    extentReports.endTest(extentTest);
                    extentReports.flush();
                } catch (Exception e) {
                    extentTest.log(LogStatus.FAIL, e);
                    LOGGER.error(String.format("Exception is : %s", e));
                }
            }

        }

    public static String createTimeStampForFileName(Date date)
    {
        return date.toString().replace(":","_").replace(" ","_");
    }
    }
