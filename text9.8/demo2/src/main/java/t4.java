import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/9.
 */
public class t4 {
    public static void main(String[] args) {
        //乘法表
        int i = 1;
        int j = 1;
        for (;i < 10;i++){
            for(;j <= i;j++){
                System.out.print(i+"X"+j+"="+i*j+" ");
            }
            j=1;
            System.out.println(" ");
        }
        //加法表
         i = 1;
         j = 1;
        for (;i < 10;i++){
            for(;j <= i;j++){
                int sum = i + j ;
                System.out.print(i+"+"+j+"="+sum+" ");
            }
            j=1;
            System.out.println(" ");
        }



        }


}
