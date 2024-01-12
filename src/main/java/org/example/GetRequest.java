package RSA;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class GetRequest {
    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:3000";
        given().log().all()
                .when()
                .get("/SimpleJsonCountries")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
