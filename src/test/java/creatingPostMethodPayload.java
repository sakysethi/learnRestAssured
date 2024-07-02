import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class creatingPostMethodPayload {

   // @Test
    void getData(){

        Response response = given()
                .when()
                .get("http://localhost:3000/Employee");
        String conType = response.getContentType();
        System.out.println(conType);
//        System.out.println(response.asPrettyString());
    }

   @Test(priority = 1)
    void usingHashmap(){

       String arrMovies[] = {"Ki & Ka", "Jab We Met", "Heroine"};

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("FirstName", "Kareena");
        data.put("LastName", "Kapoor");
       data.put("id", "02");
        data.put("movies", arrMovies);

    given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/Employee")
                .then().log().all()
                .statusCode(201)
                .body("FirstName", equalTo("Kareena"))
                .header("Content-Type", "application/json; charset=utf-8");
    }

    //delete above record
    @Test(priority = 2)
    void deleteRecord(){
        given()
                .when()
                .delete("http://localhost:3000/Employee/02")
                .then()
                .statusCode(200);
    }

    //using Json.org = JSONLibrary
    @Test
    void usingJsonOrg(){
        String arrMovies[] = {"Bareilly ki Barfi", "Heropanti", "Mimi"};
        JSONObject data = new JSONObject();
        data.put("FirstName", "Kriti");
        data.put("LastName", "Sanon");
        data.put("id", "09");
        data.put("movies", arrMovies);

        given()
                .body(data.toString())
                .contentType("application/json")
                .when()
                .post("http://localhost:3000/Employee")
                .then()
                .statusCode(201);
    }

    @Test
    void usingPojoClass(){

        String arrMovies[] = {"Raazi", "Darlings", "Udta Punjab"};

        Pojo_PostRequest data = new Pojo_PostRequest();
        data.setFirstName("Alia");
        data.setLastName("Bhatt");
        data.setId("12");
        data.setMovies(arrMovies);

        given()
                .body(data)
                .contentType("application/json")
                .when()
                .post("http://localhost:3000/Employee")
                .then()
                .statusCode(201);

    }

    @Test
    void usingFile() throws FileNotFoundException {
        File file = new File("C:\\Users\\sakshsethi\\IdeaProjects\\SomeCode\\src\\test\\resources\\payloads\\usingFile.json");
        FileReader fileReader = new FileReader(file);

        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject jsonObject = new JSONObject(jsonTokener);
        given()
                .body(jsonObject.toString())
                .contentType("application/json")
                .when()
                .post("http://localhost:3000/Employee")
                .then()
                .statusCode(201);
    }
}
