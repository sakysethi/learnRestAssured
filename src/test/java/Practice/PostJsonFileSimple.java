package Practice;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostJsonFileSimple {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(
                "C:\\Users\\sakshsethi\\Documents\\RestAssuredDemo\\src\\test\\resources\\InputPayloadSimple.json");
        FileInputStream inputStream = new FileInputStream(file);
        JSONTokener jsonTokner = new JSONTokener(inputStream);
        JSONObject jsonObject = new JSONObject(jsonTokner);

        // System.out.println(jsonObject.toString());

        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .post("http://localhost:3000/SimpleJsonCountries");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
    }

}
