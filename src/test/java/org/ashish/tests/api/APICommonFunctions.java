package org.ashish.tests.api;

import io.restassured.RestAssured;
import org.eclipse.jetty.http.HttpStatus;
import org.testng.Assert;

public class APICommonFunctions {


    protected  int getJsonResponseStatusCodeForPostRequest(String endPointUri, String jsonRequestBody)
    {
        return RestAssured.with()
                .given()
                .contentType("application/json")
                .body(jsonRequestBody)
                .when()
                .post(endPointUri)
                .statusCode();
    }

    protected  int getJsonResponseStatusCodeForGetRequest(String endPointUri)
    {
        return RestAssured.with()
                .given()
                .contentType("application/json")
                .when()
                .get(endPointUri)
                .statusCode();
    }
    protected  int getJsonResponseStatusCodeForPutRequest(String endPointUri, String jsonRequestBody)
    {
        return RestAssured.with()
                .given()
                .contentType("application/json")
                .body(jsonRequestBody)
                .when()
                .put(endPointUri)
                .statusCode();
    }

    protected  int getJsonResponseStatusCodeForDeleteRequest(String endPointUri, String jsonRequestBody)
    {
        return RestAssured.with()
                .given()
                .contentType("application/json")
                .body(jsonRequestBody)
                .when()
                .delete(endPointUri)
                .statusCode();
    }
    protected  String  getJsonResponseBodyForPostRequest(String endPointUri, String jsonRequestBody)
    {
        return RestAssured.with()
                .given()
                .contentType("application/json")
                .body(jsonRequestBody)
                .when()
                .post(endPointUri)
                .asString();
    }
    protected String  getJsonResponseBodyForGetRequest(String endPointUri)
    {
        return RestAssured.with()
                .given()
                .contentType("application/json")
                .when()
                .get(endPointUri)
                .asString();
    }

    public void validateSuccessStatusCode(int jsonResponseCode)
    {
        Assert.assertEquals(jsonResponseCode, HttpStatus.OK_200);
    }
    public void validateCreatedStatusCode(int jsonResponseCode)
    {
        Assert.assertEquals(jsonResponseCode,HttpStatus.CREATED_201);
    }
    public void validateNotFoundStatusCode(int jsonResponseCode)
    {
        Assert.assertEquals(jsonResponseCode,HttpStatus.NOT_FOUND_404);
    }
    public void validateDeleteStatusCode(int jsonResponseCode)
    {
        Assert.assertEquals(jsonResponseCode,HttpStatus.NO_CONTENT_204);
    }
}
