import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class MyGetrequest {

    @Test
    public void getRequest(){
        Response response1 = RestAssured
                .get("http://localhost:3000/posts");
        System.out.println(response1.asPrettyString());

    Response response2 = RestAssured.given()
            .contentType(ContentType.JSON)
            .when()
            .get("http://localhost:3000/posts");
        System.out.println(response2.asPrettyString());
    }
}
