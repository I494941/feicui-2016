package com.feicuiedu.android.netdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        // ?key=98f1072314447f4cbd4236b7e4706772&v=1.0&month=11&day=30

        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("v",Gobal.API_HISTORY_V);
        paramMap.put("key",Gobal.API_HISTORY_KEY);
        paramMap.put("month","11");
        paramMap.put("day","30");

        new HttpUtils().requestByGet(Gobal.API_HISTORY, paramMap, new HttpUtils.IResponse() {
            @Override
            public void onSuccess(String json) {

                Log.d(TAG, "onSuccess:json="+json);
            }
        });


        /*Callback.Cancelable callable = x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result){
                Log.d(TAG, "onSuccess: result="+result);
                JSONObject jsonObj = null;
                try {
                    jsonObj = new JSONObject(result);
                    JSONArray jsonArray = jsonObj.getJSONArray("results");
                    JSONObject resutObj= jsonArray.getJSONObject(0);
                    JSONArray weatherArray = resutObj.getJSONArray("weather_data");
                    JSONObject weatherObj = weatherArray.getJSONObject(0);
                    final String dayPictureUrl = weatherObj.getString("dayPictureUrl");
                    Log.d(TAG, "dayPictureUrl: "+dayPictureUrl);

                    x.image().bind(ivTest,dayPictureUrl);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        });*/
    }
}
