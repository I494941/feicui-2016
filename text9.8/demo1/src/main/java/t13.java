import java.math.BigInteger;

/**
 * Created by Administrator on 2016/9/8.
 */
//10000以内偶数之和(h)、积（bi）、平均值（h/c）
public class t13 {
    public static void main(String[] args) {
        int s = 1;
        int h = 0;
        BigInteger bi = new BigInteger("1");
        int d = 1;
        int c = 0;
        for(;s < 10001 ;s++){
            if( s % 2 == 0){
                h = h + s;
                bi = bi.multiply(new BigInteger(String.valueOf(s)));
                d = d * s;
                c++;
            }
        }

        System.out.println(h);
        System.out.println(bi.toString());
        System.out.println(h/c);
        System.out.println(d);
    }
}
