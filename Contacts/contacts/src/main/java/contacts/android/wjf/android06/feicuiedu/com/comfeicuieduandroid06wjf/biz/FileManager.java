package contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.biz;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

import java.io.File;
import java.util.ArrayList;

import contacts.android.wjf.android06.feicuiedu.com.comfeicuieduandroid06wjf.entity.FileInfo;

/**
 * 文件管理类<br>
 * 主要完成文件大小的读取，分类以及删除
 *
 * @author Administrator
 */
public class FileManager {

    boolean isStopSearch;

    /**
     * 任意文件(非目录)集合
     */
    private ArrayList<FileInfo> anyFileList = new ArrayList<FileInfo>();
    // 任意文件总大小(在搜索过程中，实时迭加，计算总大小)
    private long anyFileSize;
    /**
     * 文档文件集合
     */
    private ArrayList<FileInfo> txtFileList = new ArrayList<FileInfo>();
    // 文档文件总大小(同上)
    private long txtFileSize;
    /**
     * 视频文件集合
     */
    private ArrayList<FileInfo> videoFileList = new ArrayList<FileInfo>();
    // 视频文件总大小(同上)
    private long videoFileSize;
    /**
     * 音乐文件集合
     */
    private ArrayList<FileInfo> audioFileList = new ArrayList<FileInfo>();
    // 音乐文件总大小(同上)
    private long audioFileSize;
    /**
     * 图像文件集合
     */
    private ArrayList<FileInfo> imageFileList = new ArrayList<FileInfo>();
    // 图像文件总大小(同上)
    private long imageFileSize;
    /**
     * ZIP 文件集合
     */
    private ArrayList<FileInfo> zipFileList = new ArrayList<FileInfo>();
    // ZIP 文件总大小(同上)
    private long zipFileSize;
    /**
     * APK 文件集合
     */
    private ArrayList<FileInfo> apkFileList = new ArrayList<FileInfo>();
    // APK 文件总大小(同上)
    private long apkFileSize;
    /**
     * 内置存储卡目录(可能为null)
     */
    public static File inSdcardDir = null;
    /**
     * 外置存储卡目录(可能为null)
     */
    public static File outSdcardDir = null;

    static {
        // 如果有手机内置sdcard 卡路径,进行内置Fiel 实例化(防止File file = new File(null))
        if (MemoryManager.getPhoneInSDCardPath() != null) {
            inSdcardDir = null;
            inSdcardDir = new File(MemoryManager.getPhoneInSDCardPath());
        }
        // 如果有手机外置sdcard 卡路径,进行外置Fiel 实例化(防止File file =new File(null))
        if (MemoryManager.getPhoneOutSDCardPath() != null) {
            outSdcardDir = null;
            outSdcardDir = new
                    File(MemoryManager.getPhoneOutSDCardPath());
        }
    }

    // 初始化相关变量
    private void initData() {
        isStopSearch = false;
        anyFileSize = 0;
        txtFileSize = 0;
        videoFileSize = 0;
        audioFileSize = 0;
        imageFileSize = 0;
        zipFileSize = 0;
        apkFileSize = 0;
        anyFileList.clear();
        txtFileList.clear();
        videoFileList.clear();
        audioFileList.clear();
        imageFileList.clear();
        zipFileList.clear();
        apkFileList.clear();
    }

    /**
     * 递归搜索所有文件
     *
     * @param file
     * @param
     * * 为递归结束判断准备,每次调用方法栈内的flag 值都不一样,第一次
    调用的结束才是真正结束(才会调用反馈结束方法)
     */
    private void searchFile(File file, boolean isFirstRunFlag) {
// 是首次运行的结束(搜索结束)
        if (isFirstRunFlag) {
// 回调接口end()方法,搜索结束(异常结束)
            callbackSearchFileListenerEnd(true); }
        return;
// #1 排除"不正常"文件
        if (file == null || !file.canRead() || !file.exists()) {
// 是首次运行的结束(搜索结束)
            if (isFirstRunFlag) {
// 回调接口end()方法,搜索结束(异常结束)
                callbackSearchFileListenerEnd(true); }
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
            }
//获取图标以及文件类型
            String[] iconAndTypeNames = FileTypeUtil
                    .getFileIconAndTypeName(file);
// 此文件使用什么图像(在Res 中的图标文件名称)
            final String iconName = iconAndTypeNames[0];
// 此文件是属什么类型的
// 添加到所有文件的集合
            final String typeName = iconAndTypeNames[1];
            FileInfo fileInfo = new FileInfo(file, iconName, typeName);
            anyFileList.add(fileInfo);
// 迭加计算总文件大小
            anyFileSize += file.length();
// 分类
            if (typeName.equals(FileTypeUtil.TYPE_APK)) {
                apkFileSize += file.length();
                apkFileList.add(fileInfo);
            } else if (typeName.equals(FileTypeUtil.TYPE_AUDIO)) {
                audioFileSize += file.length();
                audioFileList.add(fileInfo);
            } else if (typeName.equals(FileTypeUtil.TYPE_IMAGE)) {
                imageFileSize += file.length();
                imageFileList.add(fileInfo);
            } else if (typeName.equals(FileTypeUtil.TYPE_TXT)) {
                txtFileSize += file.length();
                txtFileList.add(fileInfo);
            } else if (typeName.equals(FileTypeUtil.TYPE_VIDEO)) {
                videoFileSize += file.length();
                videoFileList.add(fileInfo);
            } else if (typeName.equals(FileTypeUtil.TYPE_ZIP)) {
                zipFileSize += file.length();
                zipFileList.add(fileInfo);
            }
// 回调接口searching 方法(用作通知调用者数据更新了)
            callbackSearchFileListenerSearching(typeName);
            return;
        }
// #3 如果是目录
        File[] files = file.listFiles();
        if (files == null || files.length <= 0) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            File tmpFile = files[i];
// 递归,以后的方法栈内的flag 值都为false,表示不再是第一次的调用
            searchFile(tmpFile, false); }
// 是首次运行的结束(搜索结束)
        if (isFirstRunFlag) {
// 回调接口end()方法,搜索结束，完成，非异常结束
            callbackSearchFileListenerEnd(false); }
    }








    // 搜索过程监听
    private SearchFileListener listener;

    /**
     * 搜索过程的实时监听{@link
     * #setSearchFileListener(SearchFileListener listener)},
     * 用做搜索过程实时反溃文件信息
     */
    public interface SearchFileListener {
        /**
         * 当搜索过程中，每搜索到一个文件将调用
         * 想要获取当前数据集合及数据量，
         *
         * @see
         */
        void searching(int size);
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

    private void callbackSearchFileListenerSearching(int size) {
        if (listener != null) {
            listener.searching(size);
        }
    }

}
