package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.entity;

/**
 * Created by ad06-wjf on 2016/11/3.
 */

/**
 * 获取数据库classlist里的数据
 */
public class TelclassInfo {
    //电话名称
    public String name;
    //唯一ID
    public int idx;

    // 重写构造方法
    public TelclassInfo(String name, int idx) {
        super();
        this.name = name;
        this.idx = idx;
    }

    //系统默认构造方法
    public TelclassInfo() {
        super();
    }
}
