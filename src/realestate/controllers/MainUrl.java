package realestate.controllers;

/**
 * Created by duongnartist on 1/18/16.
 */
public class MainUrl {
    private int group;
    private String url;
    private String tag;
    private String folder;

    public MainUrl(int group, String url, String tag, String folder) {
        setGroup(group);
        setUrl(url);
        setTag(tag);
        setFolder(folder);
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
