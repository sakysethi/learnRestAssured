import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonSchemaValidation {

    @Test
    void validateSchema(){

        given()
                .when()
                .get(" http://localhost:3000/menu")
                .then()
                .statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema/SchemaOne.json"));
    }
}
