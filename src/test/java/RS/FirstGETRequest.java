import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FirstGETRequest {
    //https://reqres.in/api/users/2

    @Test
    public static void getRequest() {

        Response response = RestAssured.get("https://reqres.in/api/users/2");
        System.out.println(response.asPrettyString());
        System.out.println("The Response code is " + response.getStatusCode());
    }
}