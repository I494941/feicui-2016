import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/9.
 */
public class t3 {
    public static void main(String[] args) {
        //连续输入，输出最大、最小值
        Scanner input = new Scanner(System.in);
        System.out.println("请输入：");
        int a = input.nextInt();
        int b = a;
        int c = a;

        if (c == 0) {
            System.out.println("最大值：" + a);
            System.out.println("最小值：" + b);
        } else {

            for(;c!=0;) {
                System.out.println("请输入：");
                c = input.nextInt();
                if (c > a) {
                    a = c;
                }
                if (c < b) {
                    b = c;
                } ;
            }
            System.out.println("最大值：" + a);
            System.out.println("最小值：" + b);
        }
    }
    }
