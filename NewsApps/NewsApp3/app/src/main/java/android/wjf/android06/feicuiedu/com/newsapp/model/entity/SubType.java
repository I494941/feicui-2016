package android.wjf.android06.feicuiedu.com.newsapp.model.entity;

/**
 * Created by ad06-wjf on 2016/11/29.
 */

public class SubType {

    private int subid;
    private String subgroup;

    public SubType(int subid, String subgroup) {
        this.subid = subid;
        this.subgroup = subgroup;
    }

    public int getSubid() {
        return subid;
    }

    public String getSubgroup() {
        return subgroup;
    }
}
