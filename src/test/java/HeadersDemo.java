import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {


    @Test
    void verifyHeaders(){
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Server", "gws");

    }


    @Test
    void fetchOneHeaders(){
        Response response = given()
                .when()
                .get("https://www.google.com/");

        System.out.println(response.getHeader("Content-Type"));
    }

    @Test
    void fetchMultipleHeaders(){
        Response response = given()
                .when()
                .get("https://www.google.com/");

       Headers myHeaders = response.getHeaders();
       for(Header head :myHeaders){
           System.out.println(head.getName()+ "  ===   "+ head.getValue());
       }
    }
}
