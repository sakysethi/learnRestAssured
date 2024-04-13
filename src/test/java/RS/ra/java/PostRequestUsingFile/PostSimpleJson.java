package PostRequestUsingFile;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PostSimpleJson {

    public static void main(String[] args) throws FileNotFoundException {
        PostSimpleJson postSimpleJson = new PostSimpleJson();
        String requestBody = postSimpleJson.readSimpleJson();

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
        .when()
                .post("http://localhost:3000/Girls");

    }

    public String readSimpleJson() throws FileNotFoundException {
        File file = new File("../RestRA/src/test/resources/One/InputPayloadSimple.json");
        FileInputStream fileInputStream = new FileInputStream(file);
        JSONTokener jsonTokener = new JSONTokener(fileInputStream);
        JSONObject jsonObject = new JSONObject(jsonTokener);
        return jsonObject.toString();

    }
}
