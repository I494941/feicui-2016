import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/7.
 */
public class t1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入金额: ");
        int s = input.nextInt();
        Scanner input1 = new Scanner(System.in);
        System.out.print("选择:（1）会员 （2）不是会员 ");
        int b = input1.nextInt();
        double c;
        if (b == 1 && s >= 200) {
            System.out.println("c= "+s*0.75);
        }
        else if(b == 1) {
            System.out.println("c= "+s*0.8);
        }
        else if(b == 2 && s >= 100) {
            System.out.println("c= "+s*0.9);
        }
        else{
            System.out.println("c= "+s);
        }
    }
}
