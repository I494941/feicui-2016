import java.math.BigInteger;

/**
 * Created by Administrator on 2016/9/8.
 */
////10000以内合数之和(h1)、积（bi）、平均值（h/c）
public class t15 {
    public static void main(String[] args) {
        int s = 2;
        int h1 = 0;
        int h2 = 0;
        BigInteger bi = new BigInteger("1");
        int h3 = 1;
        int c = 0;
        for(;s<10001;s++){
            for(int i = 2;i <= s;i++){
                if(s % i == 0){
                    h2 = h2 + 1;//如果h2小于1，则为质数
                }
            }
            if(h2 > 1){
                h1 = h1 + s;
                bi = bi.multiply(new BigInteger(String.valueOf(s)));
                h3 = h3 * s;
                c++;
            }
            h2 = 0;
        }
        System.out.println(h1);
        System.out.println(bi);
        System.out.println(h1/c);
        System.out.println(h3);

    }
}

