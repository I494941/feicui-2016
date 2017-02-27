import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王金飞 on 2016/10/13.
 */
public class NetTest {

    public static void main(String[] args) {

        try {

            //String url = "http://118.244.212.82:9092/newsClient/news_list";
            //String params = "ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";

            String url = "http://www.kuaidi100.com/query";
            String params = "type=shunfeng&postid=304312442400";


            URL strUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) strUrl.openConnection();
            httpURLConnection.setConnectTimeout(5000);

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod("GET");
            // httpURLConnection.setRequestMethod("POST");

            // 获取输出流
            OutputStream out = httpURLConnection.getOutputStream();
            out.write(params.getBytes());
            out.flush();

            if (httpURLConnection.getResponseCode() == 200) {

                InputStream is = httpURLConnection.getInputStream();

                byte[] data = read(is);
                String str = new String(data, "UTF-8");
                //System.out.println("str="+str);

                JSONObject jsonObject = new JSONObject(str);

                Map<String,Object> map = new HashMap<String,Object>();

                map.put("message",jsonObject.get("message"));
                map.put("nu",jsonObject.get("nu"));
                map.put("ischeck",jsonObject.get("ischeck"));
                map.put("com",jsonObject.get("com"));
                map.put("status",jsonObject.get("status"));
                map.put("condition",jsonObject.get("condition"));
                map.put("status",jsonObject.get("status"));

                JSONArray jsonArray = jsonObject.getJSONArray("data");
                List<Map<String,Object>> tmpList = new ArrayList<Map<String,Object>>();

                for (int i = 0; i <jsonArray.length() ; i++) {
                    JSONObject tmpObject = jsonArray.getJSONObject(i);

                    Map<String,Object> tmpMap = new HashMap<String,Object>();
                    tmpMap.put("time",tmpObject.get("time"));
                    tmpMap.put("context",tmpObject.get("context"));
                    tmpMap.put("ftime",tmpObject.get("ftime"));

                    tmpList.add(tmpMap);
                }

                map.put("data",tmpList);

                System.out.println(map);
            }
            else {
                System.out.println("连接失败");
            }

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 从流中读取数据
    public static byte[] read(InputStream inStream) throws Exception {
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
