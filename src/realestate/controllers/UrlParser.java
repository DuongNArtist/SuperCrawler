package realestate.controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import realestate.RealEstate;
import realestate.models.Group;
import realestate.models.Property;
import utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by duongnartist on 1/18/16.
 */
public class UrlParser {
    private static ArrayList<MainUrl> mainUrls = new ArrayList<MainUrl>();

    public static ArrayList<MainUrl> getMainUrls() {
        return mainUrls;
    }

    public static void initMainUrls(Group group) {
        mainUrls.clear();
        mainUrls.add(new MainUrl(group.getId(), group.getUrl(), group.getTag()));
        for (int i = group.getStart(); i <= group.getEnd(); i += group.getStep()) {
            String mainUrl = String.format(group.getFormat(), i);
            mainUrls.add(new MainUrl(group.getId(), mainUrl, group.getTag()));
        }
        System.out.println("Sub = " + group.getId());
        for (MainUrl mainUrl : mainUrls) {
            System.out.println(mainUrl.getUrl());
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
                    // start write to file
                    String path = RealEstate.HOME + mainUrl.getGroup() + "/";
                    File file = new File(path);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    FileUtils.write(property, path + subUrl.substring(subUrl.length() - 7));
                    // end write to file
                    Property.getProperties().add(property);
                    System.out.println(subUrl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
