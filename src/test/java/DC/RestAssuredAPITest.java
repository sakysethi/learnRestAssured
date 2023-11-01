package DC;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RestAssuredAPITest {

    @Test
    public void GetBooksDetails() {

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

    }

}