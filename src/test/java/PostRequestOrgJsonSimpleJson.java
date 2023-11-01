import static io.restassured.RestAssured.*;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestOrgJsonSimpleJson {
    public static void main(String[] args) {

        JSONObject requestBodyData = new JSONObject();
        requestBodyData.put("FirstName", "Kiara");
        requestBodyData.put("LastName", "Advani");
        requestBodyData.put("id", "06");

        // System.out.println(requestBodyData);

        Response response =

                given()
                        .contentType(ContentType.JSON)
                        .body(requestBodyData.toString())
                        .when()
                        .post("http://localhost:3000/Employee");

        System.out.println();

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

    }

}