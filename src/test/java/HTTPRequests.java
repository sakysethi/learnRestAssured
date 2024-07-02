import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequests {

    int id=0;
    @Test(priority = 1)
    void getUser() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 2)
    void createUser(){

        String bodyData = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

       id = given()
                .body(bodyData)
                .contentType("application/json")
                .when()
                .post("https://reqres.in/api/users")
                .then().log().all()
                .statusCode(201)
                .extract().response().jsonPath().getInt("id");
        System.out.println(id);
    }
   @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUser(){
        HashMap<String, String> bodyData = new HashMap<String, String>();
        bodyData.put("name", "morpheus");
        bodyData.put("job", "leader");

        given()
                .log().all()
                .body(bodyData)
                .contentType("application/json") .when()
                .put("https://reqres.in/api/users/"+id)
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 4, dependsOnMethods = {"createUser"})
    void deleteUser(){
        given()
               .when()
                .delete("https://reqres.in/api/users/"+id)
                .then().log().all()
                .statusCode(204);
    }
}
