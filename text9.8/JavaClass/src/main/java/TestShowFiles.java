import java.io.File;

/**
 * Created by 王金飞 on 2016/9/29.
 */
public class TestShowFiles {

    public static void main(String[] args) {

        // 创建一个File对象
        File file = new File("D:\\测试\\tmp");

        testFile(file);
    /*
    // 列出file文件及所有子文件夹下的所有的文件的名字
    String[] strNames = file.list();

    for (String fileName:strNames) {
        File tmpFile = new File(file.getAbsolutePath(),fileName);

        // 判断是否为目录，如果是目录的话，那么就去看看它下面有没有文件，有文件的话，就
        // 列出来，没有的话就不用列出来
        if (!tmpFile.isFile()) {
            String[] strNames1 = tmpFile.list();
            if(strNames1 != null && strNames1.length > 0) {
                for (String fileName1:strNames1) {
                    System.out.println(fileName1);
                }
            }
        }
        System.out.println(fileName+"是否为文件"+tmpFile.isFile());
    }*/
    }

    public static void testFile(File file) {
        // 判断file是文件还是文件夹
        // 如果是文件的话

        System.out.println(file.getName());

        if (file.isFile()) {
            //System.out.println(file.getName());
        }

        if (file.isDirectory()) {
            //System.out.println(file);

            File[] strNames = file.listFiles();
            if (strNames != null && strNames.length > 0) {
                for (File fileName : strNames) {

                    testFile(fileName);
                }
            }

        }
    }
}

