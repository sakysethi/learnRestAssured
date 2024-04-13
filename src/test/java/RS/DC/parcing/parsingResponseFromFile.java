package DC.parcing;

import groovy.json.JsonToken;
import org.json.JSONTokener;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class parsingResponseFromFile {

    @Test
    public void readFromFile() throws FileNotFoundException {

        File file = new File("C:\\Users\\sakshsethi\\IdeaProjects\\RESTCodeStudio\\src\\test\\java\\DC\\parcing\\ResponseBody.json");
        FileInputStream fileInputStream = new FileInputStream(file);
        JSONTokener jsonTokener = new JSONTokener(fileInputStream);

       // JSONObject jsonObject = new JSONObject(jsonTokener);


    }

}
