package android.wjf.android06.feicuiedu.com.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ImageView imm1;
    private ImageView imn1;
    private ImageView imm2;
    private ImageView imn2;
    private ImageView imm3;
    private ImageView imn3;
    private ImageView imm4;
    private ImageView imn4;

    private TextView tvm1;
    private TextView tvn1;
    private TextView tvm2;
    private TextView tvn2;
    private TextView tvm3;
    private TextView tvn3;
    private TextView tvm4;
    private TextView tvn4;

    private List<Index> indexList = null;
    private List<WeatherData> weatherDataList = null;

    private ViewPager viewPager;

    private SimpleDraweeView[] simpleDraweeViews;

    private ImageView[] points = new ImageView[4];

    private LeadImgAdapter adapter;
    private List<View> viewList;

    int currentItem;
    private ScheduledExecutorService executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPage);
        initActionBar();
        requestNet("济南", new IResponse() {
            @Override
            public void onReturn(List<Index> indexLit, List<WeatherData> weatherDataLit) {
                Log.d("3333", "onReturn: " + indexLit.toString());
                indexList = indexLit;
                weatherDataList = weatherDataLit;

                initPagerData();

                initLeadPoints();
                setPoint(0);
                //初始化适配器
                adapter = new LeadImgAdapter(viewList);
                //设置适配器
                viewPager.setAdapter(adapter);

                viewPager.setOnPageChangeListener(listener);

                viewPager.setCurrentItem(currentItem);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_select:
                openSelect();
                return true;
            case R.id.action_index:
                openIndex();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initActionBar() {

        //获取ActionBar对象
        ActionBar bar = getSupportActionBar();
        //自定义一个布局，并居中
        bar.setDisplayShowCustomEnabled(true);
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.actionbar_main, null);

        bar.setCustomView(v, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));

    }

    private void requestNet(String tmpLocation, final IResponse response) {

        // private void requestNet() {

        RequestParams requestParams = new RequestParams(Gobal.API);

        requestParams.addParameter("location", tmpLocation);
        requestParams.addParameter("output", Gobal.OUTPUT);
        requestParams.addParameter("ak", Gobal.AK);


        Callback.Cancelable callable = x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                List<Index> indexList = null;
                List<WeatherData> weatherDataList = null;
                JSONObject jsonObj = null;
                JSONArray jsonArray = null;
                JSONObject jsonObjResults = null;
                try {
                    jsonObj = new JSONObject(result);

                    jsonArray = jsonObj.getJSONArray("results");
                    jsonObjResults = jsonArray.getJSONObject(0);


                    indexList = parserIndex(jsonObjResults);

                    weatherDataList = parserWeatherData(jsonObjResults);


                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response.onReturn(indexList, weatherDataList);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                ex.printStackTrace();
                System.out.println();
                Log.d("<<<<", "onError: ");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.d("<<<<", "onCancelled: ");
            }

            @Override
            public void onFinished() {
                Log.d("<<<<", "onFinished: ");
            }
        });
    }

    private interface IResponse {
        public void onReturn(List<Index> indexList, List<WeatherData> weatherDataList);
    }

    public ArrayList<Index> parserIndex(JSONObject jsonObject) throws Exception {
        ArrayList<Index> indexLit = new ArrayList<Index>();
        //根据数据块名称获取一个数组
        JSONArray jsonArray = jsonObject.getJSONArray("index");
        Log.d("4444", "parserIndex: ");
        JSONObject object;
        String des;
        String tipt;
        String title;
        String zs;
        //循环遍历这个数组
        for (int i = 0; i < jsonArray.length(); i++) {
            object = jsonArray.getJSONObject(i);
            des = object.getString("des");
            tipt = object.getString("tipt");
            title = object.getString("title");
            zs = object.getString("zs");

            Index index = new Index(des, tipt, title, zs);

            Log.d("1111", "parserIndex: " + index.toString());
            indexLit.add(index);
        }
        return indexLit;
    }

    public ArrayList<WeatherData> parserWeatherData(JSONObject jsonObject) throws Exception {
        ArrayList<WeatherData> weatherDataLit = new ArrayList<WeatherData>();
        //根据数据块名称获取一个数组
        JSONArray jsonArray = jsonObject.getJSONArray("weather_data");

        JSONObject object;
        String date;
        String dayPictureUrl;
        String nightPictureUrl;
        String weather;
        String wind;
        String temperature;
        //循环遍历这个数组
        for (int i = 0; i < jsonArray.length(); i++) {
            object = jsonArray.getJSONObject(i);
            date = object.getString("date");
            dayPictureUrl = object.getString("dayPictureUrl");
            nightPictureUrl = object.getString("nightPictureUrl");
            weather = object.getString("weather");
            wind = object.getString("wind");
            temperature = object.getString("temperature");

            WeatherData weatherData = new WeatherData(date, dayPictureUrl, nightPictureUrl, weather, wind, temperature);

            Log.d("2222", "parserWeatherData: " + weatherData.toString());
            weatherDataLit.add(weatherData);
        }
        return weatherDataLit;
    }

    @Override
    protected void onResume() {
        super.onResume();

        startAutoScroll(); // activity激活时候自动播放
    }

    @Override
    protected void onPause() {
        super.onPause();

        stopAutoScroll(); // activity暂停时候停止自动播放
    }

    private void startAutoScroll() {
        stopAutoScroll();

        executor = Executors.newSingleThreadScheduledExecutor();
        Runnable command = new Runnable() {
            @Override
            public void run() {
                selectNextItem();
            }

            private void selectNextItem() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        viewPager.setCurrentItem(++currentItem);

                        if (currentItem >= 3) {
                            currentItem = -1;
                        }
                    }
                });
            }
        };
        int delay = 2;
        int period = 2;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        executor.scheduleAtFixedRate(command, delay, period, timeUnit);
    }

    private void stopAutoScroll() {
        if (executor != null) {
            executor.shutdownNow();
        }
    }

    private void initPagerData() {
        //设置每一个具体界面的样式
        viewList = new ArrayList<View>();

        View v1 = getLayoutInflater().inflate(R.layout.lead_1, null);
        imm1 = (ImageView) v1.findViewById(R.id.imageView_m1);
        imn1 = (ImageView) v1.findViewById(R.id.imageView_n1);
        tvm1 = (TextView) v1.findViewById(R.id.tv_m1);
        tvn1 = (TextView) v1.findViewById(R.id.tv_n1);
        tvm1.setText(weatherDataList.get(0).getDate() + "白天");
        tvn1.setText(weatherDataList.get(0).getDate() + "夜间");
        x.image().bind(imm1, weatherDataList.get(0).getDayPictureUrl());
        x.image().bind(imn1, weatherDataList.get(0).getNightPictureUrl());
        viewList.add(v1);
        View v2 = getLayoutInflater().inflate(R.layout.lead_2, null);
        imm2 = (ImageView) v2.findViewById(R.id.imageView_m2);
        imn2 = (ImageView) v2.findViewById(R.id.imageView_n2);
        tvm2 = (TextView) v2.findViewById(R.id.tv_m2);
        tvn2 = (TextView) v2.findViewById(R.id.tv_n2);
        tvm2.setText(weatherDataList.get(1).getDate() + "白天");
        tvn2.setText(weatherDataList.get(1).getDate() + "夜间");
        x.image().bind(imm2, weatherDataList.get(1).getDayPictureUrl());
        x.image().bind(imn2, weatherDataList.get(1).getNightPictureUrl());
        viewList.add(v2);
        View v3 = getLayoutInflater().inflate(R.layout.lead_3, null);
        imm3 = (ImageView) v3.findViewById(R.id.imageView_m3);
        imn3 = (ImageView) v3.findViewById(R.id.imageView_n3);
        tvm3 = (TextView) v3.findViewById(R.id.tv_m3);
        tvn3 = (TextView) v3.findViewById(R.id.tv_n3);
        tvm3.setText(weatherDataList.get(2).getDate() + "白天");
        tvn3.setText(weatherDataList.get(2).getDate() + "夜间");
        x.image().bind(imm3, weatherDataList.get(2).getDayPictureUrl());
        x.image().bind(imn3, weatherDataList.get(2).getNightPictureUrl());
        viewList.add(v3);
        View v4 = getLayoutInflater().inflate(R.layout.lead_4, null);
        imm4 = (ImageView) v4.findViewById(R.id.imageView_m4);
        imn4 = (ImageView) v4.findViewById(R.id.imageView_n4);
        tvm4 = (TextView) v4.findViewById(R.id.tv_m4);
        tvn4 = (TextView) v4.findViewById(R.id.tv_n4);
        tvm4.setText(weatherDataList.get(3).getDate() + "白天");
        tvn4.setText(weatherDataList.get(3).getDate() + "夜间");
        x.image().bind(imm4, weatherDataList.get(3).getDayPictureUrl());
        x.image().bind(imn4, weatherDataList.get(3).getNightPictureUrl());
        viewList.add(v4);
    }

    private void initLeadPoints() {
        points[0] = (ImageView) findViewById(R.id.iv_p1);
        points[1] = (ImageView) findViewById(R.id.iv_p2);
        points[2] = (ImageView) findViewById(R.id.iv_p3);
        points[3] = (ImageView) findViewById(R.id.iv_p4);
    }

    private void setPoint(int index) {
        for (int i = 0; i < points.length; i++) {
            if (i == index) {
                points[i].setAlpha(255);
            } else {
                points[i].setAlpha(100);
            }
        }
    }

    /**
     * 当界面切换后调用
     */
    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        /**当界面切换后调用*/
        @Override
        public void onPageSelected(int arg0) {
            setPoint(arg0);
            currentItem = arg0;

            startAutoScroll(); // 手动切换完成后恢复自动播放

        }

        /**界面切换时调用*/
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        /**滑动状态变化时调用*/
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

    };


    private void openSelect() {
        Toast.makeText(this, "选择城市", Toast.LENGTH_SHORT).show();

    }

    private void openIndex() {
        Toast.makeText(this, "当日数据", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(this,IndexActivity.class);
        Bundle bundle=new Bundle();

        for(int i = 0; i < indexList.size(); i++){
            bundle.putString("title"+i,indexList.get(i).getTitle());
            bundle.putString("zs"+i,indexList.get(i).getZs());
            bundle.putString("tipt"+i,indexList.get(i).getTipt());
            bundle.putString("des"+i,indexList.get(i).getDes());
        }

        intent.putExtras(bundle);
        startActivity(intent);

    }
}
