package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class handlingPropertiesFile {

    public static Properties readProperties(String path) throws IOException {

        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);

        Properties properties = new Properties();
        properties.load(fileInputStream);

        return properties;
    }
}