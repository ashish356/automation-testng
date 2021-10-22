package org.ashish.utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import org.ashish.base.BaseTest;


import java.io.File;
import java.util.Date;

public class ExtentManager extends BaseTest {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            //Date date=new Date();
            String reportFilePath=file;
            //String fileName=date.toString().replace(":", "_").replace(" ", "_")+".html";
            String fileName=reportFilePath+ ".html";
            extent = new ExtentReports(System.getProperty("user.dir") +"/reports/"+reportFilePath +"/" +fileName, true, DisplayOrder.OLDEST_FIRST);
            extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
            // optional
            extent.addSystemInfo("Selenium Version", "3.12.0").addSystemInfo(
                    "Environment", "QA");
        }
        return extent;
    }
}
