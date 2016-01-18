package realestate;

import realestate.controllers.UrlParser;
import realestate.models.Category;
import realestate.models.Group;
import realestate.models.Page;
import realestate.models.Type;

import java.io.File;

/**
 * Created by duongnartist on 1/18/16.
 */
public class RealEstate {

    public static final String HOME = "res" + File.separator + "realestate" + File.separator;

    public static void main(String[] args) {
        Page.init();
        Type.init();
        Category.init();
        Group.init();
        for (Group group : Group.getGroups()) {
            UrlParser.initMainUrls(group);
        }
    }
}
