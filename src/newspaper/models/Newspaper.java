package newspaper.models;

import org.json.JSONArray;
import org.json.JSONObject;
import realestate.RealEstate;
import utils.FileUtils;

import java.util.ArrayList;

/**
 * Created by Duong on 19/01/2016.
 */
public class Newspaper extends JSONObject {

    public static final String PREFIX = Newspaper.class.getSimpleName().toLowerCase();
    public static final String ID = PREFIX + "Id";
    public static final String NAME = PREFIX + "Name";
    public static final String URL = PREFIX + "Url";
    private static ArrayList<Newspaper> newspapers = new ArrayList<Newspaper>();

    public Newspaper() {

    }

    public Newspaper(int id, String name, String note) {
        setId(id);
        setName(name);
        setUrl(note);
    }

    public static ArrayList<Newspaper> getNewspapers() {
        return newspapers;
    }

    public static void init() {
        JSONObject object = new JSONObject();
        JSONArray objects = new JSONArray();
        int id = 0;
        newspapers.clear();
        Newspaper newspaper = new Newspaper(++id, "http://vnexpress.net/", "note");
        newspapers.add(newspaper);
        objects.put(newspaper);
        object.put(PREFIX, objects);
        FileUtils.write(object, RealEstate.HOME + PREFIX);
        for (Newspaper aNewspaper : newspapers) {
            System.out.println("Trang Báo: " + aNewspaper.getName());
        }
    }

    public int getId() {
        return getInt(ID);
    }

    public void setId(int id) {
        put(ID, id);
    }

    public String getName() {
        return getString(NAME);
    }

    public void setName(String name) {
        put(NAME, name);
    }

    public String getUrl() {
        return getString(URL);
    }

    public void setUrl(String url) {
        put(URL, url);
    }
}
