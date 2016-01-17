package realestate.models;

import org.json.JSONArray;
import org.json.JSONObject;
import realestate.RealEstate;
import utils.FileUtils;

import java.util.ArrayList;

/**
 * Created by duongnartist on 1/18/16.
 */
public class Group extends JSONObject {
    public static final String PREFIX = Group.class.getSimpleName().toLowerCase();
    public static final String ID = PREFIX + "Id";
    public static final String PAGE = Page.ID;
    public static final String TYPE = Type.ID;
    public static final String CATEGORY = Category.ID;
    public static final String URL = PREFIX + "Url";
    public static final String FORMAT = PREFIX + "Format";
    public static final String START = PREFIX + "Start";
    public static final String END = PREFIX + "End";
    public static final String STEP = PREFIX + "Step";
    public static final String TAG = PREFIX + "Tag";
    private static ArrayList<Group> groups = new ArrayList<Group>();

    public Group() {

    }

    public Group(int id, int page, int type, int category, String url, String format, int start, int end, int step, String tag) {
        setId(id);
        setPage(page);
        setType(type);
        setCategory(category);
        setUrl(url);
        setFormat(format);
        setStart(start);
        setEnd(end);
        setStep(step);
        setTag(tag);
    }

    public static ArrayList<Group> getGroups() {
        return groups;
    }

    public static void init() {
        JSONObject object = new JSONObject();
        JSONArray objects = new JSONArray();
        int id = 0;
        groups.clear();
        Group group = new Group(++id, 1, 1, 1, "http://batdongsan.com.vn/ban-nha-mat-pho", "http://batdongsan.com.vn/ban-nha-mat-pho/p%s", 2, 525, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        object.put(PREFIX, objects);
        FileUtils.write(object, RealEstate.HOME + PREFIX);
    }

    public int getId() {
        return getInt(ID);
    }

    public void setId(int id) {
        put(ID, id);
    }

    public int getPage() {
        return getInt(PAGE);
    }

    public void setPage(int page) {
        put(PAGE, page);
    }

    public int getType() {
        return getInt(TYPE);
    }

    public void setType(int type) {
        put(TYPE, type);
    }

    public int getCategory() {
        return getInt(CATEGORY);
    }

    public void setCategory(int category) {
        put(CATEGORY, category);
    }

    public String getUrl() {
        return getString(URL);
    }

    public void setUrl(String url) {
        put(URL, url);
    }

    public String getFormat() {
        return getString(FORMAT);
    }

    public void setFormat(String format) {
        put(FORMAT, format);
    }

    public int getStart() {
        return getInt(START);
    }

    public void setStart(int start) {
        put(START, start);
    }

    public int getEnd() {
        return getInt(END);
    }

    public void setEnd(int end) {
        put(END, end);
    }

    public int getStep() {
        return getInt(STEP);
    }

    public void setStep(int step) {
        put(STEP, step);
    }

    public String getTag() {
        return getString(TAG);
    }

    public void setTag(String tag) {
        put(TAG, tag);
    }
}
