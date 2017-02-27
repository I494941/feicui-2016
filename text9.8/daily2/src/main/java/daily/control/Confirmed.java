package daily.control;

import daily.Welcome;
import daily.pojo.User;
import daily.util.FileUtils;

import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/10/12.
 */
public class Confirmed {

    //登录成功
    public void confirmed(User user) {

        Scanner sc = new Scanner(System.in);
        FileUtils fileUtils = new FileUtils();
        String filePath = "D:\\develop\\JetBrains\\IdeaProjects\\text9.8\\daily\\src\\main\\resources";
        String fileName = "operate_item.txt";
        String s = fileUtils.readFile(filePath, fileName);
        System.out.println(s);

        int input = sc.nextInt();

        if (input == 1) {

            //查看日志

            new Check().check();

        } else if (input == 2) {

            //新增日志

            new WriteDaily().writeDaily(user);

        } else if (input == 3) {

            //切换用户
            new Welcome().show();
        } else {

            //退出程序
            System.exit(-1);
        }

    }
}
