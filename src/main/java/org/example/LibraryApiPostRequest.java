package RSA;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class LibraryApiPostRequest {
    
    public static void main(String[] args) {
        
        RestAssured.baseURI="http://216.10.245.166";
        String response = given()
        .header("Content-Type","application/json")
        .body(LibraryApiPayload.addBook())
        .when()
        .post("Library/Addbook.php")
        .then()
.assertThat().statusCode(200)
.extract().response().asPrettyString();
System.out.println(response);

JsonPath jsonPath = new JsonPath(response);
System.out.println(jsonPath.get("ID").toString());


    }


}
