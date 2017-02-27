package android.wjf.android06.feicuiedu.com.newsapp.net;

import android.content.Context;
import android.util.Log;
import android.wjf.android06.feicuiedu.com.newsapp.model.biz.parser.ParserNews;
import android.wjf.android06.feicuiedu.com.newsapp.model.dao.NewsSubTypeDBManager;
import android.wjf.android06.feicuiedu.com.newsapp.model.entity.SubType;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;

/**
 * Created by ad06-wjf on 2016/11/30.
 */

public class RequestNet {

    private Context context;

    private IResponse iResponse;

    private static final String TAG = "RequestNet";

    private ArrayList<SubType> arrayListType;

    public void requestNet(Context tmpcontext,IResponse response) {
        context = tmpcontext;
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

                    arrayListType = new ParserNews(context).parserTypeList(jsonObj);

                    Log.d(TAG, "onSuccess: <<<<"+arrayListType.get(0).toString());

                    for (int i = 0; i < arrayListType.size(); i++) {

                        new NewsSubTypeDBManager(context).insertSubType(arrayListType.get(i));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                iResponse.onReturn();
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
        public void onReturn();
    }

}
