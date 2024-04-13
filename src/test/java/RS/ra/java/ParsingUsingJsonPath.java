import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;
public class ParsingUsingJsonPath {

    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:3000/Girls";

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get();
      //  System.out.println(response.asPrettyString());

        //parsing
        JSONArray jsonArray = new JSONArray(response.asString());
//        JSONObject jsonObject = jsonArray.getJSONObject(0);
//        System.out.println(jsonObject.get("id"));

        JSONObject jsonObject = jsonArray.getJSONObject(3);
        JSONObject jsonObject1 = jsonObject.getJSONObject("Countries");
        System.out.println(jsonObject1.get("Country2"));
    }

}
