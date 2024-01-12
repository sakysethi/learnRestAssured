package RSA;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import Payload.placePayload;

public class PostRequest {
    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:3000";
        String response = given().log().all()
                // .queryParam("id", "56")
                .header("Content-Type", "application/json")
                .body(placePayload.addPlacePayload())
                .when()
                .post("/SimpleJsonCountries")
                .then().log().all()
                .assertThat().statusCode(201).body("country", equalTo("Spain"))
                .header("Accept", equalTo(null))
                .extract().response().asString();

        System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);
        String capital = jsonPath.getString("capital");

        System.out.println(capital);

    }
}
