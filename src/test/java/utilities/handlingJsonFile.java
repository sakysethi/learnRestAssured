package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONTokener;

public class handlingJsonFile {

    public static String readJson(String path) throws FileNotFoundException {

        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);

        JSONTokener jsonTokener = new JSONTokener(fileInputStream);

        return jsonTokener.toString();
    }

}