package Practice;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostPojoComplex {

    public static void main(String[] args) {

        Countries countries = new Countries();
        countries.setCountry1("Spain");
        countries.setCountry2("UK");
        countries.setCountry3("Germany");

        PojoComplexOuter pojoComplexOuter = new PojoComplexOuter();
        pojoComplexOuter.setId("Eurpoe");
        pojoComplexOuter.setCountries(countries);

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(pojoComplexOuter)
                .post("http://localhost:3000/ComplexJsonContinents");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

    }
}
