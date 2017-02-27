import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/9/26.
 */
public class Register {


    public static void main(String[] args){

        String name,key,key1;

        System.out.println("***欢迎进入注册系统***");
        System.out.println(" ");
        Scanner input = new Scanner(System.in);
        boolean bln = true;

        do {
            System.out.print("请输入用户名：");
            name = input.next();
            System.out.print("请输入密码：");
            key = input.next();
            System.out.print("请再次输入密码：");
            key1 = input.next();
            if (name.length() < 3 || key.length() < 6) {

                System.out.println("用户名长度不小于3，密码长度不小于6");
            }
            else if(!(key.equals(key1))){
                System.out.println("两次输入的密码不同");
            }
            else{
                bln = false;
            }

        }while(bln);

        System.out.println("注册成功，牢记用户名与密码！");

    }
}
