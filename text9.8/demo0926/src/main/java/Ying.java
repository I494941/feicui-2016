import java.util.Random;

/**
 * Created by 王金飞 on 2016/9/26.
 */
public class Ying {
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

      for(int j = 1;j < 7;j++){
            int k;
            bln = true;
            do{
                k = rd.nextInt(35);
                for(int num1 = 0;num1 <= j;num1++){
                    if(k != i[num1]&& k != 0){
                        bln = false;
                    }
                }

            }while( bln);
            i[j] = k;
        }

            for(int num1 = 0; num1 < 7;num1++ ){

            for(int num2 = 1;num2 < 7;num2++){
                if(i[num2-1] > i[num2]){
                    int num3  ;
                    num3 = i[num2];
                    i[num2] = i[num2-1];
                    i[num2-1] = num3;
                }

            }
        }

        System.out.println("蓝球：");
        System.out.print(i[0]);
        for(int j = 1;j < 7;j++){

            System.out.print(","+i[j]);
        }
        System.out.println("");
        System.out.print("红球：");
        System.out.print(rd.nextInt(16));


    }
}
