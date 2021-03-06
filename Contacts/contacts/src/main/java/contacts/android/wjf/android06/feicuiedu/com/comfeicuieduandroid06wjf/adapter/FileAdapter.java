package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.entity.FileInfo;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.BitmapUtil;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.CommonUtil;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.FileTypeUtil;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

public class FileAdapter extends BaseBaseAdapter<FileInfo> {

    private LayoutInflater layoutInflater;
    private LruCache<String, Bitmap> lruCache = null;

    public FileAdapter(Context context) {
        super(context);
//获取布局加载器
        layoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//检测sdk 版本，初始化LRUcache
        if (Build.VERSION.SDK_INT >= 12) {
            lruCache = new LruCache<String, Bitmap>(1 * 1024 * 1024) {
                @SuppressLint("NewApi")
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getByteCount();
                }
            };
        } else {
            lruCache = new LruCache<String, Bitmap>(100);
        }
    }

    @Override
    public View getItemView(final int position, View convertView, ViewGroup
            parent) {
// TODO Auto-generated method stub
        if (convertView == null) {
            convertView =
                    layoutInflater.inflate(R.layout.item_filemgl_list, null);
        }
        CheckBox cb_filedel = (CheckBox)
                convertView.findViewById(R.id.cb_filedel);
        ImageView iv_fileicon = (ImageView)
                convertView.findViewById(R.id.iv_fileicon);
        TextView tv_filename = (TextView)
                convertView.findViewById(R.id.tv_filename);
        TextView tv_filesize = (TextView)
                convertView.findViewById(R.id.tv_filesize);
        TextView tv_filetime = (TextView)
                convertView.findViewById(R.id.tv_filetime);
        // 监听CheckBox
        cb_filedel.setTag(position);
        cb_filedel.setOnCheckedChangeListener(changeListener);
        FileInfo fileInfo = getItem(position);
        String fileName = fileInfo.getFile().getName();
        String fileSize =
                CommonUtil.getFileSize(fileInfo.getFile().length());
        String fileTime =
                CommonUtil.getStrTime(fileInfo.getFile().lastModified());
        boolean isSelect = fileInfo.isSelect();
        Bitmap fileIcon = getFileIcon(fileInfo, iv_fileicon);
        if (fileIcon != null) {
            iv_fileicon.setImageBitmap(fileIcon);
        }
        tv_filename.setText(fileName);
        tv_filesize.setText(fileSize);
        tv_filetime.setText(fileTime);
        cb_filedel.setChecked(isSelect);
        return convertView;
    }

    private CompoundButton.OnCheckedChangeListener changeListener = new
            CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean
                        isChecked) {
                    int position = (Integer) buttonView.getTag();
                    getItem(position).setSelect(isChecked);
                }
            };

    private Bitmap getFileIcon(FileInfo fileInfo, ImageView iv_fileicon) {
        Bitmap bitmap = null;
        String fielPath = fileInfo.getFile().getPath();
// 从缓存中先取（根据文件名）,取到直接返回此图 (用图像路径做为key)
        bitmap = lruCache.get(fielPath);
        if (bitmap != null) {
            return bitmap;
        }
// 如果是图像，根据图像路径加载图像(待异步处理)
        if (fileInfo.getFileType().equals(FileTypeUtil.TYPE_IMAGE)) {
            bitmap = BitmapUtil.loadBitmap(fielPath, new
                    BitmapUtil.SizeMessage(context, true, 40, 40));
            if (bitmap != null) {
                lruCache.put(fielPath, bitmap); // 添加到缓存中(用图像路径做为key)
                return bitmap;
            }
        }
// 剩下的用Res 内的指定图像资源做为图标图像
        Resources res = context.getResources();
        int icon = res.getIdentifier(fileInfo.getIconName(), "drawable",
                context.getPackageName());
        if (icon <= 0)
            icon = R.drawable.icon_file;
        bitmap = BitmapFactory.decodeResource(context.getResources(),
                icon);
        return bitmap;
    }
}


