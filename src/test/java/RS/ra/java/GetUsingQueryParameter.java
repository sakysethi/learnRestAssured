import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetUsingQueryParameter {

    public static void main(String[] args) {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("Name", "Deepika")
                .when()
            //    .get("http://localhost:3000/Girls?Name=Deepika");
                .get("http://localhost:3000/Girls");
        System.out.println(response.asPrettyString());
        System.out.println(response.statusCode());
    }
}