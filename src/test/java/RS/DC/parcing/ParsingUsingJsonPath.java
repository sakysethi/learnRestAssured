package DC.parcing;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ParsingUsingJsonPath {

    @Test
    public void parsing() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://dummy.restapiexample.com/api/v1/employees");

        Response response = requestSpecification.get();

        //System.out.println(response.asPrettyString());


        //print emp4 salary
        int salary = response.jsonPath().get("data[3].employee_salary");
        System.out.println(salary);

      //  print message
        System.out.println(response.jsonPath().getString("message"));




    }

}