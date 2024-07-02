import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoggingDemo {

    @Test
    void verifyLogging(){
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .log().body()
                .log().headers()
                .log().cookies()
                .log().status()
                .log().all()
                .log().status();

    }
}
