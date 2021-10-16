package org.ashish.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.ashish.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class CommonOperations {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonOperations.class);
    public final ExtentReports extentReports= ExtentManager.getInstance();
    public static ExtentTest extentTest;


    @BeforeSuite
    public void setup()
    {

        System.out.println("Inside Before Suite");
        extentTest = extentReports.startTest(extentReports.getProjectName());
        System.out.println("Value of Extent Test ");
        createDirectoryIfDoesNotExist("reports");

    }

    @AfterSuite
    public void tearDown()
    {
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


    private void createDirectoryIfDoesNotExist(final String directoryName) {
        final File directory = new File(Constants.PROJECT_DIRECTORY + "/" + directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
    }


