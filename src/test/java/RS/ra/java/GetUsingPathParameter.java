import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetUsingPathParameter {

    public static void main(String[] args) {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/Girls/02");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());

    }
}

