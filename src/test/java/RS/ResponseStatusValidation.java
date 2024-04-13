import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResponseStatusValidation {

    @Test(enabled = false)

    public void getRequest(){

        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri("https://reqres.in/api/users/2");

        Response response = requestSpecification.get();
        int statusCode = response.getStatusCode();
String statusLine = response.statusLine();
        //Assert.assertEquals(statusCode, 200);
Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }

    @Test
    public void getRequestWithBDD(){

        RestAssured.given()
                .when()
                    .get("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200)
                    .statusLine("HTTP/1.1 200 OK");
    }
}
