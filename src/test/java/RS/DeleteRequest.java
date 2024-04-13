import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class DeleteRequest {

    @Test
    public void putRequest(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Radha");
        jsonObject.put("job", "dancer");

        RestAssured.baseURI = "https://reqres.in/api/users/895";
        RestAssured.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .put()
                .then().log().all()
                .statusCode(200);
    }
}
