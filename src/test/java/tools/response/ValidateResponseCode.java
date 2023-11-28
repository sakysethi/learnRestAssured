package tools.response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidateResponseCode {

    @Test
    public void validateResponseCode() {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/SimpleJson");
        int statusCode1 = response.getStatusCode();
        Assert.assertEquals(statusCode1, 200, "Request Successful");

        // Response responseInvalid = given()
        // .contentType(ContentType.JSON)
        // .when()
        // .get("http://localhost:3000/SimpleJsonn");
        // int statusCode2 = responseInvalid.getStatusCode();
        // Assert.assertEquals(statusCode2, 200, "Request Successful");

        String statusLine = response.getStatusLine();
        System.out.println(statusLine);

    }

}