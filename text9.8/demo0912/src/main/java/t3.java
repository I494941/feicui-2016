import java.util.Scanner;

/**
 * Created by Administrator on 2016/9/12.
 */
public class t3 {
    public static void main(String[] args){
        int intArray[] = {3,8,9,10,4,9,25};
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要查询的数：");
        int is_member = scanner.nextInt();
        for(int i = 0;i < intArray.length;i++){
           if(intArray[i]==is_member){
               if(num == 0){

               System.out.println("该数字在第"+i+"位");
               }
               else{
                   System.out.println("第"+(num+1)+"个该数字在第"+i+"位");
               }

                num ++;

           }
        }
        if(num == 0){
            System.out.println("无效");
        }

    }
}
