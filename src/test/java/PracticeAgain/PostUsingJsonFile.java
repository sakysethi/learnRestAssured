package PracticeAgain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostUsingJsonFile {

    public static void main(String[] args) throws FileNotFoundException {
        PostUsingJsonFile pjf = new PostUsingJsonFile();
        String requestBodyData = pjf.ReadJsonFile();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBodyData)
                .when()
                .post("http://localhost:3000/Users");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
    }

    public String ReadJsonFile() throws FileNotFoundException {

        File file = new File(
                "C:\\Users\\sakshsethi\\Documents\\RestAssuredDemo\\src\\test\\resources\\ComplexJsonFileRequestBodyData.json");
        FileInputStream inputStream = new FileInputStream(file);
        JSONTokener josnTokner = new JSONTokener(inputStream);
        JSONObject jsonObject = new JSONObject(josnTokner);
        String requestBodyData = jsonObject.toString();
        return requestBodyData;

    }

}