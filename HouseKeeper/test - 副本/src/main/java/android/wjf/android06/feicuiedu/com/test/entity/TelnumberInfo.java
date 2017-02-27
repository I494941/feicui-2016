package android.wjf.android06.feicuiedu.com.test.entity;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

/**
 * 获取主流电话号码
 */
public class TelnumberInfo {
    //名称
    public String name;
    //电话号码
    public String number;

    //重写构造方法
    public TelnumberInfo(String name, String number) {
        super();
        this.name = name;
        this.number = number;
    }
}
