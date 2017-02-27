import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/9.
 */
public class t5 {
    public static void main(String[] args){

        //2. 输出　100 -- 999之间, 所有个位为7的数

       /* int i = 100;
        for (;i<1000;i++){
            int a = i % 100;
            int g = a % 10;
            if (g == 7){
                System.out.println(i);
            }
        }
        */

        //3.. 输出  100 -- 999之间, 所有百位 + 十位 == 个位　的数
        /*
        int i = 100;
        for (;i<1000;i++){
            int a = i % 100;
            int g = a % 10;
            int b = i / 100;
            int s = a /10;
            if (b + s == g ){
                System.out.println(i);
            }
        }
        */
        //4. 输出 10 - 99 之间所有“相邻”的值,如: 23, 54, 98
        /*
        int i = 10;

        for(;i < 100;i++) {
            int s = i / 10 ;
            int g = i % 10;
            if (s - g == 1 || g - s == 1) {
                System.out.println(i);
            }
        }
        */
        //3个班级各4名学员参赛，计算每个班级参赛学员的平均分
        int i = 1;
        int j = 1;
        int sum = 0;
        int avg = 0;
        for (;i < 4;i++){
                System.out.println("请输入第"+i+"个班级的成绩：");
            for(;j < 5;j++){
                Scanner input = new Scanner(System.in);
                System.out.print("第"+j+"个学生的成绩：");
                int score = input.nextInt();
                sum = sum + score;
            }
            avg = sum / 4;
            j=1;
            sum = 0;
            System.out.println("第"+i+"个班级的平均成绩："+avg);
            System.out.println("  ");
        }



    }
}
