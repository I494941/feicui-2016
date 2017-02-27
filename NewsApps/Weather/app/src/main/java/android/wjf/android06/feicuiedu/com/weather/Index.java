package android.wjf.android06.feicuiedu.com.weather;

/**
 * Created by ad06-wjf on 2016/12/22.
 */

public class Index {

    private String des;
    private String tipt;
    private String title;
    private String zs;

    public Index(String des, String tipt, String title, String zs) {
        this.des = des;
        this.tipt = tipt;
        this.title = title;
        this.zs = zs;
    }

    public String getDes() {
        return des;
    }

    public String getTipt() {
        return tipt;
    }

    public String getTitle() {
        return title;
    }

    public String getZs() {
        return zs;
    }

    @Override
    public String toString() {
        return "Index [des=" + des + ",tipt=" + tipt + ", title=" + title + "," +
                " zs=" + zs + "]";
    }
}
