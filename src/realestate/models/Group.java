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
    private static int id = 0;
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
        groups.clear();
        initBatDongSanCanBan(objects);
        initBatDongSanCanMua(objects);
        initBatDongSanCanThue(objects);
        initBatDongSanChoThue(objects);
        object.put(PREFIX, objects);
        FileUtils.write(object, RealEstate.HOME + PREFIX);
        for (Group g : groups) {
            System.out.println("Đã khởi tạo nhóm tin: " + g.getUrl());
        }
    }

    private static void initBatDongSanCanBan(JSONArray objects) {
        //---------------- CẦN BÁN ----------------//
        Group group = null;
        //-------- NHÀ MẶT PHỐ --------//
        group = new Group(++id, 1, 1, 1, "http://batdongsan.com.vn/ban-nha-mat-pho", "http://batdongsan.com.vn/ban-nha-mat-pho/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- NHÀ RIÊNG --------//
        group = new Group(++id, 1, 1, 2, "http://batdongsan.com.vn/ban-nha-rieng", "http://batdongsan.com.vn/ban-nha-rieng/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- NHÀ BIỆT THỰ, NHÀ LIỀN KỀ --------//
        group = new Group(++id, 1, 1, 3, "http://batdongsan.com.vn/ban-nha-biet-thu-lien-ke", "http://batdongsan.com.vn/ban-nha-biet-thu-lien-ke/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- CĂN HỘ CHUNG CƯ --------//
        group = new Group(++id, 1, 1, 4, "http://batdongsan.com.vn/ban-can-ho-chung-cu", "http://batdongsan.com.vn/ban-can-ho-chung-cu/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- ĐẤT --------//
        group = new Group(++id, 1, 1, 6, "http://batdongsan.com.vn/ban-dat", "http://batdongsan.com.vn/ban-dat/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- ĐẤT LIỀN KỀ, DỰ ÁN--------//
        group = new Group(++id, 1, 1, 7, "http://batdongsan.com.vn/ban-dat-nen-du-an", "http://batdongsan.com.vn/ban-dat-nen-du-an/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- TRANG TRẠI --------//
        group = new Group(++id, 1, 1, 9, "http://batdongsan.com.vn/ban-trang-trai-khu-nghi-duong", "http://batdongsan.com.vn/ban-trang-trai-khu-nghi-duong/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- KHO NHÀ XƯỞNG --------//
        group = new Group(++id, 1, 1, 15, "http://batdongsan.com.vn/ban-kho-nha-xuong", "http://batdongsan.com.vn/ban-kho-nha-xuong/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- CÁC LOẠI BĐS KHÁC --------//
        group = new Group(++id, 1, 1, 16, "http://batdongsan.com.vn/ban-loai-bat-dong-san-khac", "http://batdongsan.com.vn/ban-loai-bat-dong-san-khac/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //---------------- THE END ----------------//
    }

    private static void initBatDongSanCanMua(JSONArray objects) {
        //---------------- CẦN MUA ----------------//
        Group group = null;
        //-------- NHÀ MẶT PHỐ --------//
        group = new Group(++id, 1, 2, 1, "http://batdongsan.com.vn/mua-nha-mat-pho", "http://batdongsan.com.vn/mua-nha-mat-pho/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- NHÀ RIÊNG --------//
        group = new Group(++id, 1, 2, 2, "http://batdongsan.com.vn/mua-nha-rieng", "http://batdongsan.com.vn/mua-nha-rieng/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- NHÀ BIỆT THỰ, NHÀ LIỀN KỀ --------//
        group = new Group(++id, 1, 2, 3, "http://batdongsan.com.vn/mua-nha-biet-thu-lien-ke", "http://batdongsan.com.vn/mua-nha-biet-thu-lien-ke/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- CĂN HỘ CHUNG CƯ --------//
        group = new Group(++id, 1, 2, 4, "http://batdongsan.com.vn/mua-can-ho-chung-cu", "http://batdongsan.com.vn/mua-can-ho-chung-cu/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- ĐẤT --------//
        group = new Group(++id, 1, 2, 6, "http://batdongsan.com.vn/mua-dat", "http://batdongsan.com.vn/mua-dat/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- ĐẤT LIỀN KỀ, DỰ ÁN--------//
        group = new Group(++id, 1, 2, 7, "http://batdongsan.com.vn/mua-dat-nen-du-an", "http://batdongsan.com.vn/mua-dat-nen-du-an/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- TRANG TRẠI --------//
        group = new Group(++id, 1, 2, 9, "http://batdongsan.com.vn/mua-trang-trai-khu-nghi-duong", "http://batdongsan.com.vn/mua-trang-trai-khu-nghi-duong/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- KHO NHÀ XƯỞNG --------//
        group = new Group(++id, 1, 2, 15, "http://batdongsan.com.vn/mua-kho-nha-xuong", "http://batdongsan.com.vn/mua-kho-nha-xuong/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- CÁC LOẠI BĐS KHÁC --------//
        group = new Group(++id, 1, 2, 16, "http://batdongsan.com.vn/mua-loai-bat-dong-san-khac", "http://batdongsan.com.vn/mua-loai-bat-dong-san-khac/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //---------------- THE END ----------------//
    }

    private static void initBatDongSanChoThue(JSONArray objects) {
        //---------------- CHO THUÊ ----------------//
        Group group = null;
        //-------- NHÀ MẶT PHỐ --------//
        group = new Group(++id, 1, 3, 1, "http://batdongsan.com.vn/cho-thue-nha-mat-pho", "http://batdongsan.com.vn/cho-thue-nha-mat-pho/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- NHÀ RIÊNG --------//
        group = new Group(++id, 1, 3, 2, "http://batdongsan.com.vn/cho-thue-nha-rieng", "http://batdongsan.com.vn/cho-thue-nha-rieng/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- NHÀ BIỆT THỰ, NHÀ LIỀN KỀ --------//
        group = new Group(++id, 1, 3, 3, "http://batdongsan.com.vn/cho-thue-nha-biet-thu-lien-ke", "http://batdongsan.com.vn/cho-thue-nha-biet-thu-lien-ke/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- CĂN HỘ CHUNG CƯ --------//
        group = new Group(++id, 1, 3, 4, "http://batdongsan.com.vn/cho-thue-can-ho-chung-cu", "http://batdongsan.com.vn/cho-thue-can-ho-chung-cu/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- ĐẤT --------//
        group = new Group(++id, 1, 3, 6, "http://batdongsan.com.vn/cho-thue-dat", "http://batdongsan.com.vn/cho-thue-dat/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- ĐẤT LIỀN KỀ, DỰ ÁN--------//
        group = new Group(++id, 1, 3, 7, "http://batdongsan.com.vn/cho-thue-dat-nen-du-an", "http://batdongsan.com.vn/cho-thue-dat-nen-du-an/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- TRANG TRẠI --------//
        group = new Group(++id, 1, 3, 9, "http://batdongsan.com.vn/cho-thue-trang-trai-khu-nghi-duong", "http://batdongsan.com.vn/cho-thue-trang-trai-khu-nghi-duong/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- KHO NHÀ XƯỞNG --------//
        group = new Group(++id, 1, 3, 15, "http://batdongsan.com.vn/cho-thue-kho-nha-xuong", "http://batdongsan.com.vn/cho-thue-kho-nha-xuong/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- CÁC LOẠI BĐS KHÁC --------//
        group = new Group(++id, 1, 3, 16, "http://batdongsan.com.vn/cho-thue-loai-bat-dong-san-khac", "http://batdongsan.com.vn/cho-thue-loai-bat-dong-san-khac/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //---------------- THE END ----------------//
    }

    private static void initBatDongSanCanThue(JSONArray objects) {
        //---------------- CHO THUÊ ----------------//
        Group group = null;
        //-------- NHÀ MẶT PHỐ --------//
        group = new Group(++id, 1, 4, 1, "http://batdongsan.com.vn/can-thue-nha-mat-pho", "http://batdongsan.com.vn/can-thue-nha-mat-pho/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- NHÀ RIÊNG --------//
        group = new Group(++id, 1, 4, 2, "http://batdongsan.com.vn/can-thue-nha-rieng", "http://batdongsan.com.vn/can-thue-nha-rieng/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- NHÀ BIỆT THỰ, NHÀ LIỀN KỀ --------//
        group = new Group(++id, 1, 4, 3, "http://batdongsan.com.vn/can-thue-nha-biet-thu-lien-ke", "http://batdongsan.com.vn/can-thue-nha-biet-thu-lien-ke/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- CĂN HỘ CHUNG CƯ --------//
        group = new Group(++id, 1, 4, 4, "http://batdongsan.com.vn/can-thue-can-ho-chung-cu", "http://batdongsan.com.vn/can-thue-can-ho-chung-cu/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- ĐẤT --------//
        group = new Group(++id, 1, 4, 6, "http://batdongsan.com.vn/can-thue-dat", "http://batdongsan.com.vn/can-thue-dat/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- ĐẤT LIỀN KỀ, DỰ ÁN--------//
        group = new Group(++id, 1, 4, 7, "http://batdongsan.com.vn/can-thue-dat-nen-du-an", "http://batdongsan.com.vn/can-thue-dat-nen-du-an/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- TRANG TRẠI --------//
        group = new Group(++id, 1, 4, 9, "http://batdongsan.com.vn/can-thue-trang-trai-khu-nghi-duong", "http://batdongsan.com.vn/can-thue-trang-trai-khu-nghi-duong/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- KHO NHÀ XƯỞNG --------//
        group = new Group(++id, 1, 4, 15, "http://batdongsan.com.vn/can-thue-kho-nha-xuong", "http://batdongsan.com.vn/can-thue-kho-nha-xuong/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //-------- CÁC LOẠI BĐS KHÁC --------//
        group = new Group(++id, 1, 4, 16, "http://batdongsan.com.vn/can-thue-loai-bat-dong-san-khac", "http://batdongsan.com.vn/can-thue-loai-bat-dong-san-khac/p%s", 2, 50, 1, "div.p-title");
        groups.add(group);
        objects.put(group);
        //---------------- THE END ----------------//
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
