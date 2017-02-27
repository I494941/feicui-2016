import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/9/26.
 */
public class T2 {

    private static boolean isOk = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("请输入用户名：");
            String name = input.next();
            System.out.println("请输入密码：");
            String pwd1 = input.next();
            System.out.println("请再次输入密码：");
            String pwd2 = input.next();
            verify(name, pwd1, pwd2);
        } while (isOk);
    }

    public static void verify(String name, String pwd1, String pwd2) {

        if (name.length() > 3 && pwd1.length() > 6) {
            if (pwd1.equals(pwd2)) {
                System.out.println("注册成功：请牢记用户名和密码！");
                isOk = false;
            } else {
                System.out.println("两次输入的密码不相同！");
            }
        } else {
            System.out.println("用户名长度不能小于3，密码长度不能小于6！");
        }

    }
}
