/**
 * Created by Administrator on 2016/9/8.
 */
        //100以内奇数之和
public class t10 {
    public static void main(String[] args) {
        int s = 1;
        int h = 0;
        for(;s < 101 ;s+=2){
            h = h +s;
        }

        System.out.println(h);
    }
}
