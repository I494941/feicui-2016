import java.util.Random;

/**
 * Created by 王金飞 on 2016/9/26.
 */
public class Ying {
   /* public static  void main(String[] args){

        Random rd = new Random();
        int[] i = new int[7];
        i[0] = rd.nextInt(35);

        for(int j = 1;j < 7;j++){

            int k ;
            int num1 = 0;
            boolean bln = true;
            do{
                k = rd.nextInt(35) ;
                i[j] = k;
                num1 = 0;
                for(int num = 0;num<=j;num++){
                    if( i[j] ==  i[num]){
                        num1++;
                    }
                }
                if(num1>0){
                    bln = false;
                }

            }while(bln);

        }

        System.out.println("蓝球：");
        System.out.print(i[0]);
        for(int j = 1;j < 7;j++){

            System.out.print(","+i[j]);
        }
        System.out.println("");
        System.out.print("红球：");
        System.out.print(rd.nextInt(16));

    }*/
}
