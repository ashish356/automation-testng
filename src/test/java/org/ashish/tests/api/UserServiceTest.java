package org.ashish.tests.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.LogStatus;
import org.ashish.base.BaseTest;
import org.ashish.model.UserServiceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class UserServiceTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);
    APICommonFunctions apiCommonFunctions=new APICommonFunctions();

    @Test
    public void createUserTest()
    {

        final String endPointUri="https://reqres.in/api/users";

        try {
            extentTest = extentReports.startTest("Create User Service Test");
            extentTest.log(LogStatus.INFO,"Endpoint URI is :" +endPointUri);
            UserServiceRequest userServiceRequest =new UserServiceRequest();
            userServiceRequest.setJob("leader");
            userServiceRequest.setName("morpheus");
            String jsonRequestBody = new ObjectMapper().writeValueAsString(userServiceRequest);
            extentTest.log(LogStatus.INFO,"Json Request body is :" +jsonRequestBody);
            apiCommonFunctions.validateCreatedStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForPostRequest(endPointUri,jsonRequestBody));
            String jsonResponseBody=apiCommonFunctions.getJsonResponseBodyForPostRequest(endPointUri,jsonRequestBody);
            extentTest.log(LogStatus.INFO,"Json Response body is :" +jsonResponseBody);
        }
        catch (Exception e)
        {
            Assert.fail(String.format("Exception is  %s", e));
        }

    }


    @Test
    public void getUserTest()
    {


        final String endPointUri="https://reqres.in/api/users/2";

        try {

            extentTest = extentReports.startTest("Get User Service Test");
            extentTest.log(LogStatus.INFO,"Endpoint URI is :" +endPointUri);
            apiCommonFunctions.validateSuccessStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForGetRequest(endPointUri));
            String jsonResponseBody=apiCommonFunctions.getJsonResponseBodyForGetRequest(endPointUri);
            extentTest.log(LogStatus.INFO,"Json Response body is :" +jsonResponseBody);

        }
        catch (Exception e)
        {
            Assert.fail(String.format("Exception is  %s", e));
        }

    }

    @Test
    public void getListOfAllUsersTest()
    {
        final String endPointUri="https://reqres.in/api/users?page=2";
        try
        {
            extentTest = extentReports.startTest("Get List Of All Users Service Test");
            extentTest.log(LogStatus.INFO,"Endpoint URI is :" +endPointUri);
            apiCommonFunctions.validateSuccessStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForGetRequest(endPointUri));
            String jsonResponseBody=apiCommonFunctions.getJsonResponseBodyForGetRequest(endPointUri);
            extentTest.log(LogStatus.INFO,"Json Response body is :" +jsonResponseBody);
        }
        catch (Exception e)
        {
            Assert.fail(String.format("Exception is  %s", e));
        }
    }

    @Test
    public void userNotFoundTest()
    {
        final String endPointUri="https://reqres.in/api/users?page=2";
        try
        {
            extentTest = extentReports.startTest("User Not Found Service Test");
            extentTest.log(LogStatus.INFO,"Endpoint URI is :" +endPointUri);
            apiCommonFunctions.validateNotFoundStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForGetRequest(endPointUri));

        }
        catch (Exception e)
        {
            Assert.fail(String.format("Exception is  %s", e));
        }
    }

    @Test
    public void deleteUserTest()
    {
        final String endPointUri="https://reqres.in/api/users/2";
        try
        {
            extentTest = extentReports.startTest("Delete User Service Test");
            extentTest.log(LogStatus.INFO,"Endpoint URI is :" +endPointUri);
            apiCommonFunctions.validateDeleteStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForGetRequest(endPointUri));

        }
        catch (Exception e)
        {
            Assert.fail(String.format("Exception is  %s", e));
        }
    }


}
