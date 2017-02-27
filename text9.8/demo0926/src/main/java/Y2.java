import java.util.Arrays;
import java.util.Random;

/**
 * Created by 王金飞 on 2016/9/26.
 */
public class Y2 {

    public static  void main(String[] args){

        Random rd = new Random();
        int[] i = new int[7];
        boolean bln = true;
        do{
            int num = rd.nextInt(35);
            if (num != 0){
                bln = false;
                i[0] = num;
            }
        }while(bln);
        System.out.println("i[0]="+i[0]);

        for(int j = 1;j < 7;j++){
            int k;
            bln = false;
            do{              //有问题
                k = rd.nextInt(35);
                System.out.println("k = "+k);
                for(int num1 = 0;num1 <= j;num1++){
                    if(k == i[num1] || k == 0){
                        bln = true;
                    }
                }

            }while( bln);
            i[j] = k;
        }

      Arrays.sort(i);

        System.out.println("蓝球：");
       for(int tmp:i){
           System.out.print(tmp+",");
       }
        System.out.println("");
        System.out.print("红球：");
        System.out.print(rd.nextInt(16));


    }
}
