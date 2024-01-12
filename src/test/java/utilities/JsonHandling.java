package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHandling {

    public static String jsonRead(String jsonFilePath) throws IOException {

        File file = new File(jsonFilePath);
        FileInputStream inputStream = new FileInputStream(file);
        JSONTokener jsonTokener = new JSONTokener(inputStream);
        JSONObject jsonObject = new JSONObject(jsonTokener);

        return jsonObject.toString();
    }

}