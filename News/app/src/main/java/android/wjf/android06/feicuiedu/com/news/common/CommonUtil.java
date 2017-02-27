package android.wjf.android06.feicuiedu.com.news.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ad06-wjf on 2016/11/28.
 */

public class CommonUtil {
    /**
     * 联网的ip
     */
    public static String NETIP = "118.244.212.82";
    /**
     * 联网的路径
     */
    public static String NETPATH = "http://" + NETIP + ":9092/newsClient";
    /**
     * SharedPreferences保存用户名键
     */
    public static final String SHARE_USER_NAME = "userName";
    /**
     * SharedPreferences保存用户名密码
     */
    public static final String SHARE_USER_PWD = "userPwd";
    /**
     * SharedPreferences保存是否第一次登陆
     */
    public static final String SHARE_IS_FIRST_RUN = "isFirstRun";
    /**
     * SharedPreferences存储路径
     */
    public static final String SHAREPATH = "news_share";

    public static final String APPURL = "http://118.244.212.82:9092/newsClient"; //联网的路径
    public static final int VERSION_CODE = 1;//当前版本号

    /**
     * 获取当前时间 * @return 2014-07-16 08：10：10 20140716081010
     */
    public static String getSystime() {
        String systime; //对应的时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");
        //获取当前时间并刷格式
        systime = dateFormat.format(new Date(System.currentTimeMillis()));
        return systime;
    }

    /**
     * 获取当前日期 * @return 20140716
     */
    public static String getDate() {
        Date date = new Date(System.currentTimeMillis());
        String strs = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            strs = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strs;
    }

    public static String getSystime2() {
        String systime;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        systime = dateFormat.format(new Date(System.currentTimeMillis()));
        return systime;
    }

    /**
     * 验证邮箱格式 * @param email email * @return 格式是否正确
     */
    public static boolean verifyEmail(String email) {
        Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)" + "|(([a-zA-Z0-9\\-]+\\.)+))" + "([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /***
     * 验证密码格式 * @param password * @return
     */
    public static boolean verifyPassword(String password) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,16}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
