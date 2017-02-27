import java.util.Arrays;

/**
 * Created by 王金飞 on 2016/9/27.
 */
public class TestArrays {

    public static void main(String[] args) {

        int[] array = new int[]{9,8,7,6,5,4,3,2,1};


        /*
        public static void sort(int[] a)对指定的 int 型数组按数字升序进行排序。
        该排序算法是一个经过调优的快速排序法，
        改编自 Jon L. Bentley 和 M. Douglas McIlroy 合著的
        Engineering a Sort Function", Software-Practice and Experience Vol. 23(11) P. 1249-1265 (November 1993)。
        此算法在许多数据集上提供 n*log(n) 性能，这导致其他快速排序会降低二次型性能。

        参数：
        a - 要排序的数组
        */

        System.out.println("sort前");
        for (int tmp:array) {
            System.out.print(tmp+",");
        }
        System.out.println("");

        Arrays.sort(array);

        System.out.println("sort后");
        for (int tmp:array) {
            System.out.print(tmp+",");
        }








    }
}
