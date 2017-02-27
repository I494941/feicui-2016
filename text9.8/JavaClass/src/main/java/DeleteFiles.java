import java.io.File;

/**
 * Created by 王金飞 on 2016/9/29.
 */
public class DeleteFiles {

    public static void main(String[] args) {

        File file = new File("D:\\测试\\tmp");

        testFile(file);
    }

    public static void testFile(File file) {

        //System.out.println(file.getName());
        if(file.isFile()){

            file.delete();
        }
        if (file.isDirectory()) {

            File[] strNames = file.listFiles();
            if (strNames != null && strNames.length > 0) {
                for (File fileName : strNames) {
                    testFile(fileName);
                    file.delete();
                }
            }
        }
    }
}
