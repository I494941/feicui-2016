import java.io.File;
import java.io.IOException;

/**
 * Created by 王金飞 on 2016/9/29.
 */
public class TestFileDoc {

    public static void main(String[] args) {

        // 创建一个File对象
        File file = new File("D:\\测试\\tmp");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 判断 file 是文件夹还是文件
        boolean bln = file.isDirectory();
        boolean bln1 = file.isFile();

        // 所谓的修改文件的名称，实际上是先把源文件内容复制到一个新名称的新文件中，
        // 然后把源文件给删除
        file.renameTo(new File("D:\\测试\\tmp","不爱国.doc"));

        // 获取file的名字
        System.out.println("文件的（绝对）路径:" + file.getAbsolutePath());
        System.out.println("文件的名字:" + file.getName());
        System.out.println("是否是目录：" + bln + "|是否是文件:" + bln1);
    }

}
