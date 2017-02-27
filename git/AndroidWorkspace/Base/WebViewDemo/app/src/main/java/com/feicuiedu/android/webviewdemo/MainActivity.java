package com.feicuiedu.android.webviewdemo;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    String errorUrl = "file:///android_asset/a.html";

    private String strUrl = "http://m.baidu.com";


    private WebView wv;

    private WebViewClient client = new WebViewClient(){

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            Log.d("hehehaha", "url: "+url);
            view.loadUrl(url);

            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
           // super.onPageFinished(view, url);

            Toast.makeText(MainActivity.this,"onPageFinished",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //super.onPageStarted(view, url, favicon);

            Toast.makeText(MainActivity.this,"onPageStarted",Toast.LENGTH_SHORT).show();
        }
    };

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {


            strUrl = (String) msg.obj;
            wv.loadUrl(strUrl);
            wv.setWebViewClient(client);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = (WebView) findViewById(R.id.wv1);

        wv.loadUrl(strUrl);
        wv.setWebViewClient(client);





        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);


        wv.addJavascriptInterface(new Object() {

            @JavascriptInterface
            public void clickFromJs(String value) {

                Toast.makeText(MainActivity.this,"hehe ,I'm from Android,"+value,Toast.LENGTH_SHORT).show();
            }

            @JavascriptInterface
            public void haha(String name,String value) {
                Toast.makeText(MainActivity.this,"hehe ,name="+name+",value="+value,Toast.LENGTH_SHORT).show();
            }
        },"cy");



    }
}
