package realestate.models;

import org.json.JSONObject;
import realestate.RealEstate;
import utils.FileUtils;

import java.util.ArrayList;

/**
 * Created by duongnartist on 1/18/16.
 */
public class Property extends JSONObject {
    public static final String PREFIX = Property.class.getSimpleName().toLowerCase();
    public static final String ID = PREFIX + "Id";
    public static final String GROUP = PREFIX + "Group";
    public static final String URL = PREFIX + "Url";
    public static final String TITLE = PREFIX + "Title";
    public static final String SECTOR = PREFIX + "Sector";
    public static final String PRICE = PREFIX + "Price";
    public static final String SQUARE = PREFIX + "Square";
    public static final String ADDRESS = PREFIX + "Address";
    public static final String PROJECT = PREFIX + "Project";
    public static final String DESCRIPTION = PREFIX + "Description";
    public static final String POSTED = PREFIX + "Posted";
    public static final String EXPIRED = PREFIX + "Expired";
    public static final String NAME = PREFIX + "Name";
    public static final String MOBILE = PREFIX + "Mobile";
    public static final String PHONE = PREFIX + "Phone";
    public static final String EMAIL = PREFIX + "Email";
    private static ArrayList<Property> properties = new ArrayList<Property>();

    public Property() {

    }

    public Property(int id, int group, String url) {
        setId(id);
        setGroup(group);
        setUrl(url);
    }

    public static ArrayList<Property> getProperties() {
        return properties;
    }

    public static void init() {
        JSONObject object = new JSONObject();
        int id = 0;
        FileUtils.write(object, RealEstate.HOME + PREFIX);
    }

    public int getId() {
        return getInt(ID);
    }

    public void setId(int id) {
        put(ID, id);
    }

    public int getGroup() {
        return getInt(GROUP);
    }

    public void setGroup(int group) {
        put(GROUP, group);
    }

    public String getUrl() {
        return getString(URL);
    }

    public void setUrl(String url) {
        put(URL, url);
    }

    public String getTitle() {
        return getString(TITLE);
    }

    public void setTitle(String title) {
        put(TITLE, title);
    }

    public String getSector() {
        return getString(SECTOR);
    }

    public void setSector(String sector) {
        put(SECTOR, sector);
    }

    public String getPrice() {
        return getString(PRICE);
    }

    public void setPrice(String price) {
        put(PRICE, price);
    }

    public String getSquare() {
        return getString(SQUARE);
    }

    public void setSquare(String square) {
        put(SQUARE, square);
    }

    public String getAddress() {
        return getString(ADDRESS);
    }

    public void setAddress(String address) {
        put(ADDRESS, address);
    }

    public String getProject() {
        return getString(PROJECT);
    }

    public void setProject(String project) {
        put(PROJECT, project);
    }

    public String getDescription() {
        return getString(DESCRIPTION);
    }

    public void setDescription(String description) {
        put(DESCRIPTION, description);
    }

    public String getPosted() {
        return getString(POSTED);
    }

    public void setPosted(String posted) {
        put(POSTED, posted);
    }

    public String getExpired() {
        return getString(EXPIRED);
    }

    public void setExpired(String expired) {
        put(EXPIRED, expired);
    }

    public String getName() {
        return getString(NAME);
    }

    public void setName(String name) {
        put(NAME, name);
    }

    public String getMobile() {
        return getString(MOBILE);
    }

    public void setMobile(String mobile) {
        put(MOBILE, mobile);
    }

    public String getPhone() {
        return getString(PHONE);
    }

    public void setPhone(String phone) {
        put(PHONE, phone);
    }

    public String getEmail() {
        return getString(EMAIL);
    }

    public void setEmail(String email) {
        put(EMAIL, email);
    }
}
