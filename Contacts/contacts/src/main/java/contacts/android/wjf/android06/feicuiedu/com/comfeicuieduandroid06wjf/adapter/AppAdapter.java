package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.adapter;


import android.annotation.SuppressLint;
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

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.entity.AppInfo;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.BitmapCache;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.BitmapUtil;

/**
 * Created by ad06-wjf on 2016/11/8.
 */

public class AppAdapter extends BaseBaseAdapter<AppInfo> {

    private Context context;
    private LayoutInflater layoutInflater;
    private BitmapCache bitmapCache;//软引用
    private boolean isFling; // 是否在快速滑动(此时就该显示默认图像，而不去做图像加载等操作)
    private Bitmap defIconBitmap;// 默认图片，在快速滑动时显示默认图片

    @SuppressLint("NewApi")
    public AppAdapter(Context context) {
        super(context);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        bitmapCache = BitmapCache.getInstance();

        BitmapUtil.SizeMessage sizeMessage = new BitmapUtil.SizeMessage(context, false, 60, 60);
        defIconBitmap = BitmapUtil.loadBitmap(R.drawable.ic_launcher,
                sizeMessage);
        /*略*/
        mBitmap();

    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup
            parent) {
        // 将dataList 里的所有数据对应适配到layout_software_listitem.xml 布局文件上
        ImageView iv_icon;
        TextView tv_title;
        TextView tv_text;
        TextView tv_version;
        CheckBox cb_del;
        convertView =
                layoutInflater.inflate(R.layout.layout_showapp_listitem, null);
        iv_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
        tv_title = (TextView) convertView.findViewById(R.id.tv_app_lable);
        tv_text = (TextView)
                convertView.findViewById(R.id.tv_app_packagename);
        tv_version = (TextView)
                convertView.findViewById(R.id.tv_app_version);
        cb_del = (CheckBox) convertView.findViewById(R.id.cb_del);
        cb_del.setOnCheckedChangeListener(checkedChangeListener);
        cb_del.setTag(position);
        AppInfo appInfo = (AppInfo) getItem(position);

        String title = appInfo.getPackageInfo().applicationInfo.loadLabel(context.getPackageManager()).toString();
        //包名
        String text = appInfo.getPackageInfo().packageName;
        //版本
        String version = appInfo.getPackageInfo().versionName;
        boolean isDel = appInfo.isDel();
        Bitmap bitmap =
                ((BitmapDrawable) appInfo.getPackageInfo().applicationInfo.loadIcon(context.getPackageManager())).getBitmap();
        bitmapCache.addCacheBitmap(bitmap, position);
        iv_icon.setImageBitmap(bitmapCache.getBitmap(position, context));
        tv_title.setText(title);
        tv_text.setText(text);
        tv_version.setText(version);
        cb_del.setChecked(isDel);
        return convertView;
    }


    private CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int position = (Integer) buttonView.getTag();
            getDataList().get(position).setDel(isChecked);
        }
    };

    public boolean isFling() {
        return isFling;
    }

    public void setFling(boolean isFling) {
        this.isFling = isFling;
    }

    public Bitmap mBitmap() {
        if (isFling) {
            return defIconBitmap;
        }
        return defIconBitmap;
    }

}
