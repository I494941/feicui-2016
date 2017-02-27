import java.io.File;
import java.io.IOException;

/**
 * Created by 王金飞 on 2016/9/29.
 */
public class TestFile {

    public static void main(String[] args) {

        // 创建一个File对象
        File file = new File("D:\\测试\\tmp1//hrhr.doc");

       /* if(!file.exists()) {
            file.mkdirs();
        }*/

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 判断 file 是文件夹还是文件
        boolean bln = file.isDirectory();
        boolean bln1 = file.isFile();

        // 修改文件夹是将文件夹改名
       // file.renameTo(new File("D:\\tmp"));

        // 获取file的名字
        System.out.println("文件的（绝对）路径:" + file.getAbsolutePath());
        System.out.println("文件的名字:" + file.getName());
        System.out.println("是否是目录：" + bln + "|是否是文件:" + bln1);

    }
}
