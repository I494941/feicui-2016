package android.wjf.android06.feicuiedu.com.newsapp.net;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

public class RequestNet {

    private static final String TAG = "RequestNet";

    private Map<String, String> map = new LinkedHashMap<>();

    private IResponse iResponse;

    public void requestNet(IResponse response) {

        iResponse = response;

        RequestParams requestParams = new RequestParams(Gobal.API);

        requestParams.addParameter("ver", Gobal.API_MAIN_VER);
        requestParams.addParameter("imei", Gobal.API_MAIN_IMEI);

        Callback.Cancelable callable = x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                JSONObject jsonObj = null;

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
                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                iResponse.onReturn(map);
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

    public interface IResponse {
        public void onReturn(Map<String, String> map);
    }
}
