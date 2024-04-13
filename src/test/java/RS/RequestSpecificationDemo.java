import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestSpecificationDemo {

    @Test

    public void getRequest(){

        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri("https://reqres.in/api/users/2");

        Response response = requestSpecification.get();
        System.out.println(response.asPrettyString());
    }
}
