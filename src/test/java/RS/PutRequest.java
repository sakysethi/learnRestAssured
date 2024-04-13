import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutRequest {

    @Test
    public void deleteRequest(){

        RestAssured.baseURI = "https://reqres.in/api/users/895";
        RestAssured.given()
                .when()
                .delete()
                .then().log().all()
                .statusCode(204);
    }
}
