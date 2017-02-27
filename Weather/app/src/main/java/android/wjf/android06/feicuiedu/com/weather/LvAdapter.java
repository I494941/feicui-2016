package android.wjf.android06.feicuiedu.com.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangjinfei on 16/12/25.
 */

public class LvAdapter extends BaseAdapter {

    private List<WeatherData> list;
    private Context context;

    public LvAdapter(List<WeatherData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private LayoutInflater lif;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public WeatherData getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        lif = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder vh = null;

        WeatherData weatherData = getItem(i);


        if (view == null) {

            view = lif.inflate(R.layout.item_layout, null);
            vh = new ViewHolder();
            vh.tvDate = (TextView) view.findViewById(R.id.tv_date);
            vh.tvWeather = (TextView) view.findViewById(R.id.tv_weather);
            vh.tvWind = (TextView) view.findViewById(R.id.tv_wind);
            vh.tvTemperature = (TextView) view.findViewById(R.id.tv_temperature);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.tvDate.setText(weatherData.getDate());
        vh.tvWeather.setText(weatherData.getWeather());
        vh.tvWind.setText(weatherData.getWind());
        vh.tvTemperature.setText(weatherData.getTemperature());

        return view;
    }

    private static class ViewHolder {
        TextView tvDate;
        TextView tvWeather;
        TextView tvWind;
        TextView tvTemperature;
    }
}

