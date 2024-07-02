import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParsingBook {

    @Test
    void forJsonBodyData1() {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/book");

        String responseBody = response.getBody().asString();
      //  System.out.println(responseBody);

        JSONObject jsonObject = new JSONObject(responseBody);
        String book = jsonObject.getJSONArray("book").getJSONObject(0).get("title").toString();
        System.out.println(book);
    }

}