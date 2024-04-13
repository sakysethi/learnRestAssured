import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BDDImplementation {


    @Test
    public void testGetRequest() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Response Body : " + response.getBody());
        System.out.println("Response Time : " + response.getTime());
        System.out.println("Response Date : " + response.getHeader("Content-Type"));

        int actualStatusCode = response.getStatusCode();
        int expectedStatusCode = 200;
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    @Test
    public void testGetRequestBDD() {

        RestAssured.baseURI = "https://reqres.in/api/users";
        RestAssured
                .given().queryParam("page", "2")
                .when().get()
                .then().statusCode(200);
    }

}
