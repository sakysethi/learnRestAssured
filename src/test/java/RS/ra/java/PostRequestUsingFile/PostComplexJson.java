package PostRequestUsingFile;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PostComplexJson {

    public static void main(String[] args) throws FileNotFoundException {
        PostComplexJson postComplexJson = new PostComplexJson();
    String requestBody =   postComplexJson.readComplexJson();

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("http://localhost:3000/Girls");
    }

    public String readComplexJson() throws FileNotFoundException {
        File file = new File("C:\\Users\\sakshsethi\\IdeaProjects\\RestRA\\src\\test\\resources\\One\\InputPayloadComplex.json");
        FileInputStream fileInputStream = new FileInputStream(file);
        JSONTokener jsonTokener = new JSONTokener(fileInputStream);
        JSONObject jsonObject = new JSONObject(jsonTokener);
        return jsonObject.toString();
    }
}
