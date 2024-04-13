import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostRequest {

    @Test
    public void testPostRequest() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Prachi");
        jsonObject.put("job", "QA");

        RestAssured.baseURI = "https://reqres.in/api/users";

        RestAssured.given().log().all()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())

                .when().post()
                .then().log().all()
                .statusCode(201);
    }

}
