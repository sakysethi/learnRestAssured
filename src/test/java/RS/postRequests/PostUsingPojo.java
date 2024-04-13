package postRequests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PostUsingPojo {

    @Test
    public void simpleJson() {

        SimpleDataPojo simpleDataPojo = new SimpleDataPojo();
        simpleDataPojo.setCity("Gandhinagar");
        simpleDataPojo.setState("Gujrat");
        simpleDataPojo.setId(89899);

        given()
                .contentType(ContentType.JSON)
                .body(simpleDataPojo)
                .when().post("http://localhost:3000/posts");
    }

    @Test
    public void complexJson() {

        SimpleDataPojo simpleDataPojo = new SimpleDataPojo();
        simpleDataPojo.setCity("Shimla");
        simpleDataPojo.setState("Himachal Pradesh");
        simpleDataPojo.setId(898998);

        ComplexDataPojo complexDataPojo = new ComplexDataPojo();
        complexDataPojo.setCountry("India");
        complexDataPojo.setCapital("New Delhi");
        complexDataPojo.getSimpleDataPojo(simpleDataPojo);

        given()
                .contentType(ContentType.JSON)
                .body(complexDataPojo)
                .when()
                .post("http://localhost:3000/posts");
    }

}
