package utils;

import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by duongnartist on 1/18/16.
 */
public class FileUtils {
    public static final String JSON = ".json";

    public static void write(JSONObject object, String path) {
        FileWriter file = null;
        try {
            file = new FileWriter(path + JSON);
            file.write(object.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject read(String path) {
        FileWriter file = null;
        JSONObject object = null;
        try {
            object = new JSONObject(new FileReader(path + JSON));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}
