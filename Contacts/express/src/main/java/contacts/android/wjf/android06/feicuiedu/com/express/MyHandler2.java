package contacts.android.wjf.android06.feicuiedu.com.express;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ad06-wjf on 2016/11/10.
 */

public class MyHandler2 extends Handler {

    private static final String TAG = "MyHandler";
    private Context context;

    private List<Map<String, String>> resultList = new ArrayList<>();
    private ListView lvData;

    private ListAdapter lvAdapter = new BaseAdapter() {

        @Override
        public int getCount() {
            return resultList.size();
        }

        @Override
        public Map<String, String> getItem(int position) {
            return resultList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lif.inflate(R.layout.listview_item_layout, null);

            TextView tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            TextView tvFTime = (TextView) convertView.findViewById(R.id.tv_ftime);
            TextView tvContent = (TextView) convertView.findViewById(R.id.tv_content);

            Map<String, String> map = getItem(position);
            String time = map.get("time");
            String ftime = map.get("ftime");
            String context = map.get("context");

            tvTime.setText(time);
            tvFTime.setText(ftime);
            tvContent.setText(context);


            return convertView;
        }
    };


    public MyHandler2(ListView lvData, Context context) {
        this.lvData = lvData;
        this.context = context;
    }

    @Override
    public void handleMessage(Message msg) {

        String orderNo;
        String company;

        if (msg.what == 1) {
            orderNo = msg.getData().getString("text1");
            company = msg.getData().getString("text2");
        } else {
            orderNo = null;
            company = null;
        }

        String strUrl = "http://www.kuaidi100.com/query";
        String strParams = "type=" + company + "&postid=" + orderNo;

        Log.d(TAG, "handleMessage: strUrl = " + strUrl);
        Log.d(TAG, "handleMessage: strParams = " + strParams);

        String result = null;
        URL url = null;
        try {
            url = new URL(strUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod("POST");
            // httpURLConnection.setRequestMethod("POST");

            // 获取输出流
            OutputStream out = httpURLConnection.getOutputStream();
            out.write(strParams.getBytes());
            out.flush();

            if (httpURLConnection.getResponseCode() == 200) {

                InputStream is = httpURLConnection.getInputStream();

                byte[] data = read(is);
                result = new String(data, "UTF-8");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d(TAG, "onPostExecute() called with: result = [" + result + "]");
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray array = jsonObject.getJSONArray("data");
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                String time = obj.getString("time");
                String ftime = obj.getString("ftime");
                String context = obj.getString("context");

                Map<String, String> tmpMap = new HashMap<>();
                tmpMap.put("time", time);
                tmpMap.put("ftime", ftime);
                tmpMap.put("context", context);

                resultList.add(tmpMap);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        lvData.setAdapter(lvAdapter);


    }

    // 从流中读取数据
    public byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

}
