package DC;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestOrgJsonComplexJson {
    public static void main(String[] args) {

        JSONObject innerObject = new JSONObject();
        innerObject.put("FirstName", "Jahanvi");
        innerObject.put("LastName", "Kapoor");

        JSONObject outerObject = new JSONObject();
        outerObject.put("Name", innerObject);
        outerObject.put("id", "102");

        // System.out.println(requestBodyData);

        Response response =

                given()
                        .contentType(ContentType.JSON)
                        .body(outerObject.toString())
                        .when()
                        .post("http://localhost:3000/Employee");

        // System.out.println();

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

    }
}
