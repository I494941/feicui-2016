package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils;

/**
 * Created by ad06-wjf on 2016/11/3.
 */

import android.content.Context;
import android.widget.Toast;

/**
 * Toast管理工具类,有且只有一个Toast对象进行展示操作 *
 */
public class ToastUtil {
    private static Toast toast;

    public static void show(Context context, String text, int duration) {
        if (toast == null) {
            toast = Toast.makeText(context, text, duration);
        }
        toast.setText(text);
        toast.setDuration(duration);
        toast.show();
    }
}
