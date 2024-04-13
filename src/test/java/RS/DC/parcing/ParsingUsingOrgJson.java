package DC.parcing;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ParsingUsingOrgJson {

    @Test
    public void parsing() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/api/users")
                .contentType("ContentType.JSON");

        Response response = requestSpecification.get();

        JSONArray jsonArray = new JSONArray(response.toString());
        JSONObject jsonObject = new JSONObject();

    }

}