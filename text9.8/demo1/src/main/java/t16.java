/**
 * Created by Administrator on 2016/9/8.
 */
//10000以内能被137整除的偶数、奇数之和（ho、hj）
public class t16 {
    public static void main(String[] args) {
        int i = 1;
        int hj = 0;
        int ho = 0;
        for(;i < 100001;i++){

        if( (i % 137 == 0) &&(i % 2 ==0)){
            ho = ho + i;
        }
        if( (i % 137 == 0) && (i % 2 ==1)){
            hj = hj + i;
        }
        }
        System.out.println(hj);
        System.out.println(ho);


    }

}
