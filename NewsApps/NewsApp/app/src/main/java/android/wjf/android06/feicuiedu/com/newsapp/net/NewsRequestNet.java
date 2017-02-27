package android.wjf.android06.feicuiedu.com.newsapp.net;

import android.wjf.android06.feicuiedu.com.newsapp.ui.adapter.NewsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

public class NewsRequestNet {

    List<Map<String, String>> list = new ArrayList<>();

    public void NewsRequestNet(String subid, List<Map<String, String>> tmpList, final NewsAdapter tmpAdapter) {

        list = tmpList;

        RequestParams requestParams = new RequestParams(Gobal.API_MAIN);

        requestParams.addParameter("ver", Gobal.API_MAIN_VER);
        requestParams.addParameter("subid", subid);
        requestParams.addParameter("dir", Gobal.API_MAIN_DIR);
        requestParams.addParameter("nid", Gobal.API_MAIN_NID);
        requestParams.addParameter("stamp", Gobal.API_MAIN_STAMP);
        requestParams.addParameter("cnt", Gobal.API_MAIN_CNT);

        Callback.Cancelable callable = x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                JSONObject jsonObj = null;
                try {
                    jsonObj = new JSONObject(result);
                    JSONArray jsonArray = jsonObj.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String summary = obj.getString("summary");
                        String icon = obj.getString("icon");
                        String stamp = obj.getString("stamp");
                        String title = obj.getString("title");
                        String nid = obj.getString("nid");
                        String link = obj.getString("link");
                        String type = obj.getString("type");

                        Map<String, String> tmpMap = new HashMap<>();
                        tmpMap.put("summary", summary);
                        tmpMap.put("icon", icon);
                        tmpMap.put("stamp", stamp);
                        tmpMap.put("title", title);
                        tmpMap.put("nid", nid);
                        tmpMap.put("link", link);
                        tmpMap.put("type", type);

                        list.add(tmpMap);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                tmpAdapter.notifyDataSetChanged();


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
