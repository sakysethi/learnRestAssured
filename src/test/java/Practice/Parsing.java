package Practice;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Parsing {
    public static void main(String[] args) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/SimpleJsonCountries");

        JSONArray jsonArray = new JSONArray(response.asPrettyString());
        int lengethOfResponseArray = jsonArray.length();

        for (int i = 0; i <= lengethOfResponseArray; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.getString("id"));
        }

    }
}
