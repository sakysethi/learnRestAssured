import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParsingJSONResponseData {

    @Test
    void forSimpleResponse1() {
        given()
                .when()
                .get(" http://localhost:3000/store")
                .then()
                // .log().all()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("book[3].title", equalTo("The Lord of the Rings"));

    }

    @Test
    void forSimpleResponse2() {
        Response response = given()
                .when()
                .get(" http://localhost:3000/store");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
        Assert.assertEquals(response.jsonPath().get("book[3].title").toString(), "The Lord of the Rings");

    }

    @Test
    void forJsonBodyData() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(" http://localhost:3000/store");

        //Get all book names
        JSONObject jsonObject = new JSONObject(response.toString());
        for (int i = 0; i < jsonObject.getJSONArray("book").length(); i++) {
            System.out.println(jsonObject.getJSONArray("book").getJSONObject(i).get("title").toString());
        }
    }

    @Test
    void forJsonBodyData1() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/Employee");

        //Get all book names
       JSONObject jsonObject = new JSONObject(response.toString());

       // System.out.println(jsonObject.getJSONArray("book"));
        System.out.println(jsonObject.getJSONArray("Employee").getJSONObject(0).get("FirstName").toString());
     //   for (int i = 0; i < jsonObject.getJSONArray("Employee").length(); i++) {
           // System.out.println(jsonObject.getJSONArray("Employee").getJSONObject(i).get("LastName").toString());
       //}
    }

}