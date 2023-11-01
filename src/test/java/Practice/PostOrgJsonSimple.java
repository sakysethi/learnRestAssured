package Practice;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostOrgJsonSimple {

    public static void main(String[] args) {

        // creating body data
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "07");
        jsonObject.put("Country", "Italy");
        jsonObject.put("Capital", "Rome");

        // posting bodyData
        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .post("http://localhost:3000/Countries");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
    }
}
