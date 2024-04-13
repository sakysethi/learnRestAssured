import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonAPIDemo {

    public void createRecord() {

        ObjectMapper objectMapperOuter = new ObjectMapper();
        ObjectNode postsDetails = objectMapperOuter.createObjectNode();
        postsDetails.put("fName", "Ram");
        postsDetails.put("lName", "Lanka");
        postsDetails.put("age", 30);
        postsDetails.put("Salary", 10000.80);
        postsDetails.put("isMarried", true);

        ObjectMapper objectMapperInner = new ObjectMapper();
        ObjectNode    postTechSkills   =  objectMapperInner.createObjectNode();
        postTechSkills.put("Programming Language", "Java");
        postTechSkills.put("Web Automation", "Selenium");
        postTechSkills.put("API Testing ", "RESTAssured");


    }

}