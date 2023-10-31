import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestUsingID {

    public static void main(String[] args) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/Employee/02");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
    }
}
