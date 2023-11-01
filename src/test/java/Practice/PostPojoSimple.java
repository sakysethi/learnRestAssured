package Practice;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostPojoSimple {

    public static void main(String[] args) {

        PojoSimple pojoSimple = new PojoSimple();
        pojoSimple.setId("90");
        pojoSimple.setCountry("Spain");
        pojoSimple.setCapital("Madrid");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(pojoSimple)
                .when()
                .post("http://localhost:3000/SimpleJsonCountries");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

    }
}
