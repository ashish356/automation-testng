package org.ashish.tests.api;

import io.restassured.RestAssured;

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
    protected  String  getJsonResponseBodyForGetRequest(String endPointUri)
    {
        return RestAssured.with()
                .given()
                .contentType("application/json")
                .when()
                .get(endPointUri)
                .asString();
    }
}
