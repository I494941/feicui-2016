/**
 * Created by Administrator on 2016/9/8.
 */
//画图
public class t18 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        for(;j<4;j++){

            for(;i<3-j;i++){
                System.out.print(" ");
            }
            for(;i<4+j;i++){
                System.out.print("*");
            }
            System.out.println(" ");
            i=0;
        }
        int a = 0,b = 0;
        for(;b<3;b++){

            for(;a<b+1;a++){
                System.out.print(" ");
            }
            for(;a<6-b;a++){
                System.out.print("*");
            }
            System.out.println(" ");
            a=0;
        }
        System.out.println(" ");

        System.out.println(" ");
        int h = 0,l = 0;
        for(;h < 6; h++) {
            for (; l < h + 1; l++) {
                System.out.print(" #");
            }
            System.out.println(" ");
            l=0;
        }


    }
}
