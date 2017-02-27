package android.wjf.android06.feicuiedu.com.xutilsuploaddemo;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ad06-wjf on 2016/12/16.
 */
@ContentView(R.layout.activity_fileupload)
public class FileSelectActivity extends ListActivity {

    private static final String root = new String(Environment
            .getExternalStorageDirectory().getAbsolutePath() + File.separator);
    @ViewInject(R.id.currPath)
    private TextView tv;// 显示文件的目录
    private File[] files;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        Log.d("root", root);
        getFiles(root);
    }

    public void getFiles(String path) {
        tv.setText(path);
        File f = new File(path);
        /*Log.d("root1", f.getAbsolutePath());
        Log.d("root2", f.getName());
		Log.d("root3", f.isDirectory()+"");*/
        // 得到所有子文件和文件夹
        File[] tem = f.listFiles();
        // 如当果前的目录不是在顶层目录，就把父目录要到files数组中的第一个
        if (!path.equals(root)) {
            files = new File[tem.length + 1];
            System.arraycopy(tem, 0, files, 1, tem.length);
            files[0] = f.getParentFile();
        } else {
            files = tem;
        }

        Log.d("files", files.length + "");

        sortFilesByDirectory(files);
        // 为ListActivity设置Adapter
        setListAdapter(new Adapter(this, files, files.length == tem.length));
    }


    // 对文件进行排序
    private void sortFilesByDirectory(File[] files) {
        Arrays.sort(files, new Comparator<File>() {
            public int compare(File f1, File f2) {
                return Long.valueOf(f1.length()).compareTo(f2.length());
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        File f = files[position];
        if (!f.canRead()) {
            Toast.makeText(this, "文件不可读", Toast.LENGTH_SHORT).show();
            return;
        }
        if (f.isFile()) {// 为文件
            String path = f.getAbsolutePath();
            Intent intent = new Intent();
            intent.putExtra("path", path);
            setResult(FileUploadActivity.RESULT_LOAD_FILE, intent);
            finish();
        } else {
            getFiles(f.getAbsolutePath());
        }
    }

    class Adapter extends BaseAdapter {
        private File[] files;
        private boolean istop;
        private Context context;

        public Adapter(Context context, File[] files, boolean istop) {
            this.context = context;
            this.files = files;
            this.istop = istop;
        }

        @Override
        public int getCount() {
            return files.length;
        }

        @Override
        public Object getItem(int position) {
            return files[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if (convertView == null) {
                holder = new Holder();
                convertView = View.inflate(context, R.layout.item_fileupload,
                        null);
                holder.iv = (ImageView) convertView
                        .findViewById(R.id.adapter_icon);
                holder.tv = (TextView) convertView
                        .findViewById(R.id.adapter_txt);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }
            // 设置convertView中控件的值
            setconvertViewRow(position, holder);
            return convertView;
        }

        private void setconvertViewRow(int position, Holder holder) {
            File f = files[position];
            holder.tv.setText(f.getName());
            if (!istop && position == 0) {// 不是在顶层目录
                // 加载后退图标
                holder.iv.setImageResource(R.drawable.back_up);
            } else if (f.isFile()) {// 是文件
                // 加载文件图标
                holder.iv.setImageResource(R.drawable.file);
            } else {// 文件夹
                // 加载文件夹图标
                holder.iv.setImageResource(R.drawable.dir);
            }
        }

        class Holder {
            private ImageView iv;
            private TextView tv;
        }
    }

}
