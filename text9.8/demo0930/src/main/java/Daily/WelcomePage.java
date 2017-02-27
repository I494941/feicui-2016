package Daily;

import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/9/30.
 */
public class WelcomePage {

    public static void show(){

        boolean bln = false;
        do {
            System.out.println("****************");
            System.out.println("*  翡翠欢迎您  *");
            System.out.println("****************");
            System.out.println("");
            System.out.println("请选择操作类型：");
            System.out.println("****************");
            System.out.println("1.直接登录");
            System.out.println("2.注册用户");

            Scanner sc = new Scanner(System.in);

            String input1 = sc.next();

            if (input1.equals("1")) {

                Check.check();
            } else if (input1.equals("2")) {

                Register.register();
                WelcomePage.show();
            } else {
                System.out.println("选择错误，请重新输入！");
                bln = true;
            }
        }while(bln);




    }
}
