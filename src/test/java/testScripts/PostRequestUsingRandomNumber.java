package testScripts;

import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Pattern;
import org.json.JSONObject;
import org.json.JSONTokener;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.RandomNumberGeneration;

public class PostRequestUsingRandomNumber {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\sakshsethi\\Documents\\RestAssuredDemo\\src\\test\\resources\\Fwrk\\fr.json");
        FileInputStream inputStream = new FileInputStream(file);
        JSONTokener jsonTokener = new JSONTokener(inputStream);
        JSONObject jsonObject = new JSONObject(jsonTokener);

        String bodyData = jsonObject.toString();
        bodyData = bodyData.replaceAll(Pattern.quote("{{id}}"), RandomNumberGeneration.randomNumber());

        Response response = given()
                .contentType(ContentType.JSON)
                .body(bodyData)
                .when()
                .post("http://localhost:3000/Employee");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
    }

}