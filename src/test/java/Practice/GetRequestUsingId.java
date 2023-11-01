package Practice;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestUsingId {
    public static void main(String[] args) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/Countries/02");

        System.out.println("Status code is ==" + response.statusCode());
        System.out.println("Response Body is == ");
        System.out.println(response.asPrettyString());
    }
}