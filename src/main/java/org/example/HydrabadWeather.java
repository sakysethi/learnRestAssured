package Basics;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class HydrabadWeather {


    @Test
    public void HydrabadWeatherDetails() {
        RestAssured.baseURI = "https://restapi.demoqa.com";
        given().log().all();
    }

}
