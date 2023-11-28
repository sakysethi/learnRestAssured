package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandling {

    public static Properties readProprties(String propertiesFilePath) throws IOException {

        File file = new File(propertiesFilePath);
        // "C:\\Users\\sakshsethi\\Documents\\RestAssuredDemo\\URI.properties"
        FileInputStream inputStream = new FileInputStream(file);

        Properties properties = new Properties();
        properties.load(inputStream);

        return properties;

    }

}