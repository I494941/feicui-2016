package android.wjf.android06.feicuiedu.com.newsapp.net;

import android.content.Context;
import android.util.Log;
import android.wjf.android06.feicuiedu.com.newsapp.model.biz.parser.ParserNews;
import android.wjf.android06.feicuiedu.com.newsapp.model.dao.NewsDBManager;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.News;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

public class NewsRequestNet {

    private Context context;
    private IResponse2 iResponse2;
    private ArrayList<News> arrayList;
    private int subid;

    public void newsRequestNet(Context tmpcontext, int tmpsubid, IResponse2 response) {
        context = tmpcontext;
        subid = tmpsubid;
        iResponse2 = response;

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

                    arrayList = new ParserNews(context).parser(jsonObj, subid);
                    for (int i = 0; i < arrayList.size(); i++) {

                        Log.d("1111", "newsRequestNet: " + arrayList.get(i).toString());

                        NewsDBManager newsDBManager = new NewsDBManager(context);

                        long count = newsDBManager.getCount(subid);

                        List<News> listP = newsDBManager.queryNews((int) count, 0, subid);
                        Boolean bln = true;
                        for (int j = 0; j < count; j++) {
                            if (listP.get(j).getNid() == arrayList.get(i).getNid()) {
                                bln = false;
                            }
                        }

                        if (bln) {
                            new NewsDBManager(context).insertNews(arrayList.get(i));
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                iResponse2.onReturn();
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

    public interface IResponse2 {
        public void onReturn();
    }

}
