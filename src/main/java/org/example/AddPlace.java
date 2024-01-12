package Basics;

import Payload.placePayload;
import Utils.JsonPathParser;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;

public class AddPlace {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(placePayload.addPlacePayload())
                .when()
                .post("/maps/api/place/add/json")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        String placeId = jsonPath.getString("place_id");

        System.out.println(placeId);

        String updatedAddress = "70, Summer Walk, USA";

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + placeId + "\",\n" +
                        "\"address\":\"" + updatedAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("maps/api/place/update/json?key=qaclick123")
                .then().log().all()
                .assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

        String updatedResponse = given().log().all()
                .queryParam("place_id", placeId)
                .queryParam("key", "qaclick123")
                .when().get("maps/api/place/get/json")
                .then().log().all()
                .statusCode(200)
                .extract().response().asString();

        JsonPath jsonPath1 = JsonPathParser.rawToJson(updatedResponse);
        String getUpdatedAddress = jsonPath1.getString("address");

        // Assert.assertEquals(updatedAddress, getUpdatedAddress);

    }

}