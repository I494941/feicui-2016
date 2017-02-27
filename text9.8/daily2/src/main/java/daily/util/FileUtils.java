package daily.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by 王金飞 on 2016/10/11.
 */
public class FileUtils {

    public static String readFile(String filePath, String fileName) {
        File file = null;
        if (filePath == null) {
            file = new File(fileName);
        } else {
            file = new File(filePath, fileName);
        }

        StringBuilder sb = new StringBuilder();

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String strLine = "";

            while (strLine != null) {
                strLine = br.readLine();

                if (strLine != null) {
                    sb.append(strLine + "\r\n");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
