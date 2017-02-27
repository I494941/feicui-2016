package Daily;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/9/30.
 */
public class Check {

    public static void check() {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入姓名：");
        String inputName = sc.next();

        System.out.println("请输入密码：");
        String inputPassword = sc.next();

        boolean bln = false;
        StringBuffer sb = new StringBuffer();

        sb.append(" select * from user_ where name = \"");
        sb.append(inputName + "\" and password = \"" + inputPassword + "\"");


        List<Map<String, Object>> list = Test.DBUtils.queryUserResult(sb.toString());

        if (list.isEmpty()) {
            bln = false;
        } else {
            bln = true;
        }

        if (bln) {

            System.out.println("****************");
            System.out.println("*  1.查看日报  *");
            System.out.println("*  2.写新日报  *");
            System.out.println("*  3.删除日报  *");
            System.out.println("****************");

        } else {
            boolean bln1 = false;
            StringBuffer sb1 = new StringBuffer();

            sb1.append(" select * from user_ where name = \"");
            sb1.append(inputName + "\"");


            List<Map<String, Object>> list1 = Test.DBUtils.queryUserResult(sb1.toString());

            if (list1.isEmpty()) {
                System.out.println("用户名不存在，请先注册。");
                WelcomePage.show();
            } else {

                System.out.println("密码错误，请选择：");
                System.out.println("1：重新输入  其他：退出");
                String input = sc.next();

                if (input.equals("1")) {

                    Check.check();
                }
            }
        }
    }
}
