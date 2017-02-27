import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/8.
 */
public class t6 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("输入消费金额：");
        int a = input.nextInt();
        if  (a <= 0){
            System.out.println("输入有误！");
        }
        else if  (a < 50){
            System.out.println("本次消费总金额："+a);
            }
        else if (a < 100){
            System.out.println("是否参加换购：");
            System.out.println("1：满50元，加2元换购百事可乐1瓶");
            System.out.println("0：不换购");
            int b = input.nextInt();
            switch(b){
                case 0:
                    System.out.println("本次消费总金额："+a);
                    break;
                case 1:
                    a = a+2;
                    System.out.println("本次消费总金额："+a);
                    System.out.println("成功换购百事可乐1瓶");
                    break;
                default:
                    System.out.println("选择有误！");
                    break;
            }
        }
        else if (a < 200){
            System.out.println("是否参加换购：");
            System.out.println("1：满50元，加2元换购百事可乐1瓶");
            System.out.println("2：满100元，加3元换购可乐1瓶");
            System.out.println("3：满100元，加10元换购5公斤面粉");
            System.out.println("0：不换购");
            int b = input.nextInt();
            switch(b){
                case 0:
                    System.out.println("本次消费总金额："+a);

                    break;
                case 1:
                    a = a+2;
                    System.out.println("本次消费总金额："+a);
                    System.out.println("成功换购百事可乐1瓶");
                    break;
                case 2:
                    a = a+3;
                    System.out.println("本次消费总金额："+a);
                    System.out.println("成功换购可乐1瓶");
                    break;
                case 3:
                    a = a+10;
                    System.out.println("本次消费总金额："+a);
                    System.out.println("成功换购面粉5斤");
                    break;
                default:
                    System.out.println("选择有误！");
                    break;
            }
        }
        else {
            System.out.println("是否参加换购：");
            System.out.println("1：满50元，加2元换购百事可乐1瓶");
            System.out.println("2：满100元，加3元换购可乐1瓶");
            System.out.println("3：满100元，加10元换购5公斤面粉");
            System.out.println("4：满200元，加10元换购炒锅");
            System.out.println("5：满200元，加20元换购爽肤水");
            System.out.println("0：不换购");
            int b = input.nextInt();
            switch(b){
                case 0:
                    System.out.println("本次消费总金额："+a);

                    break;
                case 1:
                    a = a+2;
                    System.out.println("本次消费总金额："+a);
                    System.out.println("成功换购百事可乐1瓶");
                    break;
                case 2:
                    a = a+3;
                    System.out.println("本次消费总金额："+a);
                    System.out.println("成功换购可乐1瓶");
                    break;
                case 3:
                    a = a+10;
                    System.out.println("本次消费总金额："+a);
                    System.out.println("成功换购面粉5斤");
                    break;
                case 4:
                    a = a+10;
                    System.out.println("本次消费总金额："+a);
                    System.out.println("成功换购炒锅");
                    break;
                case 5:
                    a = a+20;
                    System.out.println("本次消费总金额："+a);
                    System.out.println("成功换购爽肤水");
                    break;
                default:
                    System.out.println("选择有误！");
                    break;
            }

        }

        }
}
