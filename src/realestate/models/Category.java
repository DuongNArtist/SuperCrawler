package realestate.models;

import org.json.JSONArray;
import org.json.JSONObject;
import realestate.RealEstate;
import utils.FileUtils;

/**
 * Created by duongnartist on 1/18/16.
 */
public class Category extends JSONObject {
    public static final String PREFIX = Category.class.getSimpleName().toLowerCase();
    public static final String ID = PREFIX + "Id";
    public static final String NAME = PREFIX + "Name";
    public static final String NOTE = PREFIX + "Note";
    private static JSONArray cates = new JSONArray();

    public Category() {

    }

    public Category(int id, String name, String note) {
        setId(id);
        setName(name);
        setNote(note);
    }

    public static JSONArray getCates() {
        return cates;
    }

    public static void init() {
        JSONObject object = new JSONObject();
        int id = 0;
        cates = new JSONArray();
        cates.put(new Category(++id, "Nhà mặt tiền", "note"));
        cates.put(new Category(++id, "Nhà trong hẻm", "note"));
        cates.put(new Category(++id, "Nhà liền kề, biệt thự", "note"));
        cates.put(new Category(++id, "Căn hộ chung cư", "note"));
        cates.put(new Category(++id, "Văn phòng", "note"));
        cates.put(new Category(++id, "Đất thổ cư", "note"));
        cates.put(new Category(++id, "Đất nền, liền kế, dự án", "note"));
        cates.put(new Category(++id, "Đất nông, lâm nghiệp", "note"));
        cates.put(new Category(++id, "Trang trại", "note"));
        cates.put(new Category(++id, "Mặt bằng", "note"));
        cates.put(new Category(++id, "Khu nghỉ dưỡng", "note"));
        cates.put(new Category(++id, "Phòng, nhà trọ", "note"));
        cates.put(new Category(++id, "Nhà hàng, khách sạn", "note"));
        cates.put(new Category(++id, "Shop, kiot, quán", "note"));
        cates.put(new Category(++id, "Kho, xưởng", "note"));
        cates.put(new Category(++id, "Các loại khác", "note"));
        object.put(PREFIX, cates);
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
