package Utils;

import io.restassured.path.json.JsonPath;

public class JsonPathParser {

    public static JsonPath rawToJson(String response){

        JsonPath jsonPath = new JsonPath(response);
        return jsonPath;
    }
}
