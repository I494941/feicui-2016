package Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王金飞 on 2016/9/30.
 */
public class FileUtils {

    public static Map<String,String> getConfigMap() {

        File file = new File("config.txt");
        Map<String,String> configMap =new HashMap<String, String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String strLine = "";
            while(true) {

                strLine = br.readLine();
                if (strLine == null) {
                    break;
                }

                String[] lines = strLine.split("=");

                String key = lines[0];
                String value = lines[1];
                configMap.put(key,value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return configMap;
    }
}
