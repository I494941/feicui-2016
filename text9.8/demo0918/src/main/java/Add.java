import java.util.Scanner;

/**
 * Created by 王金飞 on 2016/9/18.
 */
public class Add {

    public int sum(int p_a,int p_b){
        int a =  p_a;
        int b =  p_b;
        int sum = a + b;
        return sum;
    }
    public double sum(double p_a,double p_b){
        double a =  p_a;
        double b =  p_b;
        double sum = a + b;
        return sum;
    }
    public String sum(String p_a,String p_b){
        String a =  p_a;
        String b =  p_b;
        String sum = a + b;
        return sum;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Add add = new Add();
        System.out.println("输入int a：");
        int inputa = scanner.nextInt();
        System.out.println("输入int b：");
        int inputb = scanner.nextInt();
        int sum = add.sum(inputa,inputb);
        System.out.println("sum = "+sum);


        System.out.println("输入double a：");
        double inputa2 = scanner.nextDouble();
        System.out.println("输入double b：");
        double inputb2 = scanner.nextDouble();
        double sum2 = add.sum(inputa2,inputb2);
        System.out.println("sum2 = "+sum2);

        System.out.println("输入String a：");
        String inputa3 = scanner.next();
        System.out.println("输入String b：");
        String inputb3 = scanner.next();
        String sum3 = add.sum(inputa3,inputb3);
        System.out.println("sum3 = "+sum3);
    }
}
