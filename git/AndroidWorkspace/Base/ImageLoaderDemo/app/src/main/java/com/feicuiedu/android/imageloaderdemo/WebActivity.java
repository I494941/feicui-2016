package com.feicuiedu.android.imageloaderdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/14.
 */
public class WebActivity extends AppCompatActivity {

    private String title;
    private String url;
    private TextView tvTitle;
    private WebView wvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        wvWeb = (WebView) findViewById(R.id.wv_web);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null || bundle.getString("url") == null || "".equals(bundle.getString("url"))) {
            wvWeb.loadUrl("file:///android_asset/error.html");
        }
        else {
            title = bundle.getString("title");
            url = bundle.getString("url");
            //url = "http://m.ele.me";
            url = "http://m.baidu.com";
            tvTitle.setText(title);

            Log.d("webview_url",url);
            wvWeb.loadUrl(url);


            //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
           wvWeb.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    // TODO Auto-generated method stub
                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
            });

         // 这个 地方对webwiew 的讲解很到位，可参见  http://www.cnblogs.com/tinyphp/p/3858997.html
        }
    }

    public void rtnMain(View v) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
    }
}
