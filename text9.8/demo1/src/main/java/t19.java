/**
 * Created by Administrator on 2016/9/9.
 */
public class t19 {

    // 求 10000以内所有的奇数，偶数，质数，合数的，和，积，平均值
    public static void main (String[] args) {

        // 奇数的输出
        int output_sum_1 = 0;
        int output_product_1 = 1;
        int output_avg_1 = 0;
        int count_1 = 0;

        // 偶数的输出
        int output_sum_2 = 0;
        int output_product_2 = 1;
        int output_avg_2 = 0;
        int count_2 = 0;

        // 质数的输出
        int output_sum_3 = 0;
        int output_product_3 = 1;
        int output_avg_3 = 0;
        int count_3 = 0;

        // 合数的输出
        int output_sum_4 = 0;
        int output_product_4 = 1;
        int output_avg_4 = 0;
        int count_4 = 0;

        // 先获得10000以内的所有的奇数
        for (int i = 1; i < 10001; i++) {
            if (i % 2 == 1) {
                // 此时的i 就是奇数
                output_sum_1 = output_sum_1 + i;
                output_product_1 = output_product_1 * i;
                count_1++;
            } else {
                // 此时的i 就是偶数
                output_sum_2 = output_sum_2 + i;
                output_product_2 = output_product_2 * i;
                count_2++;
            }

            // 质数是能且仅能被1和自身整数的整数
            if (i > 1) {
                int remainder_count = 0;
                for (int j = i; j > 0; j--) {
                    if (i % j == 0) {
                        remainder_count++;
                    }
                }

                if (remainder_count == 2) {
                    // 此时 i 质数
                    output_sum_3 = output_sum_3 + i;
                    output_product_3 = output_product_3 * i;
                    count_3++;
                }
                if (remainder_count > 2) {
                    // 此时 i 合数
                    output_sum_4 = output_sum_4 + i;
                    output_product_4 = output_product_4 * i;
                    count_4++;
                }


            }
        }

        output_avg_1 = output_sum_1 / count_1;
        output_avg_2 = output_sum_2 / count_2;
        output_avg_3 = output_sum_3 / count_3;
        output_avg_4 = output_sum_4 / count_4;

        System.out.println("奇数:");
        System.out.println("和:" + output_sum_1);
        System.out.println("积:" + output_product_1);
        System.out.println("平均值:" + output_avg_1);
        System.out.println("******************");
        System.out.println("偶数:");
        System.out.println("和:" + output_sum_2);
        System.out.println("积:" + output_product_2);
        System.out.println("平均值:" + output_avg_2);
        System.out.println("******************");
        System.out.println("质数:");
        System.out.println("和:" + output_sum_3);
        System.out.println("积:" + output_product_3);
        System.out.println("平均值:" + output_avg_3);
        System.out.println("******************");
        System.out.println("合数:");
        System.out.println("和:" + output_sum_4);
        System.out.println("积:" + output_product_4);
        System.out.println("平均值:" + output_avg_4);
        System.out.println("******************");
    }
}
