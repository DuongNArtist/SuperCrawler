package realestate.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import realestate.RealEstate;
import realestate.models.*;
import utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by duongnartist on 1/18/16.
 */
public class UrlParser {

    private static int parsed = 0;
    private static ArrayList<MainUrl> mainUrls = new ArrayList<MainUrl>();

    public static ArrayList<MainUrl> getMainUrls() {
        return mainUrls;
    }

    public static void initMainUrls(Group group) {
        String folder = getMainFolder(group);
        mainUrls.clear();
        mainUrls.add(new MainUrl(group.getId(), group.getUrl(), group.getTag(), folder));
        for (int i = group.getStart(); i <= group.getEnd(); i += group.getStep()) {
            String mainUrl = String.format(group.getFormat(), i);
            mainUrls.add(new MainUrl(group.getId(), mainUrl, group.getTag(), folder));
        }
        System.out.println("Đã lấy được " + String.format("%1$" + 8 + "s", mainUrls.size()) + " đường dẫn trang chính lưu tại thư mục: " + folder);
        //System.out.println("Sub = " + group.getId());
        /*
        for (MainUrl mainUrl : mainUrls) {
            //System.out.println(mainUrl.getUrl());
            getSubUrls(mainUrl);
        }
        */
        for (int i = mainUrls.size() - 1; i > 0; i--) {
            MainUrl mainUrl = mainUrls.get(i);
            getSubUrls(mainUrl);
        }
    }

    public static void getSubUrls(MainUrl mainUrl) {
        try {
            Document document = Jsoup.connect(mainUrl.getUrl()).get();
            Element body = document.body();
            Elements elements = body.select(mainUrl.getTag());
            for (Element link : elements) {
                Elements tags = link.getElementsByTag("a");
                for (Element aTag : tags) {
                    String subUrl = mainUrl.getUrl() + aTag.attr("href");
                    Property property = new Property(0, mainUrl.getGroup(), subUrl);
                    if (subUrl.contains("batdongsan")) {
                        parseFromBatDongSan(property);
                    }
                    String path = getSubFolder(mainUrl, property) + subUrl.substring(subUrl.length() - 7);
                    FileUtils.write(property, path);
                    Property.getProperties().add(property);
                    System.out.println("Đã lấy được " + String.format("%1$" + 8 + "s", ++parsed) + " tin bất động sản, đã lưu bằng tệp tin: " + path + ".json");
                    //System.out.println(subUrl);
                    //System.out.println(property.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSubFolder(MainUrl mainUrl, Property property) {
        String[] dates = property.getPosted().split("-");
        //System.out.println(property.getPosted());
        String folder = mainUrl.getFolder();
        for (int i = dates.length - 1; i >= 0; i--) {
            String prefix = "";
            if (i == 2) {
                prefix = "năm ";
            } else if (i == 1) {
                prefix = "tháng ";
            } else if (i == 0) {
                prefix = "ngày ";
            }
            folder += (prefix + dates[i] + File.separator);
            File file = new File(folder);
            if (!file.exists()) {
                file.mkdir();
                System.out.println("Đã tạo thư mục: " + folder);
            }
        }
        return folder;
    }

    public static String getMainFolder(Group group) {
        int pageId = group.getPage();
        int typeId = group.getType();
        int categoryId = group.getCategory();
        String pageName = "";
        String typeName = "";
        String categoryName = "";
        for (Page page : Page.getPages()) {
            if (page.getId() == pageId) {
                pageName = page.getName();
            }
        }
        for (Type type : Type.getTypes()) {
            if (type.getId() == typeId) {
                typeName = type.getName();
            }
        }
        for (Category category : Category.getCategories()) {
            if (category.getId() == categoryId) {
                categoryName = category.getName();
            }
        }
        String folder = RealEstate.HOME + pageName + File.separator;
        File file = new File(folder);
        if (!file.exists()) {
            file.mkdir();
            System.out.println("Đã tạo thư mục: " + folder);
        }
        folder += typeName + File.separator;
        file = new File(folder);
        if (!file.exists()) {
            file.mkdir();
            System.out.println("Đã tạo thư mục: " + folder);
        }
        folder += categoryName + File.separator;
        file = new File(folder);
        if (!file.exists()) {
            file.mkdir();
            System.out.println("Đã tạo thư mục: " + folder);
        }
        return folder;
    }

    public static void parseFromBatDongSan(Property property) {
        try {
            Document document = Jsoup.connect(property.getUrl()).get();
            // title
            String title = document.title().trim();
            property.setTitle(title);
            // body
            Element body = document.body();
            // sector
            Element sectorTitle = body.select("div.diadiem-title").first();
            if (sectorTitle != null) {
                sectorTitle.getElementsByTag("a").remove();
                sectorTitle.getElementsByTag("b").remove();
                String sector = sectorTitle.text().trim();
                property.setTitle(sector);
            }
            // price
            Element priceTitle = body.select("span.gia-title").first();
            if (priceTitle != null) {
                priceTitle.getElementsByTag("b").remove();
                String price = priceTitle.text().trim();
                property.setPrice(price);
            }
            // square
            Element squareTitle = body.select("span.gia-title").last();
            if (squareTitle != null) {
                squareTitle.getElementsByTag("b").remove();
                String square = squareTitle.text().trim();
                property.setSquare(square);
            }
            // description
            Element content = body.select("div.pm-content.stat").first();
            if (content != null) {
                Element tag = content.getElementById("LeftMainContent__productDetail_panelTag");
                if (tag != null) {
                    tag.remove();
                }
                String description = content.text().trim();
                property.setDescription(description);
            }
            Element contentDetail = body.select("div.pm-content-detail").first();
            if (contentDetail != null) {
                Element leftDetail = contentDetail.select("div.left-detail").first();
                if (leftDetail != null) {
                    Elements lefts = leftDetail.select("div.left");
                    Elements rights = leftDetail.select("div.right");
                    int size = lefts.size() < rights.size() ? lefts.size() : rights.size();
                    for (int i = 0; i < size; i++) {
                        String key = lefts.get(i).text().toLowerCase();
                        String value = rights.get(i).text().trim();
                        if (key.contains("dự án")) {
                            property.setProject(value);
                        } else if (key.contains("địa chỉ")) {
                            property.setAddress(value);
                        } else if (key.contains("đăng tin")) {
                            property.setPosted(value);
                        } else if (key.contains("hết hạn")) {
                            property.setExpired(value);
                        }
                    }
                }
                Element divCustomerInfo = contentDetail.getElementById("divCustomerInfo");
                if (divCustomerInfo != null) {
                    // name
                    Element contactName = divCustomerInfo.getElementById("LeftMainContent__productDetail_contactName");
                    if (contactName != null) {
                        String name = contactName.select("div.right").first().text().trim();
                        property.setName(name);
                    }
                    // phone
                    Element contactPhone = divCustomerInfo.getElementById("LeftMainContent__productDetail_contactPhone");
                    if (contactPhone != null) {
                        String phone = contactPhone.select("div.right").first().text().trim();
                        property.setPhone(phone);
                    }
                    // mobile
                    Element contactMobile = divCustomerInfo.getElementById("LeftMainContent__productDetail_contactMobile");
                    if (contactMobile != null) {
                        String mobile = contactMobile.select("div.right").first().text().trim();
                        property.setMobile(mobile);
                    }
                    // email
                    Element contactEmail = divCustomerInfo.getElementById("LeftMainContent__productDetail_contactEmail");
                    if (contactEmail != null) {
                        String email = contactEmail.select("div.right").first().select("script").outerHtml();
                        email = email.substring(email.indexOf("href='mailto:") + 13, email.indexOf("'>"));
                        email = Jsoup.parse(email).text().trim();
                        property.setEmail(email);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
