package Practice;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostOrgJsonComplex {

    public static void main(String[] args) {

        // create inner object
        JSONObject countryObject = new JSONObject();
        countryObject.put("Country1", "Brazil");
        countryObject.put("Country2", "South Africa");
        countryObject.put("Country3", "Ghana");

        // create outer object
        JSONObject countriesObject = new JSONObject();
        countriesObject.put("id", "Africa");
        countriesObject.put("Countries", countryObject);

        // post query
        Response response = given()
                .contentType(ContentType.JSON)
                .body(countriesObject.toString())
                .when()
                .post("http://localhost:3000/Continents");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
        

    }

}
