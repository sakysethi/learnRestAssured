package Practice;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteRequest {

    public static void main(String[] args) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/Countries/04");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
    }
}