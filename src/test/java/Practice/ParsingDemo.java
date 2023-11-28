package Practice;

import static io.restassured.RestAssured.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingDemo {

    public static void main(String[] args) {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/SimpleJsonCountries");

        System.out.println(response.statusCode());
        // System.out.println(response.asPrettyString());

        JSONArray jsonArray = new JSONArray(response.asPrettyString());

        JSONObject jsonObject1 = jsonArray.getJSONObject(4);
        System.out.println(jsonObject1.get("id"));

        // multiple ids
        int len = jsonArray.length();
        for (int i = 0; i <= len; i++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
            System.out.println(jsonObject2.get("id"));
        }

    }
}
