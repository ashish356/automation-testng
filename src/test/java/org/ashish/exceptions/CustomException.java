package org.ashish.exceptions;

import org.ashish.base.BaseTest;

public class CustomException extends Exception {

    public CustomException(String message)
    {
        super(message);
        BaseTest baseTest=new BaseTest();
        baseTest.writeInfoInReports(message);
    }

}
