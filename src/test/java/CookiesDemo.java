import static io.restassured.RestAssured.given;
import static io.restassured.response.Response.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

public class CookiesDemo {

//@Test
void seeCookiesInResponse(){
    given()
            .when()
            .get("https://www.google.com/")
            .then()
            .log().all();
}
    @Test
    void getCookiesInfo(){
        Response response = given()
                .when()
                .get("https://www.google.com/");
       // System.out.println(response.getCookie("AEC"));

        Map<String, String> allCookies = response.getCookies();
        //System.out.println(allCookies.keySet());

        for (String key : allCookies.keySet()){
            System.out.println(key +" == "+response.getCookie(key));
        }
    }
}
