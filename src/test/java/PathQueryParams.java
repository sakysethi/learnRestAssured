import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PathQueryParams {


    // we only need to specify the path param in path parameter in url
    //do not need to specify query params, they go automatically with the request
    // we can choose the key for path params
    // but the keys for query params must be same as provided
    @Test
    void testParams(){

given()
        .log().all()
        .pathParam("myPath", "users")
        .queryParam("page", 2)
        .queryParam("id", 5)
        .when()
        .get("http://reqres.in/api/{myPath}")
        .then().log().all()
        .statusCode(200)        ;
    }
}
