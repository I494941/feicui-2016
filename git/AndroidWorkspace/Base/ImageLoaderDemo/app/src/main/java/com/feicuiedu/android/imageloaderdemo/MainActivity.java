package com.feicuiedu.android.imageloaderdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView lv;
    private List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    private Map<String, String> paramMap = new HashMap<String, String>();
    private String url = "";
    private Bitmap defaultBitmap = null;
    private LoadImage loadImage;
    private LoadImage.ImageLoadListener listener = new LoadImage.ImageLoadListener() {

        @Override
        public void imageLoadOk(Bitmap bitmap, String url) {
            ImageView iv = (ImageView) lv.findViewWithTag(url);
            if (iv != null)
                iv.setImageBitmap(bitmap);
        }
    };
    private BaseAdapter ba = new BaseAdapter() {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            A holder = null;

            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main_item, null);
                holder = new A();
                holder.txt1 = (TextView) convertView.findViewById(R.id.txt1);
                holder.img1 = (ImageView) convertView.findViewById(R.id.img1);
                convertView.setTag(holder);
            } else {
                holder = (A) convertView.getTag();
            }

			/*
			 * if (position %2 ==0) {
			 * holder.txt1.setBackgroundColor(Color.YELLOW); } else {
			 * holder.txt1.setBackgroundColor(Color.GREEN); }
			 */

            Map<String, String> map = (Map<String, String>) getItem(position);

            String url = map.get("icon");
            holder.img1.setTag(url);

            // ???
            Bitmap bitmap = loadImage.geBitmap(url);
            if (bitmap != null) {
                holder.img1.setImageBitmap(bitmap);
            } else {
                holder.img1.setImageBitmap(defaultBitmap);
            }

            holder.txt1.setText(map.get("summary"));
            String title = map.get("title");
            String link = map.get("link");


            return convertView;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return list.get(position);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }
    };
    // Instances of anonymous classes do not hold an implicit
    // reference to their outer class when they are "static".
    private final Runnable sRunnable = new Runnable() {
        public void run() {
            ba.notifyDataSetChanged();
        }
    };
    private AdapterView.OnItemClickListener oicl = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> map = list.get(position);
            String title = map.get("title");
            String link = map.get("link");

            Bundle bundle = new Bundle();
            bundle.putString("url", link);
            bundle.putString("title", title);

            Intent intent = new Intent();
            intent.setClass(MainActivity.this, WebActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView1);

        defaultBitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);

        loadImage = new LoadImage(this, listener);

      /*  url = "/news_list";
        paramMap.put("ver", "1");
        paramMap.put("subid", "1");
        paramMap.put("dir", "1");
        paramMap.put("nid", "1");
        paramMap.put("stamp", "20140321");
        paramMap.put("cnt", "20");*/
        lv.setAdapter(ba);
        lv.setOnItemClickListener(oicl);


        getData();


    }

    private List<Map<String, String>> getData() {

        //  yibu  shagnchuan xiazai  gaobingfa


        url = "http://118.244.212.82:9092/newsClient/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";

        OkHttpClient okHttpClient = new OkHttpClient();
        final okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure() e=" + e);
            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.i(TAG, " onResponse() reuslt=" + response.body().string());
            }
        });



        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams rp = new RequestParams();
        rp.put("ver", "1");
        rp.put("subid", "1");
        rp.put("dir", "1");
        rp.put("nid", "1");
        rp.put("stamp", "20140321");
        rp.put("cnt", "20");

        url = "http://118.244.212.82:9092/newsClient/news_list";
        client.get(url, rp, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Log.d("onSuccess1", response.toString());

                JSONObject jsonObject;

                String dataStr = null;
                try {
                    jsonObject = response;
                    dataStr = jsonObject.getString("data");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                list = gson.fromJson(dataStr, new TypeToken<List<Map<String, String>>>() {
                }.getType());

                String str = gson.toJson(list);
                

                ba.notifyDataSetChanged();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                Log.d("onSuccess2", response.toString());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                super.onSuccess(statusCode, headers, responseString);
                Log.d("onSuccess3", responseString.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Log.d("onFailure1", responseString.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("onFailure2", errorResponse.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("onFailure3", errorResponse.toString());
            }
        });

        /*String json = HttpUtils.getDataByGet(url, paramMap);

        JSONObject jsonObject;

        String dataStr = null;
        try {
            jsonObject = new JSONObject(json);
            dataStr = jsonObject.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        list = gson.fromJson(dataStr, new TypeToken<List<Map<String, String>>>() {
        }.getType());
        *//*try {
			jsonObject = new JSONObject(json);
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				Map<String, String> map = new HashMap<String, String>();
				JSONObject json1 = jsonArray.getJSONObject(i);
				String summary = json1.getString("summary");
				String icon = json1.getString("icon");
				String stamp = json1.getString("stamp");
				int nid = json1.getInt("nid");
				String link = json1.getString("link");
				int type = json1.getInt("type");

				map.put("summary", summary);
				map.put("icon", icon);
				map.put("stamp", stamp);
				map.put("nid", nid + "");
				map.put("link", link);
				map.put("type", type + "");
				list.add(map);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*//*

        Log.d("gson_tojsonstr", gson.toJson(list));*/
        return list;
    }

    // 在Activity中使用非静态的内部类时, 尽量避免内部类生命周期超出了Activity之外
    private static class MyHandler extends Handler {

        private final WeakReference<MainActivity> mActivity;

        public MyHandler(MainActivity activity) {
            mActivity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mActivity.get();
            if (activity != null) {

            }
        }
    }

    class A {
        ImageView img1;
        TextView txt1;
    }
}
