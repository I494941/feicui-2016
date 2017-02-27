import java.util.Random;

/**
 * Created by 王金飞 on 2016/9/26.
 */
public class Y {

    public static  void main(String[] args){

        Random rd = new Random();

        int number = 0;

        int[] array = new int[7];

        for (int index = 0;index < 7; ) {

            number = rd.nextInt(35);
            boolean bln1 = true;

            for(int index1 =0; index1<array.length;index1 ++) {
                if (number == array[index1] ) {
                    bln1 = false;
                    break;
                }
            }

            if (number > 0 && bln1) {

                array[index] = number;
                index ++;
            }

        }

        for (int tmp:array) {
            System.out.println("tmp="+tmp);
        }

    }
}
