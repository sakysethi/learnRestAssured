import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestPojoSimpleJson {

    public static void main(String[] args) {

        PojoSimple pojoSimple = new PojoSimple();
        pojoSimple.setfName("Varun");
        pojoSimple.setlName("Dhawan");
        pojoSimple.setId("202");

        Response response =

                given()
                        .contentType(ContentType.JSON)
                        .body(pojoSimple)
                        .when()
                        .post("http://localhost:3000/Employee");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
    }
}
