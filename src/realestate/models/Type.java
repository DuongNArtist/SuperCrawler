package realestate.models;

import org.json.JSONArray;
import org.json.JSONObject;
import realestate.RealEstate;
import utils.FileUtils;

/**
 * Created by duongnartist on 1/18/16.
 */
public class Type extends JSONObject {

    public static final String PREFIX = Type.class.getSimpleName().toLowerCase();
    public static final String ID = PREFIX + "Id";
    public static final String NAME = PREFIX + "Name";
    private static JSONArray types = new JSONArray();

    public Type() {

    }

    public Type(int id, String name) {
        setId(id);
        setName(name);
    }

    public static JSONArray getTypes() {
        return types;
    }

    public static void init() {
        JSONObject object = new JSONObject();
        int id = 0;
        types = new JSONArray();
        types.put(new Type(++id, "Cần bán"));
        types.put(new Type(++id, "Cần mua"));
        types.put(new Type(++id, "Cho thuê"));
        types.put(new Type(++id, "Cần thuê"));
        object.put(PREFIX, types);
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
}
