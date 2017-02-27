import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/8.
 */
public class t5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("输入第几名：");
        int a = input.nextInt();
        switch(a){

            case 1:
                System.out.println("麻省理工夏令营");
                break;
            case 2:
                System.out.println("惠普笔记本");
                break;
            case 3:
                System.out.println("移动硬盘");
                break;
            default:
                System.out.println("Nothing!");
                break;

        }

    }
}
