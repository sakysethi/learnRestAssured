package testScripts;

import java.util.Properties;
import testSteps.HTTPMethods;
import utilities.PropertiesHandling;

public class PostRequest {

    public static void main(String[] args) {
        PropertiesHandling.readProprties(
                "C:\\Users\\sakshsethi\\Documents\\RestAssuredDemo\\src\\test\\resources\\Fwrk\\fr.json");
        HTTPMethods httpMethods = new HTTPMethods(properties);
    }
}