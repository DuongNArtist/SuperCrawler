package realestate.models;

import org.json.JSONArray;
import org.json.JSONObject;
import realestate.RealEstate;
import utils.FileUtils;

/**
 * Created by duongnartist on 1/18/16.
 */
public class Page extends JSONObject {
    public static final String PREFIX = Page.class.getSimpleName().toLowerCase();
    public static final String ID = PREFIX + "Id";
    public static final String NAME = PREFIX + "Name";
    public static final String URL = PREFIX + "Url";
    public static final String NOTE = PREFIX + "Note";
    private static JSONArray pages = new JSONArray();

    public Page() {

    }

    public Page(int id, String name, String url, String note) {
        setId(id);
        setName(name);
        setUrl(url);
        setNote(note);
    }

    public static JSONArray getPages() {
        return pages;
    }

    public static void init() {
        JSONObject object = new JSONObject();
        int id = 0;
        pages = new JSONArray();
        pages.put(new Page(++id, "Bất Động Sản", "http://batdongsan.com.vn/", ""));
        object.put(PREFIX, pages);
        FileUtils.write(object, RealEstate.HOME + PREFIX);
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

    public String getNote() {
        return getString(NOTE);
    }

    public void setNote(String note) {
        put(NOTE, note);
    }
}
