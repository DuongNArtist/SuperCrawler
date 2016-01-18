package realestate.models;

import org.json.JSONArray;
import org.json.JSONObject;
import realestate.RealEstate;
import utils.FileUtils;

import java.util.ArrayList;

/**
 * Created by duongnartist on 1/18/16.
 */
public class Category extends JSONObject {
    public static final String PREFIX = Category.class.getSimpleName().toLowerCase();
    public static final String ID = PREFIX + "Id";
    public static final String NAME = PREFIX + "Name";
    public static final String NOTE = PREFIX + "Note";
    private static ArrayList<Category> categories = new ArrayList<Category>();

    public Category() {

    }

    public Category(int id, String name, String note) {
        setId(id);
        setName(name);
        setNote(note);
    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }

    public static void init() {
        JSONObject object = new JSONObject();
        JSONArray objects = new JSONArray();
        int id = 0;
        categories.clear();
        Category category = new Category(++id, "nhà mặt tiền", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "nhà trong hẻm", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "nhà liền kề - Biệt thự", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "căn hộ chung cư", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "văn phòng", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "đất thổ cư", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "đất nền - đất liền kế - đất dự án", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "đất nông - đất lâm nghiệp", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "trang trại", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "mặt bằng", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "khu nghỉ dưỡng", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "phòng trọ - nhà trọ", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "nhà hàng - khách sạn", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "shop - kiot - quán", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "kho - xưởng", "note");
        categories.add(category);
        objects.put(category);
        category = new Category(++id, "các loại khác", "note");
        categories.add(category);
        objects.put(category);
        object.put(PREFIX, objects);
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

    public String getNote() {
        return getString(NOTE);
    }

    public void setNote(String note) {
        put(NOTE, note);
    }
}
