import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/7.
 */
public class t4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("输入金额: ");
        int s = input.nextInt();
        Scanner input1 = new Scanner(System.in);
        System.out.print("选择:（1）会员 （2）不是会员 ");
        int b = input1.nextInt();
        double c;
        switch (b) {
            case 2:
                System.out.println("c= " + s * 0.95);
                break;
            default:
                Scanner input2 = new Scanner(System.in);
                System.out.print("输入积分: ");
                int d = input2.nextInt();
                int e = (d >= 8000) ? 1 : ((d >= 4000) ? 2 : ((d >= 2000) ? 3 : 4));
                switch (e) {
                    case 1:
                        System.out.println("c= " + s * 0.6);
                        break;
                    case 2:
                        System.out.println("c= " + s * 0.7);
                        break;
                    case 3:
                        System.out.println("c= " + s * 0.8);
                        break;
                    default:
                        System.out.println("c= " + s * 0.9);

                }
             }
        }

    }
