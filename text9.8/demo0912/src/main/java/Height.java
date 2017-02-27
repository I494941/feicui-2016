import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/13.
 */
public class Height {
    public void heightAvg(){
        int num = 0;
        double heightStu;
        double sum = 0;
        double avg;
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            num++;
            System.out.print("请输入第"+ num +"名学生的身高(cm):");
            heightStu = scanner.nextDouble();
            sum = sum + heightStu;
            System.out.print("继续输入吗？（y/n）");
            input = scanner.next();
        } while (input.equals("y"));
        avg = sum / num;
        System.out.print("这"+ num +"名学生的平均身高为"+ avg +"cm");
    }
    public static void main(String[] args) {
        Height height = new Height();
        height.heightAvg();
    }
}
