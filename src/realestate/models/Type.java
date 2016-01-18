package realestate.models;

import org.json.JSONArray;
import org.json.JSONObject;
import realestate.RealEstate;
import utils.FileUtils;

import java.util.ArrayList;

/**
 * Created by duongnartist on 1/18/16.
 */
public class Type extends JSONObject {

    public static final String PREFIX = Type.class.getSimpleName().toLowerCase();
    public static final String ID = PREFIX + "Id";
    public static final String NAME = PREFIX + "Name";
    private static ArrayList<Type> types = new ArrayList<Type>();

    public Type() {

    }

    public Type(int id, String name) {
        setId(id);
        setName(name);
    }

    public static ArrayList<Type> getTypes() {
        return types;
    }

    public static void init() {
        JSONObject object = new JSONObject();
        JSONArray objects = new JSONArray();
        int id = 0;
        types.clear();
        Type type = new Type(++id, "cần bán");
        types.add(type);
        objects.put(type);
        type = new Type(++id, "cần mua");
        types.add(type);
        objects.put(type);
        type = new Type(++id, "cho thuê");
        types.add(type);
        objects.put(type);
        type = new Type(++id, "cần thuê");
        types.add(type);
        objects.put(type);
        object.put(PREFIX, objects);
        FileUtils.write(object, RealEstate.HOME + PREFIX);
        for (Type t : types) {
            System.out.println("Đã khởi tạo loại tin: " + t.getName());
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
}
