/**
 * Created by Administrator on 2016/9/8.
 */
//10000以内能被13和15同时整除的数字之和
public class t17 {
    public static void main(String[] args) {
        int i = 1;
        int h = 0;
        for (; i < 100001; i++) {

            if ((i % 13 == 0) && (i % 15 == 0)) {
                h = h + i;
            }
        }
        System.out.println(h);
    }

}
