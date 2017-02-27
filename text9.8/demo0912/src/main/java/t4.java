/**
 * Created by Administrator on 2016/9/12.
 */
public class t4 {
    public static void main(String[] args){
        int intArray[] = new int [140];
        intArray[0] = 1;
        intArray[1] = 1;
        for(int i = 2;i <138;i++){
            intArray[i] =  intArray[i-1] +  intArray[i-2];
        }
        System.out.println(intArray[136]);
    }
}
