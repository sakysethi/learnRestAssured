package postRequests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostUsingOrgJson {
@Test
    public void simpleJson(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fName", "Shrishti");
        jsonObject.put("lName", "Sethi");
        jsonObject.put("age", "30");

      String bodyData = jsonObject.toJSONString();

    Response response = given()
            .contentType(ContentType.JSON)
            .body(bodyData)
            .when()
            .post("http://localhost:3000/posts");

    System.out.println(response.statusCode());
    }


    @Test
    public void complexJson(){

    JSONObject jsonObjectOuter = new JSONObject();
        jsonObjectOuter.put("fName", "Shrishti");
        jsonObjectOuter.put("lName", "Sethi");
        jsonObjectOuter.put("age", "30");
        JSONObject jsonObjectInner = new JSONObject();
        jsonObjectInner.put("fName", "Shrishti");
        jsonObjectInner.put("lName", "Sethi");
        jsonObjectInner.put("age", "30");

        jsonObjectOuter.put("InnerObject", jsonObjectInner);

      Response response=  given()
                .contentType(ContentType.JSON)
                .body(jsonObjectOuter.toJSONString())
                .when()
                .post("http://localhost:3000/posts");

        System.out.println(response.statusCode());

    }


    @Test
    public void arrayData(){


    JSONObject jsonObject1 = new JSONObject();
    jsonObject1.put("firstName", "John");
        jsonObject1.put("lastName", "Doe");
        jsonObject1.put("age", "23");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("firstName", "Mary");
        jsonObject2.put("lastName", "Smith");
        jsonObject2.put("age", "32");

        JSONArray accounting = new JSONArray();
        accounting.put(0, jsonObject1);
        accounting.put(1, jsonObject2);


        JSONObject jsonObject3 = new JSONObject();

        jsonObject3.put("firstName", "Sally");
        jsonObject3.put("lastName", "Green");
        jsonObject3.put("age", "42");

        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.put("firstName", "Jim");
        jsonObject4.put("lastName", "Galley");
        jsonObject4.put("age", "27");

        JSONArray sales = new JSONArray();
        sales.put(0, jsonObject3);
        sales.put(1, jsonObject4);

        JSONObject jsonObject5 = new JSONObject();
        jsonObject5.put("accounting", accounting);
        jsonObject5.put("sales", sales);

       Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonObject5.toJSONString())
                .when()
                .post("http://localhost:3000/posts");

        System.out.println(response.statusCode());
    }

      }

