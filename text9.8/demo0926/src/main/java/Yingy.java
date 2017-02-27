import java.util.Arrays;
import java.util.Random;

/**
 * Created by 王金飞 on 2016/9/26.
 */
public class Yingy {

    public static  void main(String[] args){

        Random rd = new Random();
        int[] array = new int[7];
        boolean bln = true;
        //随机第一个数，不能为0
        do{
            int num = rd.nextInt(35);
            if (num != 0){
                bln = false;
                array[0] = num;
            }
        }while(bln);
        //随机其他6个数字，
        for (int index = 0;index < 7; ) {
            int number ;
            number = rd.nextInt(35);
             bln = true;
            for(int index1 =0; index1<array.length;index1 ++) {
                //要存的随机数不能与前面的数相同
                if (number == array[index1]) {
                    bln = false;
                    break;
                }
            }
            //并且不能为0
            if (number > 0 && bln) {

                array[index] = number;
                index ++;
            }
        }
        //数组重新排序
        Arrays.sort(array);

        //打印
        System.out.println("蓝球：");
        for (int tmp:array) {
            System.out.print(tmp+",");
        }
        System.out.println("");
        System.out.print("红球：");
        System.out.print(rd.nextInt(16));


    }
}
