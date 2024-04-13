import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PatchRequest {

    @Test
    public void patchRequest(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Radha");
        jsonObject.put("job", "dancer");

        RestAssured.baseURI = "https://reqres.in/api/users/895";
        RestAssured.given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .patch()
                .then().log().all()
                .statusCode(200);
    }
}
