import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BDDUsingStaticMethods {

    @Test
    public void testGetRequestBDD() {

        baseURI = "https://reqres.in/api/users";

        given().log().all().queryParam("page", "2")
                .when().get()
                .then().log().all().statusCode(200);
    }

}
