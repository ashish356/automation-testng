package org.ashish.base;

import com.google.common.collect.ImmutableMap;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.ashish.constants.Constants;
import org.ashish.tests.api.UserServiceTest;
import org.ashish.utils.ExtentManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.Date;

@Configuration
@ComponentScan("org.ashish")
@EnableAutoConfiguration
@EnableConfigurationProperties
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
        file = createTimeStampForFileName(new Date());
        extentReports = ExtentManager.getInstance();
    }

    protected void createDirectoryIfDoesNotExist(final String directoryName) {
        final File directory = new File(Constants.PROJECT_DIRECTORY + "/" + directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    @AfterMethod
    public void tearDown() {

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

    public static String createTimeStampForFileName(Date date) {
        return date.toString().replace(":", "_").replace(" ", "_");
    }


    public void writeInfoInReports(String message) {
        extentTest.log(LogStatus.INFO, message);
        LOGGER.info(message);

    }

    public void writePassInReports(String message) {
        extentTest.log(LogStatus.PASS, message);
        LOGGER.info(message);

    }

    public void writeFailInReports(String message) {
        extentTest.log(LogStatus.FAIL, message);
        LOGGER.info(message);
        Assert.fail(message);

    }

    @Bean
    public ImmutableMap<String, String> marketCodeByCountry() {
        return ImmutableMap.<String, String>builder()
                .put("UK", "036")
                .put("DENMARK", "018")
                .put("NETHERLANDS/IEC", "029")
                .put("JAPAN", "010")
                .put("GERMANY", "023")
                .put("INDIA", "012")
                .put("MEXICO", "002")
                .put("ITALY", "027")
                .put("SWEDEN", "034")
                .put("FRANCE", "022")
                .put("TAIWAN", "039")
                .put("FINLAND", "021")
                .put("SPAIN", "033")
                .put("NORWAY", "030")
                .put("HONG KONG", "009")
                .put("AUSTRIA", "016")
                .build();

    }
}

