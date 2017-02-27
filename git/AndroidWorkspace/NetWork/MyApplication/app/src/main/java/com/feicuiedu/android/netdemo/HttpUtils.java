package com.feicuiedu.android.netdemo;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by feicui on 16-11-30.
 */

public class HttpUtils {

    private static final String TAG = "HttpUtils";

    private String strUrls;

    private IResponse iResponse;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1001) {
                String str = (String) msg.obj;

                Log.d(TAG, "handleMessage: "+str);

                iResponse.onSuccess(str);
            }
        }
    };

    public void requestByGet(String strUrl, Map<String,String> map, IResponse response) {

        iResponse = response;

        StringBuilder sbParams= new StringBuilder();

        for (Map.Entry<String,String> entry :map.entrySet()) {
            sbParams.append(entry.getKey()+"="+entry.getValue()+"&");
        }

        sbParams.deleteCharAt(sbParams.length()-1);

        strUrls = strUrl+"?"+sbParams;

        // String strUrl = Gobal.API_HISTORY+"?key="+Gobal.API_HISTORY_KEY+"&v="+Gobal.API_HISTORY_V+"&month=11&day=30";

        new Thread(){
            @Override
            public void run() {

                String rtnStr = null;
                try {
                    URL url = new URL(strUrls);

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setConnectTimeout(5000);
                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    connection.setRequestMethod("GET");

                    // 获取输出流 用户post传参
                   /* OutputStream out = connection.getOutputStream();
                    out.write(sbParam.toString().getBytes());
                    out.flush();*/

                    if (connection.getResponseCode() == 200) {

                        InputStream is = connection.getInputStream();

                        byte[] data = transInputreamToByteArray(is);
                        rtnStr = new String(data, "UTF-8");

                        Log.d(TAG, "rtnStr="+rtnStr);
                        Message message = new Message();
                        message.what = 1001;
                        message.obj = rtnStr;
                        handler.sendMessage(message);

                    } else {
                        Log.d(TAG, "run: error");
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    /**
     * 把InputStream 转换成 字节数组
     * @param inStream 输入留
     * @return 字节数组
     * @throws Exception
     */
    private byte[] transInputreamToByteArray(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    public interface IResponse{

        public void onSuccess(String json);
    };
}
