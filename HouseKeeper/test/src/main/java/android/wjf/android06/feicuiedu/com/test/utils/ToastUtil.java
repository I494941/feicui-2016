package android.wjf.android06.feicuiedu.com.test.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ad06-wjf on 2016/11/14.
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
