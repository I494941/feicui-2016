package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.R;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.base.BaseActivity;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.biz.FileManager;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.CommonUtil;
import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.utils.FileTypeUtil;

import static contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.biz.FileManager.inSdcardDir;
import static contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.biz.FileManager.outSdcardDir;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

public class FilemgrActivity extends BaseActivity {

    private Thread thread;// 用来读取文件的线程
    private FileManager fileManager;// 文件管理类(逻辑)
    private TextView tv_textsize; // 文件总大小
    private View view_all; // 全部的item(当加载结束后，将有单击事件)
    private View view_txt; // 文档的item(同上)
    private View view_video; // 视频的item(同上)
    private View view_audio; // 音乐的item(同上)
    private View view_image; // 图像的item(同上)
    private View view_apk; // apk 的item(同上)
    private View view_zip; // zip 的item(同上)
    private TextView tv_all_size; // 全部item 的大小(当加载过程中，实时更新此分类的文件大小)
    private TextView tv_txt_size;// 文档item 的大小(同上)
    private TextView tv_video_size;// 视频item 的大小(同上)
    private TextView tv_audio_size;// 音乐item 的大小(同上)
    private TextView tv_image_size;// 图像item 的大小(同上)
    private TextView tv_apk_size;// apk item 的大小(同上)
    private TextView tv_zip_size;// zip item 的大小(同上)
    private ProgressBar pb_all_loading;// 全部item 的加载中图像(当加载过程中会显示,加载完后将隐藏)
    private ProgressBar pb_txt_loading;// 文档item 的加载中图像(同上)
    private ProgressBar pb_video_loading;// 视频item 的加载中图像(同上)
    private ProgressBar pb_audio_loading;// 音乐item 的加载中图像(同上)
    private ProgressBar pb_image_loading;// 图像item 的加载中图像(同上)
    private ProgressBar pb_apk_loading;// apk item 的加载中图像(同上)
    private ProgressBar pb_zip_loading;// zip item 的加载中图像(同上)
    private ImageView iv_all_righticon; // 全部item 的右侧图像(当加载结束后， 将显示出来(加载中显示的是loading))
    private ImageView iv_txt_righticon; // 文档item 的右侧图像(同上)
    private ImageView iv_video_righticon; // 视频item 的右侧图像(同上)
    private ImageView iv_audio_righticon; // 音乐item 的右侧图像(同上)
    private ImageView iv_image_righticon; // 图像item 的右侧图像(同上)
    private ImageView iv_apk_righticon; // apk item 的右侧图像(同上)
    private ImageView iv_zip_righticon; // zip item 的右侧图像(同上)


    private void initMainUI() {

        tv_textsize = (TextView) findViewById(R.id.tv_filesize);

        view_all = findViewById(R.id.file_classlist_all);
        view_txt = findViewById(R.id.file_classlist_txt);
        view_video = findViewById(R.id.file_classlist_video);
        view_audio = findViewById(R.id.file_classlist_audio);
        view_image = findViewById(R.id.file_classlist_image);
        view_apk = findViewById(R.id.file_classlist_apk);
        view_zip = findViewById(R.id.file_classlist_zip);

        tv_all_size = (TextView) findViewById(R.id.file_all_size);
        tv_txt_size = (TextView) findViewById(R.id.file_txt_size);
        tv_video_size = (TextView) findViewById(R.id.file_video_size);
        tv_audio_size = (TextView) findViewById(R.id.file_audio_size);
        tv_image_size = (TextView) findViewById(R.id.file_image_size);
        tv_apk_size = (TextView) findViewById(R.id.file_apk_size);
        tv_zip_size = (TextView) findViewById(R.id.file_zip_size);

        iv_all_righticon = (ImageView) findViewById(R.id.file_all_righticon);
        iv_txt_righticon = (ImageView) findViewById(R.id.file_txt_righticon);
        iv_video_righticon = (ImageView) findViewById(R.id.file_video_righticon);
        iv_audio_righticon = (ImageView) findViewById(R.id.file_audio_righticon);
        iv_image_righticon = (ImageView) findViewById(R.id.file_image_righticon);
        iv_apk_righticon = (ImageView) findViewById(R.id.file_apk_righticon);
        iv_zip_righticon = (ImageView) findViewById(R.id.file_zip_righticon);

        pb_all_loading = (ProgressBar) findViewById(R.id.file_all_loading);
        pb_txt_loading = (ProgressBar)
                findViewById(R.id.file_txt_loading);
        pb_video_loading = (ProgressBar)
                findViewById(R.id.file_video_loading);
        pb_audio_loading = (ProgressBar)
                findViewById(R.id.file_audio_loading);
        pb_image_loading = (ProgressBar)
                findViewById(R.id.file_image_loading);
        pb_apk_loading = (ProgressBar)
                findViewById(R.id.file_apk_loading);
        pb_zip_loading = (ProgressBar)
                findViewById(R.id.file_zip_loading);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filemgr);

        initMainUI();

    }

    //回调接口的初始化
    private FileManager.SearchFileListener searchFileListener = new FileManager.SearchFileListener() {
        @Override
        public void searching(String typeName) {
            FilemgrActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv_all_size.setText();
                }
            });
        }

        @Override
        public void end(boolean isExceptionEnd) {
// TODO Auto-generated method stub
            FilemgrActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(FilemgrActivity.this, "搜索结束",
                            Toast.LENGTH_SHORT).show();
                    pb_all_loading.setVisibility(View.GONE);
                    iv_all_righticon.setVisibility(View.VISIBLE);
                }
            });
        }

        /**
         * 异步加载数据
         */
        private void asynLoadData() {
            fileManager = FileManager.getFileManager();
            fileManager.setSearchFileListener(searchFileListener);
            //启动线程进行文件搜索
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    fileManager.searchSDCardFile();
                }
            });

            thread.start();
        }

        public interface SearchFileListener {
            /**
             * 当搜索过程中，每搜索到一个文件将调用
             * 想要获取当前数据集合及数据量，可用getApkFileSize()和getApkFileList()实时获取
             *
             * @see
             */
            void searching(String typeName);

            /**
             * 当搜索结束时将调用
             */
            void end(boolean isExceptionEnd);
        }

        /**
         * 设置文件查找监听
         */
        public void setSearchFileListener(SearchFileListener listener) {
            this.listener = listener;
        }

        /**
         * 用来回调 SearchFileListener 接口内方法
         */
        private void callbackSearchFileListenerSearching(String typeName) {
            if (listener != null) {
                listener.searching(typeName);
            }
        }

        /**
         * 用来回调 SearchFileListener 接口内方法
         */
        private void callbackSearchFileListenerEnd(boolean isExceptionEnd) {
            if (listener != null) {
                listener.end(isExceptionEnd);
            }
        }

        /**
         * 递归搜索所有文件
         *
         * @param file
         * @param flag 为递归结束判断准备,每次调用方法栈内的flag 值都不一样,第一次
         *             调用的结束才是真正结束(才会调用反馈结束方法)
         */
        private void searchFile(File file, boolean isFirstRunFlag) {
            // ----中止搜索------
            // 是首次运行的结束(搜索结束)
            if (isFirstRunFlag) {
// 回调接口end()方法,搜索结束(异常结束)
                callbackSearchFileListenerEnd(true);
            }
            return;
// #1 排除"不正常"文件
            if (file == null || !file.canRead() || !file.exists()) {
// 是首次运行的结束(搜索结束)
                if (isFirstRunFlag) {
// 回调接口end()方法,搜索结束(异常结束)
                    callbackSearchFileListenerEnd(true);
                }
                return;
            }
// #2 如果是文件(非目录)
            if (!file.isDirectory()) {
// 判断文件大小
                if (file.length() <= 0) {
                    return;
                }
//如果文件名称中没有“.” 未知文件类型
                if (file.getName().lastIndexOf('.') == -1) {
                    return;
// #3 如果是目录
                    File[] files = file.listFiles();
                    if (files == null || files.length <= 0) {
                        return;
                    }
                    for (int i = 0; i < files.length; i++) {
                        File tmpFile = files[i];
// 递归,以后的方法栈内的flag 值都为false,表示不再是第一次的调用
                        searchFile(tmpFile, false);
                    }
// 是首次运行的结束(搜索结束)
                    if (isFirstRunFlag) {
// 回调接口end()方法,搜索结束，完成，非异常结束
                        callbackSearchFileListenerEnd(false);
                    }
                }


            }
        }


        /**
         * 搜索存储卡目录下的所有文件,结果实时保存在 {@link #anyFileList}内
         */
        public void searchSDCardFile() {
            if (anyFileList == null || anyFileList.size() <= 0) {
                initData();
// 传入false 标记, 不让运算反溃结束
                searchFile(inSdcardDir, false);
// 传入true 标记, 让运算反溃结束
                searchFile(outSdcardDir, true);
            } else {
// 直接回调非异常结束
                callbackSearchFileListenerEnd(false);
            }
        }


    };

    //实时更新各类文件大小
    @Override
    protected void myHandleMessage(Message msg) {
// TODO Auto-generated method stub
//文件实时更新操作
        if (msg.what == 1) {
            tv_textsize.setText(CommonUtil.getFileSize(fileManager.getAnyFileSize()));
            tv_all_size.setText(CommonUtil.getFileSize(fileManager.getAnyFileSize()));
            String typeName = (String) msg.obj;
            if (typeName.equals(FileTypeUtil.TYPE_APK)) {
                tv_apk_size.setText(CommonUtil.getFileSize(fileManager.getApkFileSize()));
            } else if (typeName.equals(FileTypeUtil.TYPE_AUDIO)) {
                tv_audio_size.setText(CommonUtil.getFileSize(fileManager.getAudioFileSize()));
            } else if (typeName.equals(FileTypeUtil.TYPE_IMAGE)) {
                tv_image_size.setText(CommonUtil.getFileSize(fileManager.getImageFileSize()));
            } else if (typeName.equals(FileTypeUtil.TYPE_TXT)) {
                tv_txt_size.setText(CommonUtil.getFileSize(fileManager.getTxtFileSize()));
            } else if (typeName.equals(FileTypeUtil.TYPE_VIDEO)) {
                tv_video_size.setText(CommonUtil.getFileSize(fileManager.getVideoFileSize()));
            } else if (typeName.equals(FileTypeUtil.TYPE_ZIP)) {
                tv_zip_size.setText(CommonUtil.getFileSize(fileManager.getZipFileSize()));
            }
        }
//文件结束更新操作
        if (msg.what == 2) {
            tv_textsize.setText(CommonUtil.getFileSize(fileManager.getAnyFileSize()));
            tv_all_size.setText(CommonUtil.getFileSize(fileManager.getAnyFileSize()));
            tv_apk_size.setText(CommonUtil.getFileSize(fileManager.getApkFileSize()));
            tv_audio_size.setText(CommonUtil.getFileSize(fileManager.getAudioFileSize()));
            tv_image_size.setText(CommonUtil.getFileSize(fileManager.getImageFileSize()));
            tv_txt_size.setText(CommonUtil.getFileSize(fileManager.getTxtFileSize()));
            tv_video_size.setText(CommonUtil.getFileSize(fileManager.getVideoFileSize()));
            tv_zip_size.setText(CommonUtil.getFileSize(fileManager.getZipFileSize()));
            pb_all_loading.setVisibility(View.GONE);
            pb_txt_loading.setVisibility(View.GONE);
            pb_video_loading.setVisibility(View.GONE);
            pb_audio_loading.setVisibility(View.GONE);
            pb_image_loading.setVisibility(View.GONE);
            pb_apk_loading.setVisibility(View.GONE);
            pb_zip_loading.setVisibility(View.GONE);
            iv_all_righticon.setVisibility(View.VISIBLE);
            iv_txt_righticon.setVisibility(View.VISIBLE);
            iv_video_righticon.setVisibility(View.VISIBLE);
            iv_audio_righticon.setVisibility(View.VISIBLE);
            iv_image_righticon.setVisibility(View.VISIBLE);
            iv_apk_righticon.setVisibility(View.VISIBLE);
            iv_zip_righticon.setVisibility(View.VISIBLE);
            view_all.setOnClickListener(FilemgrActivity.this);
            view_txt.setOnClickListener(FilemgrActivity.this);
            view_video.setOnClickListener(FilemgrActivity.this);
            view_audio.setOnClickListener(FilemgrActivity.this);
            view_image.setOnClickListener(FilemgrActivity.this);
            view_apk.setOnClickListener(FilemgrActivity.this);
            view_zip.setOnClickListener(FilemgrActivity.this);
        }
    }




    //回调接口的初始化
    private FileManager.SearchFileListener searchFileListener = new FileManager.SearchFileListener() {
        @Override
        public void searching(String typeName) {
            Message msg = mainHandler.obtainMessage();
//利用what 值对消息进行判断
            msg.what = 1;
            msg.obj = typeName;
            mainHandler.sendMessage(msg);
        }

        @Override
        public void end(boolean isExceptionEnd) {
// TODO Auto-generated method stub
            mainHandler.sendEmptyMessage(2);
        }
    };

    @Override
    public void onClick(View v) {
        int viewID = v.getId();
        switch (viewID) {
//标题栏左侧返回按钮
            case R.id.iv_left:
                finish();
                break;
            case R.id.file_classlist_all:
            case R.id.file_classlist_txt:
            case R.id.file_classlist_video:
            case R.id.file_classlist_audio:
            case R.id.file_classlist_image:
            case R.id.file_classlist_apk:
            case R.id.file_classlist_zip:
                Intent intent = new Intent(FilemgrActivity.this, FilemgrShowActivity.class);
                intent.putExtra("id", viewID);
                startActivityForResult(intent, 1);
                break;
            default:
                break;
        }
    }


}
