import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ReadJSONResponseBody {
    //https://reqres.in/api/users/2

    @Test
    public static void readJSONResponseBody() {

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in");
        requestSpecification.basePath("/api/users?page=2");

        Response responseBody = requestSpecification.get();
        System.out.println(responseBody.asPrettyString());
        //System.out.println("The Response code is " + responseBody.getStatusCode());
    }
}