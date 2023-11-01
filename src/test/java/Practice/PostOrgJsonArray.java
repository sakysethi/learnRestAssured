package Practice;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostOrgJsonArray {

    public static void main(String[] args) {

        // create array object
        JSONArray officeLocation = new JSONArray();
        officeLocation.put(0, "Delhi");
        officeLocation.put(1, "Bangalore");
        officeLocation.put(2, "Chnnai");

        // create JSONObject
        JSONObject employee = new JSONObject();
        employee.put("id", "802");
        employee.put("Office", officeLocation);

        // post data
        Response response = given()
                .contentType(ContentType.JSON)
                .body(employee.toString())
                .when()
                .post("http://localhost:3000/ArrayJsonEmployee");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

    }

}
