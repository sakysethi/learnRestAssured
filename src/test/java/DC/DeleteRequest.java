package DC;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteRequest {

    public static void main(String[] args) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/SimpleJson/02");

        System.out.println(response.statusCode()); // 200
        System.out.println(response.asPrettyString()); // No data
    }
}
