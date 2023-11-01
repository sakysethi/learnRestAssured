package Practice;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import groovy.json.JsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostJsonFileComplex {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(
                "C:\\Users\\sakshsethi\\Documents\\RestAssuredDemo\\src\\test\\resources\\InputPayloadComplex.json");
        FileInputStream inputStream = new FileInputStream(file);

        JsonBuilder tokner = new JsonBuilder(inputStream);

        // JSONArray array = new JSONArray();

        JSONObject jsonObject = new JSONObject(tokner);

        System.out.println(jsonObject.toString());

        // Response response = given()
        // .contentType(ContentType.JSON)
        // .body(jsonObject.toString())
        // .when()
        // .post("http://localhost:3000/ComplexJsonContinents");

        // System.out.println(response.statusCode());
        // System.out.println(response.asPrettyString());

    }

}
