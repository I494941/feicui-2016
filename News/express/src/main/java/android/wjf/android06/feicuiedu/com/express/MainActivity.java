package android.wjf.android06.feicuiedu.com.express;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private Context context;

    @ViewInject(R.id.ed_order)
    private EditText edOrder;
    @ViewInject(R.id.sp_company)
    private Spinner spCompany;
    @ViewInject(R.id.btn_query)
    private Button btnQuery;
    @ViewInject(R.id.lv_data)
    private ListView lvData;

    private String orderNo;

    private List<Map<String, String>> lstCompany = new ArrayList<>();

    private String selectedCompany;

    private List<Map<String, String>> lstData = new ArrayList<>();

    private SpinnerAdapter spAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return lstCompany.size();
        }

        @Override
        public Map<String, String> getItem(int position) {
            return lstCompany.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lif.inflate(R.layout.spinner_item_layout, null);
            TextView tvCompanyName = (TextView) convertView.findViewById(R.id.tv_company_name);
            Map<String, String> map = getItem(position);
            String value = "";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                value = entry.getValue();
            }

            tvCompanyName.setText(value);
            return convertView;
        }
    };

    private AdapterView.OnItemSelectedListener spOisl = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> map = lstCompany.get(position);
            String key = "";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                key = entry.getKey();
            }

            selectedCompany = key;

            // Toast.makeText(context,"当先选择中的快递公司为:"+selectedCompany,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private View.OnClickListener btnOcl = new View.OnClickListener() {


        @Override
        public void onClick(View view) {
            requestNet();
        }
    };
    private String TAG = "<<<<<";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        x.view().inject(this);
        initData();

        spCompany.setAdapter(spAdapter);
        spCompany.setOnItemSelectedListener(spOisl);
        btnQuery.setOnClickListener(btnOcl);

    }

    private void initData() {
        lstCompany = getCompanys();

    }

    private List<Map<String, String>> getCompanys() {
        List<Map<String, String>> result = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("shentong", "申通");
        result.add(map);

        map = new HashMap<>();
        map.put("ems", "EMS");
        result.add(map);


        map = new HashMap<>();
        map.put("shunfeng", "顺丰");
        result.add(map);

        map = new HashMap<>();
        map.put("yuantong", "圆通");
        result.add(map);

        map = new HashMap<>();
        map.put("zhongtong", "中通");
        result.add(map);

        map = new HashMap<>();
        map.put("yunda", "韵达");
        result.add(map);

        map = new HashMap<>();
        map.put("tiantian", "天天");
        result.add(map);

        map = new HashMap<>();
        map.put("huitongkuaidi", "汇通");
        result.add(map);

        map = new HashMap<>();
        map.put("quanfengkuaidi", "全峰");
        result.add(map);

        map = new HashMap<>();
        map.put("debangwuliu", "德邦");
        result.add(map);

        map = new HashMap<>();
        map.put("zhaijisong", "宅急送");
        result.add(map);

        return result;
    }

    private void requestNet() {

        orderNo = String.valueOf(edOrder.getText());
        String company = selectedCompany;

        RequestParams requestParams = new RequestParams("http://www.kuaidi100.com/query");
        requestParams.addParameter("type", company);
        requestParams.addParameter("postid", orderNo);

        Log.d(TAG, "requestNet: " + orderNo);

        Log.d(TAG, "requestNet: " + requestParams.toString());

        Callback.Cancelable callable = x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                Log.d(TAG, "onSuccess: result=" + result);
                JSONObject jsonObj = null;
                try {
                    /*jsonObj = new JSONObject(result);
                    JSONArray jsonArray = jsonObj.getJSONArray("results");
                    JSONObject resutObj= jsonArray.getJSONObject(0);
                    JSONArray weatherArray = resutObj.getJSONArray("weather_data");
                    JSONObject weatherObj = weatherArray.getJSONObject(0);
                    final String dayPictureUrl = weatherObj.getString("dayPictureUrl");
                    Log.d(TAG, "dayPictureUrl: "+dayPictureUrl);*/
                    //x.image().bind(ivTest,dayPictureUrl);

                    jsonObj = new JSONObject(result);
                    JSONArray array = jsonObj.getJSONArray("data");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        String time = obj.getString("time");
                        String ftime = obj.getString("ftime");
                        String context = obj.getString("context");

                        Map<String, String> tmpMap = new HashMap<>();
                        tmpMap.put("time", time);
                        tmpMap.put("ftime", ftime);
                        tmpMap.put("context", context);

                        lstData.add(tmpMap);

                        lvData.setAdapter(lvAdapter);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d(TAG, "onError: result=" + ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.d(TAG, "onCancelled: result=" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.d(TAG, "onFinished: ");
            }
        });

    }

    private ListAdapter lvAdapter = new BaseAdapter() {

        @Override
        public int getCount() {
            return lstData.size();
        }

        @Override
        public Map<String, String> getItem(int position) {
            return lstData.get(position);
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


}
