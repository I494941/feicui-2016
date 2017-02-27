import java.io.*;

/**
 * Created by 王金飞 on 2016/9/29.
 */
public class TestIOByte {

    public static void main(String[] args) {

        // 复制文件
        // 把本地e:\\tmp\\sources\\source_file.txt文件
        // 复制到e:\\tmp\\target\\target_file.md文件中

        String s1 = "D:\\测试\\tmp1\\1\\1111.txt";
        String s2 = "D:\\测试\\tmp1\\2";
        String s3 = "target_file.txt";

        copyFileByte(s1, s2, s3);

    }

    /**
     * 复制文件字节流版本 *
     *
     * @param sourceFileName 源文件路径+名称 例如： e:\tmp\sources\source_file.txt
     * @param targetFilePath 目标路径 例如：e:\tmp\target
     * @param targerFileName 目标文件 例如： target_file.md
     */

    public static void copyFileByte(String sourceFileName, String targetFilePath, String targerFileName) {
        /**


         找到一个要操作的资源，可能是文件，可能是其他的位置

         根据字节流或字符流的子类，决定输入及输出的位置

         进行读或写的操作

         关闭 */

        // 字节流版本
        // 复制的原理
        // 1.确认源文件的位置

        File sourceFile = new File(sourceFileName);

        // 2.建立目标目录和空的目标文件

        File targetDic = new File(targetFilePath);

        if (!targetDic.exists())

        {
            targetDic.mkdirs();
        }

        File targetFile = new File(targetDic, targerFileName);

        try

        {
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }

            // 3.把源文件的内容加载到输入流中

            // 创建输入流对象
            InputStream is = new FileInputStream(sourceFile);

            // 创建输出流对象
            OutputStream os = new FileOutputStream(targetFile);

            // 4.使用输出流把输入流的内容写到目标文件中
            int tmp = 0;
            while ((tmp = is.read()) != -1) {
                os.write(tmp);
            }

            // 关闭流
            os.flush();
            os.close();
            is.close();

        } catch (
                IOException e)

        {
            e.printStackTrace();
        }

    }
}

