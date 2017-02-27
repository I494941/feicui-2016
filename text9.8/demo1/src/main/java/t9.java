/**
 * Created by Administrator on 2016/9/8.
 */
//100以内合数之和
public class t9 {
    public static void main(String[] args) {
        int s = 2;
        int h1 = 0;
        int h2 = 0;
        for(;s<100;s++){

            for(int i = 2;i <= s;i++){
                if(s % i == 0){
                    h2 = h2 + 1;
                }

            }
            if(h2 > 1){
                h1 = h1 + s;
            }
            h2 = 0;
        }
        System.out.println(h1);
    }
}
