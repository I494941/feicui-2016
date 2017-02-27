package android.wjf.android06.feicuiedu.com.xutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.LinkedHashMap;
import java.util.Map;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.btn)
    private Button btn;

    @ViewInject(R.id.tv)
    private TextView tv;
    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "11111", Toast.LENGTH_SHORT).show();
            requestNet();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        btn.setOnClickListener(ocl);


    }

    private void requestNet() {

        RequestParams requestParams = new RequestParams("http://118.244.212.82:9092/newsClient/news_sort?ver=0000000&imei=0");

        // requestParams.addParameter("ver", "0000000");
        // requestParams.addParameter("imei", "0");

        Callback.Cancelable callable = x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                JSONObject jsonObj = null;
               Map<String, String> map = new LinkedHashMap<>();

                try {

                    jsonObj = new JSONObject(result);

                    JSONArray jsonArray = jsonObj.getJSONArray("data");

                    JSONObject jObject = null;
                    JSONArray arrayGrp = null;
                    JSONObject ObjectJ = null;
                    String id = "";
                    String group = "";

                    for (int i = 0; i < jsonArray.length(); i++) {
                        jObject = jsonArray.getJSONObject(i);
                        arrayGrp = jObject.getJSONArray("subgrp");

                        for (int j = 0; j < arrayGrp.length(); j++) {
                            ObjectJ = arrayGrp.getJSONObject(j);

                            id = ObjectJ.getString("subid");
                            group = ObjectJ.getString("subgroup");
                            map.put(id, group);
                            Toast.makeText(MainActivity.this, id+group, Toast.LENGTH_SHORT).show();
                        }
                    }
                    Log.d("2222", "onSuccess: "+map);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
