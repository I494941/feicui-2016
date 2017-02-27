package android.wjf.android06.feicuiedu.com.weather;

/**
 * Created by ad06-wjf on 2016/12/22.
 */

public class WeatherData {

    private String date;
    private String dayPictureUrl;
    private String nightPictureUrl;
    private String weather;
    private String wind;
    private String temperature;

    public WeatherData(String date, String dayPictureUrl, String nightPictureUrl, String weather, String wind, String temperature) {
        this.date = date;
        this.dayPictureUrl = dayPictureUrl;
        this.nightPictureUrl = nightPictureUrl;
        this.weather = weather;
        this.wind = wind;
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public String getDayPictureUrl() {
        return dayPictureUrl;
    }

    public String getNightPictureUrl() {
        return nightPictureUrl;
    }

    public String getWeather() {
        return weather;
    }

    public String getWind() {
        return wind;
    }

    public String getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "WeatherData [date=" + date + ",dayPictureUrl=" + dayPictureUrl + ", nightPictureUrl=" + nightPictureUrl + "," +
                " weather=" + weather + ", wind=" + wind + ",temperature=" + temperature + "]";
    }
}
