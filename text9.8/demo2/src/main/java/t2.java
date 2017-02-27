import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/9.
 */
//输出位数
public class t2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入：");
        int a = input.nextInt();
        int n = 1;
        if(a/10==0) {
            System.out.println(n);
        }
        else  {
            for (; a / (10 ^ n) >= 10; n++) {
                a=a/(10^n);
            }
            System.out.println(n+1);
        }



    }
}
