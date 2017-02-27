package android.wjf.android06.feicuiedu.com.news.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.wjf.android06.feicuiedu.com.news.R;
import android.wjf.android06.feicuiedu.com.news.common.CommonUtil;
import android.wjf.android06.feicuiedu.com.news.common.LoadImage;
import android.wjf.android06.feicuiedu.com.news.model.entity.News;
import android.wjf.android06.feicuiedu.com.news.ui.base.MyBaseAdapter;

/**
 * Created by ad06-wjf on 2016/11/28.
 */

/**
 * 新闻数据适配器
 * 1.holdview 绑定控件三个控件赋值图片为默认
 * 2.图片处理
 */
public class NewsAdapter extends MyBaseAdapter<News> {
    /**
     * 加载图片之前默认图片
     */
    private Bitmap defaultBitmap;
    private ListView listview;

    //图片工具类
    private LoadImage loadImage;

    public NewsAdapter(Context c, ListView lv) {
        super(c);
        defaultBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.cccc);
        listview = lv;
        loadImage = new LoadImage(c, listener);
    }

    /***
     * 返回每一个子条目的视图
     */
    @Override
    public View getMyView(int position, View convertView, ViewGroup parent) {
        HoldView holdView = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list_news, null);
            holdView = new HoldView(convertView);
            convertView.setTag(holdView);
        } else {
            holdView = (HoldView) convertView.getTag();
        }
        News news = myList.get(position);
        holdView.tv_title.setText(news.getTitle());
        holdView.tv_text.setText(news.getSummary());

        // holdView.iv_list_image.setImageBitmap(defaultBitmap);//默认图片

        //1，得到图片的地址
        String uriImage = news.getIcon();
        //给每个图片控件存入编号把图片的名字作为表示
        holdView.iv_list_image.setTag(CommonUtil.NETPATH + uriImage);
        //获取图片 1. 先从网络 2.如果已经下载过了存在本地文件中下次启动程序从文件读取 3.当程序不关闭再次进入该界面从内存中读取
        Bitmap bitmap = loadImage.getBitmap(uriImage);
        //如果不是网络的则马上加载可以是文件或内存
        if (bitmap != null) {
            holdView.iv_list_image.setImageBitmap(bitmap);
        }


        return convertView;
    }

    /**
     * 标签类
     */
    public class HoldView {
        public ImageView iv_list_image;
        public TextView tv_title;
        public TextView tv_text;

        public HoldView(View view) {
            this.iv_list_image = (ImageView) view.findViewById(R.id.imageView1);
            tv_title = (TextView) view.findViewById(R.id.textView1);
            tv_text = (TextView) view.findViewById(R.id.textView2);
        }
    }

    //回调的接口
    private LoadImage.ImageLoadListener listener = new LoadImage.ImageLoadListener() {
        @Override
        public void imageLoadOk(Bitmap bitmap, String url) {
            //得到每个listview的图片,通过异步加载显示图片
            ImageView iv = (ImageView) listview.findViewWithTag(url);
            if (iv != null) {
                //加载图片
                iv.setImageBitmap(bitmap);
            }
        }
    };

}
