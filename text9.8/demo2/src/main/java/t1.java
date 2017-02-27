import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/9.
 */
public class t1 {
    public static void main(String[] args) {

    //重复输入，直到正确
        Scanner input = new Scanner(System.in);
        System.out.println("*************");
        System.out.println("1:");
        System.out.println("2:");
        System.out.println("3:");
        System.out.println("4:");
        System.out.println("*************");
        System.out.println("请输入：");
        int a = input.nextInt();
        for(;a!=1&&a!=2&&a!=3&&a!=4;){
            System.out.println("输入有误！");
            System.out.println("请重新输入：");
            a = input.nextInt();
        }
        if (a == 1) {
            System.out.println("1：");
        }
        else if(a == 2) {
            System.out.println("2：");
        }
        else if (a == 3) {
            System.out.println("3：");
        }
        else if(a == 4) {
            System.out.println("4：");
        }


        }

    }
