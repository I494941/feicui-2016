package daily;

import daily.control.Confirm;
import daily.control.Register;
import daily.util.FileUtils;

import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/10/11.
 */
public class Welcome {


    public void show() {

        FileUtils fileUtils = new FileUtils();
        String filePath = "D:\\develop\\JetBrains\\IdeaProjects\\text9.8\\daily\\src\\main\\resources";
        String fileName = "welcome.txt";
        String s = fileUtils.readFile(filePath, fileName);
        Scanner scanner = new Scanner(System.in);

        boolean bln = false;
        do {
            System.out.println(s);
            int input = scanner.nextInt();

            if (input == 1) {
                //登录
                new Confirm().confirm();
            } else if (input == 2) {
                //注册
                new Register().register();
                //注册完显示欢迎页面
                new Welcome().show();
            } else if (input == 3) {
                //退出
                System.exit(-1);
            } else {
                System.out.println("选择错误，请重新输入！");
                bln = true;
            }

        } while (bln);
    }
}
