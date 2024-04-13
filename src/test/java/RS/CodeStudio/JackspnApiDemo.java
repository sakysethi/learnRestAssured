package CodeStudio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class JackspnApiDemo {

    @Test
    public void testJackson() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("fName", "Jahanvi");
        objectNode.put("lName", "Kirwai");
        objectNode.put("age", 21);

        String bodyData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);

        given()
                .contentType(ContentType.JSON)
                .body(bodyData)
                .when()
                .post("http://localhost:3000/posts");

    }
}
