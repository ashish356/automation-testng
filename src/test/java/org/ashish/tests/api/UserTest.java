package org.ashish.tests.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ashish.model.UserService;
import org.eclipse.jetty.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {


    @Test
    public void createUserTest()
    {

        APICommonFunctions apiCommonFunctions=new APICommonFunctions();

        final String endPointUri="https://reqres.in/api/users";

        try {

            UserService userService=new UserService();
            userService.setJob("leader");
            userService.setName("morpheus");
            String jsonRequestBody = new ObjectMapper().writeValueAsString(userService);
            System.out.println(String.format("Json Request Body is %s",jsonRequestBody));
            validateCreatedStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForPostRequest(endPointUri,jsonRequestBody));
            System.out.println(String.format("Json Response Body is %s", apiCommonFunctions.getJsonResponseBodyForPostRequest(endPointUri,jsonRequestBody)));

        }
        catch (Exception e)
        {
            Assert.fail(String.format("Exception is  %s", e));
        }

    }



    @Test
    public void getUserTest()
    {

        APICommonFunctions apiCommonFunctions=new APICommonFunctions();

        final String endPointUri="https://reqres.in/api/users/2";

        try {

            validateSuccessStatusCode(apiCommonFunctions.getJsonResponseStatusCodeForGetRequest(endPointUri));
            System.out.println(apiCommonFunctions.getJsonResponseBodyForGetRequest(endPointUri));

        }
        catch (Exception e)
        {
            Assert.fail(String.format("Exception is  %s", e));
        }

    }

    public void validateSuccessStatusCode(int jsonResponseCode)
    {
            Assert.assertEquals(jsonResponseCode,HttpStatus.OK_200);
    }
    public void validateCreatedStatusCode(int jsonResponseCode)
    {
        Assert.assertEquals(jsonResponseCode,HttpStatus.CREATED_201);
    }
}
