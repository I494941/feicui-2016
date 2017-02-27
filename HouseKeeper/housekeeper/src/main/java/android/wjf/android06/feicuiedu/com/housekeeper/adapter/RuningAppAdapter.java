package android.wjf.android06.feicuiedu.com.housekeeper.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.housekeeper.R;
import android.wjf.android06.feicuiedu.com.housekeeper.entity.RuningAppInfo;
import android.wjf.android06.feicuiedu.com.housekeeper.utils.BitmapCache;
import android.wjf.android06.feicuiedu.com.housekeeper.utils.BitmapUtil;
import android.wjf.android06.feicuiedu.com.housekeeper.utils.CommonUtil;

/**
 * Created by ad06-wjf on 2016/11/16.
 */

public class RuningAppAdapter extends BaseBaseAdapter<RuningAppInfo> {

    private LayoutInflater layoutInflater;
    private int state = 0; //显示用户进程
    public static final int STATE_SHOW_USER = 0;//显示用户进程
    public static final int STATE_SHOW_ALL = 1;//显示全部进程
    public static final int STATE_SHOW_SYS = 2;//显示系统进程
    private boolean isFling; // 是否在快速滑动(此时就该显示默认图像，而不去做图像加载等操作)

    public RuningAppAdapter(Context context) {
        super(context);
//图片大小信息
        BitmapUtil.SizeMessage sizeMessage = new BitmapUtil.SizeMessage(context, false, 60, 60);
//加载默认图片
        defIconBitmap = BitmapUtil.loadBitmap(R.drawable.ic_launcher,sizeMessage);
        bitmapCache = BitmapCache.getInstance();

    }

    public boolean isFling() {
        return isFling;
    }

    public void setFling(boolean isFling) {
        this.isFling = isFling;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHold holdView = null;
        if (convertView == null) {
            convertView =
                    layoutInflater.inflate(R.layout.layout_speedup_listitem, null);
            holdView = new ViewHold(convertView);
            convertView.setTag(holdView);
        } else {
            holdView = (ViewHold) convertView.getTag();
        }

        holdView.cb_clear.setTag(position);
        Bitmap icon = getIconBitmap(position);
        holdView.iv_icon.setImageBitmap(icon);
        holdView.tv_lable.setText(getItem(position).getLableName());
        holdView.tv_size.setText("内存：" +
                CommonUtil.getFileSize(getItem(position).getSize()));
        holdView.cb_clear.setChecked(getItem(position).isClear());
        holdView.tv_message.setText(getItem(position).isSystem() ? "系统进程" : "");
        return convertView;
    }


    private CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int position = (Integer) buttonView.getTag();
            getItem(position).setClear(isChecked); // 更新当前CheckBox是否选中的实体数据
        }
    };

    class ViewHold {
        public TextView tv_lable, tv_size, tv_message;
        public ImageView iv_icon;
        public CheckBox cb_clear;

        public ViewHold(View view) {
            iv_icon = (ImageView) view.findViewById(R.id.iv_app_icon);
            tv_lable = (TextView) view.findViewById(R.id.tv_app_lable);
            tv_size = (TextView)
                    view.findViewById(R.id.tv_app_packagename);
            tv_message = (TextView)
                    view.findViewById(R.id.tv_app_version);
            cb_clear = (CheckBox) view.findViewById(R.id.cb_clear);
            cb_clear.setOnCheckedChangeListener(checkedChangeListener);
// 监听CheckBox
        }
    }

    public Bitmap getIconBitmap(int position) {
        if (isFling) {
            return defIconBitmap;
        }
        Bitmap bitmap = ((BitmapDrawable) getItem(position).getIcon()).getBitmap();
        bitmapCache.addCacheBitmap(bitmap, position);
        bitmap = bitmapCache.getBitmap(position, context);
        return bitmap;
    }


}
