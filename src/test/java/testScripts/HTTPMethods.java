package testSteps;

import java.util.Properties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class HTTPMethods {

    Properties properties;

    public HTTPMethods(Properties properties) {
        this.properties = properties;
    }

    public void postRequest(String bodyData, String uri) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyData)
                .when()
                .post(properties.getProperty(uri));

        System.out.println(response.statusCode());
    }

    public static void getAllRequest() {

    }

}