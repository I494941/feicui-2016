import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/7.
 */
public class t3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入金额: ");
        int s = input.nextInt();
        Scanner input1 = new Scanner(System.in);
        System.out.print("选择:（1）会员 （2）不是会员 ");
        int b = input1.nextInt();
        double c;
        if (b == 2) {
                System.out.println("c= "+s*0.95);
        }
        else{
            Scanner input2 = new Scanner(System.in);
            System.out.print("输入积分: ");
            int d = input2.nextInt();
            if(d >= 8000){
                System.out.println("c= "+s*0.6);
            }
            else if(d >= 4000){
                System.out.println("c= "+s*0.7);
            }
            else if(d >= 2000){
                System.out.println("c= "+s*0.8);
            }
            else {
                System.out.println("c= "+s*0.9);
            }
        }
    }
}
