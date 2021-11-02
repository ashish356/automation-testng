package org.ashish.tests.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import com.relevantcodes.extentreports.LogStatus;
import org.ashish.base.BaseTest;
import org.ashish.exceptions.CustomException;
import org.ashish.model.UserServiceCreateResponse;
import org.ashish.model.UserServiceRequest;
import org.ashish.model.UserServiceRequestUsingBuilder;
import org.ashish.model.UserServiceResponseForBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.*;

public class UserServiceTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);
    APICommonFunctions apiCommonFunctions = new APICommonFunctions();

    @Test
    public void createUserTest() {

        final String endPointUri = "https://reqres.in/api/users";

        try {
            extentTest = extentReports.startTest("Create User Service Test");
            extentTest.log(LogStatus.INFO, "Endpoint URI is :" + endPointUri);
            UserServiceRequest userServiceRequest = new UserServiceRequest();
            userServiceRequest.setJob("leader");
            userServiceRequest.setName("morpheus");
            String jsonRequestBody = new ObjectMapper().writeValueAsString(userServiceRequest);
            extentTest.log(LogStatus.INFO, "Json Request body is :" + jsonRequestBody);
            apiCommonFunctions.validateCreatedStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForPostRequest(endPointUri, jsonRequestBody));
            String jsonResponseBody = apiCommonFunctions.getJsonResponseBodyForPostRequest(endPointUri, jsonRequestBody);
            extentTest.log(LogStatus.INFO, "Json Response body is :" + jsonResponseBody);
        } catch (Exception e) {
            Assert.fail(String.format("Exception is  %s", e));
        }

    }

    @Test
    public void createUserTest2() {

        final String endPointUri = "https://reqres.in/api/users";

        try {
            extentTest = extentReports.startTest("Create User Service Test");
            extentTest.log(LogStatus.INFO, "Endpoint URI is :" + endPointUri);
            UserServiceRequest userServiceRequest = new UserServiceRequest();
            userServiceRequest.setJob("leader");
            userServiceRequest.setName("morpheus");
            String jsonRequestBody = new ObjectMapper().writeValueAsString(userServiceRequest);
            extentTest.log(LogStatus.INFO, "Json Request body is :" + jsonRequestBody);
            apiCommonFunctions.validateCreatedStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForPostRequest(endPointUri, jsonRequestBody));
            String jsonResponseBody = apiCommonFunctions.getJsonResponseBodyForPostRequest(endPointUri, jsonRequestBody);
            extentTest.log(LogStatus.INFO, "Json Response body is :" + jsonResponseBody);
            final UserServiceCreateResponse userServiceCreateResponse = new ObjectMapper().readValue(jsonResponseBody, UserServiceCreateResponse.class);
            extentTest.log(LogStatus.INFO, "Value of id is :" + userServiceCreateResponse.getId());
            extentTest.log(LogStatus.INFO, "Value of created date is :" + userServiceCreateResponse.getCreatedAt());
        } catch (Exception e) {
            Assert.fail(String.format("Exception is  %s", e));
        }

    }


    @Test
    public void createUserTestBuilder() {

        final String endPointUri = "https://reqres.in/api/users";

        try {
            extentTest = extentReports.startTest("Create User Service Test Using Builder");
            extentTest.log(LogStatus.INFO, "Endpoint URI is :" + endPointUri);
            String jsonRequestBody = new ObjectMapper().writeValueAsString(new UserServiceRequestUsingBuilder.Builder().setJob("leader").setName("morpheus").build());
            extentTest.log(LogStatus.INFO, "Json Request body is :" + jsonRequestBody);
            apiCommonFunctions.validateCreatedStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForPostRequest(endPointUri, jsonRequestBody));
            String jsonResponseBody = apiCommonFunctions.getJsonResponseBodyForPostRequest(endPointUri, jsonRequestBody);
            extentTest.log(LogStatus.INFO, "Json Response body is :" + jsonResponseBody);
            final UserServiceResponseForBuilder userServiceResponseForBuilder = new ObjectMapper().readValue(jsonResponseBody, UserServiceResponseForBuilder.class);
            extentTest.log(LogStatus.INFO, "Value of id is :" + userServiceResponseForBuilder.getId());
            extentTest.log(LogStatus.INFO, "Value of created date is :" + userServiceResponseForBuilder.getCreatedAt());
        } catch (Exception e) {
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


    @Test
    public void testExceptionClass() throws CustomException {

        extentTest = extentReports.startTest("Validating Implementation of Exception Class");
        if(1==2)
        {
            writeInfoInReports("This is strange");
        }
        else
        {
            writePassInReports("Validation is successful");
            throw new CustomException("1 can never be equal to 2");
        }
    }

    @Autowired protected ImmutableMap<String,String> marketCodeByCountry;

    @Test(enabled =false)
    public void testMarketCodeMethod()  {

        extentTest = extentReports.startTest("Validating Market Code Method");
        String marketCode = marketCodeByCountry.get("UK");
        extentTest.log(LogStatus.INFO,"Market Code For UK is :" +marketCode);


    }
}
